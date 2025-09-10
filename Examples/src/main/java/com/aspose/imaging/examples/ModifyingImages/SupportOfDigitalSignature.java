package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;

public class SupportOfDigitalSignature
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String basePath = Utils.getSharedDataDir() + "Png";

        //# Signing limitations:
        //#  - The LSB steganography algorithm requires the image to be at least 8 pixels in width and height,
        // with a minimum of 16,384 total pixels.
        //#  - Password must be at least 4 characters long.

        //            var password = "1234";
        //            var filePath = "c:\sunflower.jpg";

        //#################################### Example 1 ###############################
        //# Faster checking method with partial data extraction.                     #
        //# Set detectionThresholdPercentage value to 75% (default value).          #
        //##############################################################################

        String filePath = Path.combine(basePath, "00020.png");
        String password = "123456";
        try (RasterImage image = (RasterImage) Image.load(filePath))
        {
            image.embedDigitalSignature(password);

            boolean isSigning = image.isDigitalSigned(password);
            System.out.println("Check signing result of file is: " + isSigning);
        }

        Logger.endExample();
    }
}
