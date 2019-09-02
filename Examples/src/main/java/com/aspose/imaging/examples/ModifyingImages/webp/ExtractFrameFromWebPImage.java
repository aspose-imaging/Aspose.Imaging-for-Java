package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.webp.IFrame;
import com.aspose.imaging.fileformats.webp.WebPImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ExtractFrameFromWebPImage
{
    public static void main(String... args)
    {
        //ExStart:ExtractFrameFromWebPImage
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing WebP image into the instance of WebPImage class.
        try (WebPImage image = new WebPImage(dataDir + "asposelogo.webp"))
        {
            if (image.getBlocks().length > 2)
            {
                // Access a particular frame from WebP image and cast it to Raster Image
                IFrame block = (image.getBlocks()[2]);

                if (block instanceof RasterImage)
                {
                    // Save the Raster Image to a BMP image.
                    ((RasterImage)block).save(dataDir + "ExtractFrameFromWebPImage.bmp", new BmpOptions());
                }
            }
        }
        //ExEnd:ExtractFrameFromWebPImage
    }
}
