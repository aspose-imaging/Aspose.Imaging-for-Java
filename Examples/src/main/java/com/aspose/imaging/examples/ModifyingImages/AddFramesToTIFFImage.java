package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.sources.StreamSource;

import java.io.File;
import java.io.FilenameFilter;

public class AddFramesToTIFFImage
{
    public static void main(String[] args)
    {
        // To get proper output please apply a valid Aspose.Imaging License. You can purchase full license or get 30 day temporary license from http:// Www.aspose.com/purchase/default.aspx.");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";;
        TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);
        outputSettings.setBitsPerSample(new int[] { 1 });
        outputSettings.setCompression(TiffCompressions.CcittFax3);
        outputSettings.setPhotometric(TiffPhotometrics.MinIsWhite);
        outputSettings.setSource(new StreamSource());
        int newWidth = 500;
        int newHeight = 500;
        String path = dataDir + "AddFramesToTIFFImage_out.tif";
        try (TiffImage tiffImage = (TiffImage) Image.create(outputSettings, newWidth, newHeight))
        {
            int index = 0;
            File dir = new File(dataDir);
            String[] files = dir.list(new FilenameFilter()
            {
                @Override
                public boolean accept(File dir, String name)
                {
                    return name.endsWith(".jpg");
                }
            });

            if (files == null)
                return;

            for  (String file : files)
            {
                try (RasterImage ri = (RasterImage)Image.load(dataDir + file))
                {
                    ri.resize(newWidth, newHeight, ResizeType.NearestNeighbourResample);
                    TiffFrame frame = tiffImage.getActiveFrame();
                    if (index > 0)
                    {
                        frame = new TiffFrame(new TiffOptions(outputSettings) /*ensure options are cloned for each frame*/,
                                newWidth, newHeight);
                        // If there is a TIFF image loaded you need to enumerate the frames and perform the following
                        // Frame = TiffFrame.CreateFrameFrom(sourceFrame, outputSettings);
                    }

                    frame.savePixels(frame.getBounds(), ri.loadPixels(ri.getBounds()));
                    if (index > 0)
                    {
                        tiffImage.addFrame(frame);
                    }
                    index++;
                }
            }
            tiffImage.save(path);
        }
    }
}
