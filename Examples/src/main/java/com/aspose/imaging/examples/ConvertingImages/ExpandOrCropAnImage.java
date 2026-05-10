package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ExpandOrCropAnImage
{
    public static void main(String... args)
    {
        Logger.startExample("ExpandOrCropAnImage");
        // The path to the document directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load an image into an Image instance and cache its data.
        try (RasterImage rasterImage = (RasterImage) Image.load(dataDir + "aspose-logo.jpg"))
        {
            rasterImage.cacheData();
            // Create a Rectangle that defines the X, Y, width, and height of the region, then save the output image.
            Rectangle destRect = new Rectangle(-200, -200, 300, 300);
            rasterImage.save(Utils.getOutDir() + "Grayscaling_out.jpg", new JpegOptions(), destRect);
        }
        Logger.endExample();
    }
}
