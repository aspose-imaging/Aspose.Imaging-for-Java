package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.GaussWienerFilterOptions;

public class ApplyGaussWienerFilterForColoredImage
{
	public static void main(String... args)  {
		Logger.startExample("ApplyGaussWienerFilterForColoredImage");

		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

		try (Image image = Image.load(dataDir + "aspose-logo.gif"))
		{
			// caste the image into RasterImage
			RasterImage rasterImage = (RasterImage) image;

			// Create an instance of GaussWienerFilterOptions class and set the
			// radius size and smooth value.
			GaussWienerFilterOptions options = new GaussWienerFilterOptions(5, 1.5);
			options.setBrightness(1);
			// apply MedianFilterOptions filter to RasterImage object.
			rasterImage.filter(image.getBounds(), options);

			// Save the resultant image
			image.save(Utils.getOutDir() + "ApplyGaussWienerFilter_out.gif");
		}
		Logger.endExample();
	}
}
