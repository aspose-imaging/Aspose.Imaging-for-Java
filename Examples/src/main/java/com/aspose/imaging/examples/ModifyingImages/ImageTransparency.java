package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngImage;

public class ImageTransparency
{
    public static void main(String[] args)
    {
        Logger.startExample("ImageTransparency");
        // The path to the documents directory.

        String dataDir = Utils.getSharedDataDir() + "Png/";

        String filePath = dataDir + "aspose_logo.png"; // specify your path
        try (PngImage image = (PngImage) Image.load(filePath))
        {
            float opacity = image.getImageOpacity(); // opacity = 0,470798
            Logger.printf("opacity : %f", opacity);
            if (opacity == 0)
            {
                // The image is fully transparent.
                Logger.println("The image is fully transparent.");
            }
        }
        Logger.endExample();
    }
}
