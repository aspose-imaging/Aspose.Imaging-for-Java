package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ExpandOrCropAnImage
{
    public static void main(String... args)
    {
        //ExStart:ExpandOrCropAnImage
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load an image in an instance of Image and Setting for image data to be cashed
        try (RasterImage rasterImage = (RasterImage) Image.load(dataDir + "aspose-logo.jpg"))
        {
            rasterImage.cacheData();
            // Create an instance of Rectangle class and define X,Y and Width, height of the rectangle, and Save output image
            Rectangle destRect = new Rectangle(-200, -200, 300, 300);
            rasterImage.save(dataDir + "Grayscaling_out.jpg", new JpegOptions(), destRect);
        }
        //ExEnd:ExpandOrCropAnImage
    }
}
