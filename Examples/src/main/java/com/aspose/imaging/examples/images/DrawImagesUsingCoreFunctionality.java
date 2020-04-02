package com.aspose.imaging.examples.images;

import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DrawImagesUsingCoreFunctionality
{
    public static void main(String[] args)
    {
        Logger.startExample("DrawImagesUsingCoreFunctionality");

        //Create an instance of BmpCreateOptions and set its various properties
        try (com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions())
        {
            createOptions.setBitsPerPixel(24);

            //Create an instance of FileCreateSource and assign it to Source property
            createOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(Utils.getOutDir() + "sample.bmp", false));

            //Create an instance of RasterImage
            try (RasterImage rasterImage = (RasterImage) RasterImage.create(createOptions, 500, 500))
            {
                //Get the pixels of the image by specifying the area as image boundary
                //Note Now it is recommended to use RasterImage.loadArgb32Pixels() instead of RasterImage.loadPixels()
                com.aspose.imaging.Color[] pixels = rasterImage.loadPixels(rasterImage.getBounds());

                for (int index = 0; index < pixels.length; index++)
                {
                    //Set the indexed pixel color to yellow
                    pixels[index] = com.aspose.imaging.Color.getYellow();
                }
                rasterImage.savePixels(rasterImage.getBounds(), pixels);

                // Save processed image.
                rasterImage.save();

                // Display Status.
                Logger.println("Processing completed successfully!");
            }
        }
        Logger.endExample();
    }
}




