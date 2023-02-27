package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertanyLoadedImageDirectlyToPNGformat
{
    public static void main(String... args)
    {
		Logger.startExample("ConvertanyLoadedImageDirectlyToPNGformat");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";

        // Load the source image (any format) in an instance of RasterImage
		try (RasterImage image = (RasterImage) Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Set the background color for the image
			image.setBackgroundColor(Color.getWhite());

			// Set the transparent color for the image
			image.setTransparentColor(Color.getBlack());

			// Set the HasTransparentColor & HasBackgroundColor properties to true
			image.setBackgroundColor(true);
			image.setTransparentColor(true);

			// Save the image on disc in PNG format
			image.save(Utils.getOutDir() + "ConvertanyLoadedImageDirectlyToPNGformat_out.jpg", new PngOptions());
		}
		Logger.endExample();
    }

}
