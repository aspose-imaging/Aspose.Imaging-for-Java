package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class SpecifyTransparencyUsingRasterImage
{
    public static void main(String... args)
    {
        Logger.startExample("SpecifyTransparencyUsingRasterImage");
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of RasterImage and load a BMP image
        try (RasterImage image = (RasterImage) Image.load(dataDir + "aspose_logo.png"))
        {
            // Set the background color, transparent, HasTransparentColor & HasBackgroundColor properties for the image
            image.setBackgroundColor(Color.getWhite());
            image.setTransparentColor(Color.getBlack());
            image.setTransparentColor(true);
            image.setBackgroundColor(true);
            image.save(Utils.getOutDir() + "SpecifyTransparencyforPNGImagesUsingRasterImage_out.jpg", new PngOptions());
        }
        Logger.endExample();
    }
}
