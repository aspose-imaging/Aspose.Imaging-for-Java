package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class AlignHorizontalAndVeticalResolutionsOfImage
{
    public static void main(String... args)
    {
        Logger.startExample("AlignHorizontalAndVeticalResolutionsOfImage");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        try (TiffImage image = (TiffImage) com.aspose.imaging.Image.load(dataDir + "sample.tiff"))
        {
            image.alignResolutions();

            // Save the results to output path.
            image.save(Utils.getOutDir() + "AligHorizontalAndVeticalResolutions_out.tiff");

            TiffFrame[] frames = image.getFrames();

            for (TiffFrame frame : frames)
            {
                // All resolutions after alignment must be equal
                System.out.println("Horizontal and vertical resolutions are equal:"
                        + ((int) frame.getVerticalResolution() == (int) frame.getHorizontalResolution()));
            }
        }
        Logger.endExample();
    }
}
