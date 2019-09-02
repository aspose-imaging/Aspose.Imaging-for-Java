package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class SavingEachFrameInOtherRasterImageFormat
{
    public static void main(String... args)
    {
        //ExStart:SavingEachFrameInOtherRasterImageFormat
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of TiffImage and load the file from disc
        try (TiffImage multiImage = (TiffImage) Image.load(dataDir + "SampleTiff1.tiff"))
        {
            // Initialize a variable to keep track of the frames in the image
            int i = 0;

            // Iterate over the tiff frame collection and Save the frame directly on disc in PNG format
            for  (TiffFrame tiffFrame : multiImage.getFrames())
            {
                tiffFrame.save(dataDir + i + "_out.png", new PngOptions());
            }
        }
        //ExEnd:SavingEachFrameInOtherRasterImageFormat
    }
}
