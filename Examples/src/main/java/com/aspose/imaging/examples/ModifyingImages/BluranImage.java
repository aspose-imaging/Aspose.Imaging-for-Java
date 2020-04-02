package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.GaussianBlurFilterOptions;

public class BluranImage
{
    public static void main(String... args)
    {
		Logger.startExample("BluranImage");
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

		try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Convert the image into RasterImage.
			RasterImage rasterImage = (RasterImage) image;

			// Pass Bounds[rectangle] of image and GaussianBlurFilterOptions
			// instance to Filter method.
			rasterImage.filter(rasterImage.getBounds(), new GaussianBlurFilterOptions(5, 5));

			// Save the results to output path.
			rasterImage.save(Utils.getOutDir() + "BluranImage_out.gif");
		}
		Logger.endExample();
    }

}
