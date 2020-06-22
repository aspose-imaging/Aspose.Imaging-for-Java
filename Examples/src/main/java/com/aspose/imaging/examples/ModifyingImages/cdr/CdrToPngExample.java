package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.TextRenderingHint;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CdrToPngExample
{
    public static void main(String... args)
    {
        Logger.startExample("CdrToPngExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "CDR/";
        String inputFileName = dataDir + "SimpleShapes.cdr";
        String outputFilePath = Utils.getOutDir() + "SimpleShapes.png";

        try (Image image = Image.load(inputFileName))
        {
            PngOptions options = new PngOptions();

            options.setColorType(PngColorType.TruecolorWithAlpha);

            // Set rasterization options for fileformat
            VectorRasterizationOptions defaultOptions = (VectorRasterizationOptions) image.getDefaultOptions(new Object[]{Color.getWhite(), image.getWidth(), image.getHeight()});
            options.setVectorRasterizationOptions(defaultOptions);
            defaultOptions.setTextRenderingHint(TextRenderingHint.SingleBitPerPixel);
            defaultOptions.setSmoothingMode(SmoothingMode.None);

            image.save(outputFilePath, options);
        }

        Utils.deleteFile(outputFilePath);
        Logger.endExample();
    }
}
