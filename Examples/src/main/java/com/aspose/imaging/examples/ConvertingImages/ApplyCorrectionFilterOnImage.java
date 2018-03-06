package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;

public class ApplyCorrectionFilterOnImage {
	public static void main(String... args) throws Exception {
		//ExStart:ApplyCorrectionFilterOnImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ApplyCorrectionFilterOnImage.class) + "ConvertingImages/";

		Image image = Image.load(dataDir + "aspose-logo.jpg");
		// Convert the image into RasterImage.
		RasterImage rasterImage = (RasterImage) image;

		if (rasterImage == null) {
			return;
		}
		// Get Bounds[rectangle] of image.
		com.aspose.imaging.Rectangle rect = image.getBounds();

		// Create an instance of BilateralSmoothingFilterOptions class with size
		// parameter.
		com.aspose.imaging.imagefilters.filteroptions.BilateralSmoothingFilterOptions bilateralOptions = new com.aspose.imaging.imagefilters.filteroptions.BilateralSmoothingFilterOptions(
				3);

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
		rasterImage.save(dataDir + "a1_out.jpg");
		//ExEnd:ApplyCorrectionFilterOnImage
	}

}
