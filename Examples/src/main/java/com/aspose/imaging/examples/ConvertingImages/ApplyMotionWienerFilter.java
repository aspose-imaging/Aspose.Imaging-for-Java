package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.MotionWienerFilterOptions;

public class ApplyMotionWienerFilter {
	public static void main(String... args) {
		//ExStart:ApplyMotionWienerFilter
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
		Image image = Image.load(dataDir + "aspose-logo.gif");
		try
		{
			// caste the image into RasterImage
			RasterImage rasterImage = (RasterImage) image;

			// Create an instance of MotionWienerFilterOptions class and set the
			// length, smooth value and angle.
			MotionWienerFilterOptions options = new MotionWienerFilterOptions(50, 9, 90);
			options.setGrayscale(true);

			// apply MedianFilterOptions filter to RasterImage object.
			rasterImage.filter(image.getBounds(), options);

			// Save the resultant image
			image.save(dataDir + "ApplyingMotionWienerFilter_out.gif");
		}
		finally
		{
			image.close();
		}
		//ExEnd:ApplyMotionWienerFilter
	}

}
