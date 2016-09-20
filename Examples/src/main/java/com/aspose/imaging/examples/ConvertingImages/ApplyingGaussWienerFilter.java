package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.GaussWienerFilterOptions;

public class ApplyingGaussWienerFilter {
	public static void main(String... args) throws Exception {
		// ExStart:ApplyingGaussWienerFilter
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ApplyingGaussWienerFilter.class) + "ConvertingImages/";
		Image image = Image.load(dataDir + "aspose-logo.gif");
		// caste the image into RasterImage
		RasterImage rasterImage = (RasterImage) image;
		if (rasterImage == null) {
			return;
		}

		// Create an instance of GaussWienerFilterOptions class and set the
		// radius size and smooth value.
		GaussWienerFilterOptions options = new GaussWienerFilterOptions(12, 3);
		options.setGrayscale(true);

		// apply MedianFilterOptions filter to RasterImage object.
		rasterImage.filter(image.getBounds(), options);

		// Save the resultant image
		image.save(dataDir + "ApplyGaussWienerFilter_out.gif");
		// ExEnd:ApplyingGaussWienerFilter
	}

}
