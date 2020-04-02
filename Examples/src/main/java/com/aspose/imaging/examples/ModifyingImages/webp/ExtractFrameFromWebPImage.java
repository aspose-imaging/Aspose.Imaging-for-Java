package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.webp.WebPImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ExtractFrameFromWebPImage
{
    public static void main(String... args)
    {
        Logger.startExample("ExtractFrameFromWebPImage");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing WebP image into the instance of WebPImage class.
        try (WebPImage image = new WebPImage(dataDir + "asposelogo.webp"))
        {
            if (image.getPageCount() > 2)
            {
                // Access a particular frame from WebP image and cast it to Raster Image
                Image block = (image.getPages()[2]);

                if (block instanceof RasterImage)
                {
                    // Save the Raster Image to a BMP image.
                    block.save(Utils.getOutDir() + "ExtractFrameFromWebPImage.bmp", new BmpOptions());
                }
            }
        }
        Logger.endExample();
    }
}
