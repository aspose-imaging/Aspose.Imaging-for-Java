package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterCachedImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class Grayscaling
{
    public static void main(String... args)
    {
        Logger.startExample("Grayscaling");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
        {
            // Cast the image to RasterCachedImage
            RasterCachedImage rasterCachedImage = (RasterCachedImage) image;
            // Check if image is cached
            if (!rasterCachedImage.isCached())
            {
                // Cache image if not already cached
                rasterCachedImage.cacheData();
            }
            // Transform image to its grayscale representation
            rasterCachedImage.grayscale();
            // Save the resultant image
            rasterCachedImage.save(Utils.getOutDir() + "Grayscaling_out.jpg");
        }
        Logger.endExample();
    }
}
