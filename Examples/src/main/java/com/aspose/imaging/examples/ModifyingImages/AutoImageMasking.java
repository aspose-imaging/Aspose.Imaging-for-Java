package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.masking.ImageMasking;
import com.aspose.imaging.masking.options.AutoMaskingArgs;
import com.aspose.imaging.masking.options.MaskingOptions;
import com.aspose.imaging.masking.options.SegmentationMethod;
import com.aspose.imaging.masking.result.MaskingResult;
import com.aspose.imaging.sources.StreamSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mfazi
 */
public class AutoImageMasking
{

    public static void main(String[] args) throws IOException
    {
        Logger.startExample("AutoImageMasking");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String sourceFileName = dataDir + "Colored by Faith_small.png";

        String inputPointsFileName = dataDir + "Java_ColoredByFaith_small.dat";
        AutoMaskingArgs maskingArgs = new AutoMaskingArgs();
        fillInputPoints(inputPointsFileName, maskingArgs);
        String outputFileName = Utils.getOutDir() + "Colored by Faith_small_auto.png";
        try (RasterImage image = (RasterImage) Image.load(sourceFileName))
        {
            MaskingOptions maskingOptions = new MaskingOptions();
            maskingOptions.setMethod(SegmentationMethod.GraphCut);
            maskingOptions.setArgs(maskingArgs);
            maskingOptions.setDecompose(false);
            PngOptions options = new PngOptions();
            options.setColorType(PngColorType.TruecolorWithAlpha);
            options.setSource(new StreamSource());
            maskingOptions.setExportOptions(options);
            try (MaskingResult maskingResults = new ImageMasking(image).decompose(maskingOptions))
            {
                try (Image resultImage = maskingResults.get_Item(1).getImage())
                {
                    resultImage.save(outputFileName);
                }
            }
        }
        Logger.endExample();
    }

    //ExStart:fillInputPoints
    private static void fillInputPoints(String filePath, AutoMaskingArgs autoMaskingArgs) throws IOException
    {

        try (InputStream inputStream = new FileInputStream(filePath))
        {
            LEIntegerReader reader = new LEIntegerReader(inputStream);
            boolean hasObjectRectangles = inputStream.read() != 0;
            boolean hasObjectPoints = inputStream.read() != 0;
            autoMaskingArgs.setObjectsRectangles(null);
            autoMaskingArgs.setObjectsPoints(null);
            if (hasObjectRectangles)
            {
                int len = reader.read();
                Rectangle[] rects = new Rectangle[len];
                for (int i = 0; i < len; i++)
                {
                    // firstly Y
                    int y = reader.read();
                    // secondly X
                    int x = reader.read();
                    // width
                    int width = reader.read();
                    // height
                    int height = reader.read();
                    rects[i] = new Rectangle(x, y, width, height);
                }
                autoMaskingArgs.setObjectsRectangles(rects);
            }
            if (hasObjectPoints)
            {
                int len = reader.read();
                Point[][] points = new Point[len][];
                for (int i = 0; i < len; i++)
                {
                    int il = reader.read();
                    points[i] = new Point[il];
                    for (int j = 0; j < il; j++)
                    {
                        int x = reader.read();
                        int y = reader.read();
                        points[i][j] = new Point(x, y);
                    }
                }
                autoMaskingArgs.setObjectsPoints(points);
            }
        }
    }
    //ExEnd:FillInputPoints

    //ExStart:LEIntegerReader
    private static class LEIntegerReader
    {
        private final InputStream stream;
        private final byte[] buffer = new byte[4];

        LEIntegerReader(InputStream stream)
        {
            this.stream = stream;
        }

        int read() throws IOException
        {
            int len = stream.read(buffer);
            if (len != 4)
            {
                throw new RuntimeException("Unexpected EOF");
            }
            return ((buffer[3] & 0xff) << 24) | ((buffer[2] & 0xff) << 16) | ((buffer[1] & 0xff) << 8) | (buffer[0] & 0xFF);
        }
    }
    //ExEnd:LEIntegerReader
}
