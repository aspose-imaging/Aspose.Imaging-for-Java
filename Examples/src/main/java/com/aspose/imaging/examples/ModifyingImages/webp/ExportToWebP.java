package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.WebPOptions;

public class ExportToWebP
{
    public static void main(String... args)
    {
        //ExStart:ExportToWebP
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of image class.
        try (Image image = Image.load(dataDir + "SampleImage1.bmp"))
        {
            // Create an instance of WebPOptions class and set properties
            WebPOptions options = new WebPOptions();
            options.setQuality(50);
            options.setLossless(false);
            image.save(dataDir + "ExportToWebP_out.webp", options);
        }
        //ExEnd:ExportToWebP
    }
}
