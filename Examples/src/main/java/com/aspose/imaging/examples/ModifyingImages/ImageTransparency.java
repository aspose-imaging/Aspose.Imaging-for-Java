package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngImage;

public class ImageTransparency
{
    public static void main(String[] args)
    {
        // ExStart:ImageTransparency
        // The path to the documents directory.

        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";

        String filePath = dataDir + "aspose_logo.png"; // specify your path
        try (PngImage image = (PngImage) Image.load(filePath))
        {
            float opacity = image.getImageOpacity(); // opacity = 0,470798
            System.out.println(opacity);
            if (opacity == 0)
            {
                // The image is fully transparent.
                System.out.println("The image is fully transparent.");
            }
        }
        // ExEnd:ImageTransparency
    }
}
