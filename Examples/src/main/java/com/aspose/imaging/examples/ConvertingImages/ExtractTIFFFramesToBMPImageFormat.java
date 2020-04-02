package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class ExtractTIFFFramesToBMPImageFormat
{
    public static void main(String... args)
    {
        Logger.startExample("ExtractTIFFFramesToBMPImageFormat");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        try (TiffImage multiImage = (TiffImage) Image.load(dataDir + "sample.tiff"))
        {
            // Create an instance of int to keep track of frames in TiffImage
            int frameCounter = 0;

            // Iterate over the TiffFrames in TiffImage
            for (TiffFrame tiffFrame : multiImage.getFrames())
            {
                multiImage.setActiveFrame(tiffFrame);

                // Load Pixels of TiffFrame into an array of Colors
                Color[] pixels = multiImage.loadPixels(tiffFrame.getBounds());

                // Create an instance of bmpCreateOptions
                try (BmpOptions bmpCreateOptions = new BmpOptions())
                {
                    bmpCreateOptions.setBitsPerPixel(24);

                    // Set the Source of bmpCreateOptions as FileCreateSource by specifying the location where output will be saved
                    bmpCreateOptions.setSource(new FileCreateSource(String.format("%sConcatExtractTIFFFramesToBMP_out%d.bmp", Utils.getOutDir(), frameCounter), false));

                    // Create a new bmpImage
                    try (BmpImage bmpImage = (BmpImage) Image.create(bmpCreateOptions, tiffFrame.getWidth(), tiffFrame.getHeight()))
                    {
                        // Save the bmpImage with pixels from TiffFrame
                        bmpImage.savePixels(tiffFrame.getBounds(), pixels);
                        bmpImage.save();
                    }
                }
                frameCounter++;
            }
        }
        Logger.endExample();
    }
}
