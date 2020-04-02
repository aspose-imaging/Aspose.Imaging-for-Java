package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ExportWebPToOtherImageFormats
{
    public static void main(String... args)
    {
        Logger.startExample("ExportWebPToOtherImageFormats");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load WebP image into the instance of image class.
        try (Image image = Image.load(dataDir + "asposelogo.webp"))
        {
            // Save the image in WebP format.
            image.save(Utils.getOutDir() + "ExportWebPToOtherImageFormats_out.bmp", new BmpOptions());
        }
        Logger.endExample();
    }
}
