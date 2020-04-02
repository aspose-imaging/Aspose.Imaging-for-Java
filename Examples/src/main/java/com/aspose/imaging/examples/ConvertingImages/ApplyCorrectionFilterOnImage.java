package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class ApplyCorrectionFilterOnImage {
	public static void main(String... args)  {
		Logger.startExample("ApplyCorrectionFilterOnImage");
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

		try (RasterImage rasterImage = (RasterImage)Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Get Bounds[rectangle] of image.
			com.aspose.imaging.Rectangle rect = rasterImage.getBounds();

			// Create an instance of BilateralSmoothingFilterOptions class with size
			// parameter.
			com.aspose.imaging.imagefilters.filteroptions.BilateralSmoothingFilterOptions bilateralOptions =
					new com.aspose.imaging.imagefilters.filteroptions.BilateralSmoothingFilterOptions(3);

			// Create an instance of SharpenFilterOptions class.
			com.aspose.imaging.imagefilters.filteroptions.SharpenFilterOptions sharpenOptions = new com.aspose.imaging.imagefilters.filteroptions.SharpenFilterOptions();

			// Supply the filters to raster image.
			rasterImage.filter(rect, bilateralOptions);
			rasterImage.filter(rect, sharpenOptions);

			// Adjust the contrast accordingly.
			rasterImage.adjustContrast(-10);

			// Set brightness using Binarize Bradley
			rasterImage.binarizeBradley(80);

			// Save the results to output path.
			rasterImage.save(Utils.getOutDir() + "a1_out.jpg");
		}
		Logger.endExample();
	}

}
