package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.MotionWienerFilterOptions;

public class ApplyMotionWienerFilter {
	public static void main(String... args) throws Exception {
		//ExStart:ApplyMotionWienerFilter
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ApplyMotionWienerFilter.class) + "ConvertingImages/";
		Image image = Image.load(dataDir + "aspose-logo.gif");
		// caste the image into RasterImage
		RasterImage rasterImage = (RasterImage) image;
		if (rasterImage == null) {
			return;
		}

		// Create an instance of MotionWienerFilterOptions class and set the
		// length, smooth value and angle.
		MotionWienerFilterOptions options = new MotionWienerFilterOptions(50, 9, 90);
		options.setGrayscale(true);

		// apply MedianFilterOptions filter to RasterImage object.
		rasterImage.filter(image.getBounds(), options);

		// Save the resultant image
		image.save(dataDir + "ApplyingMotionWienerFilter_out.gif");
		//ExEnd:ApplyMotionWienerFilter
	}

}
