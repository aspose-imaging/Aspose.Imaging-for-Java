package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.MedianFilterOptions;

public class ApplyMedianFilter {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ApplyMedianFilter.class) + "ConvertingImages/";
		//ExStart:ApplyMedianFilter
		
		// Load the noisy image 
		Image image = Image.load(dataDir + "aspose-logo.gif");
		    // caste the image into RasterImage
		    RasterImage rasterImage = (RasterImage) image;

		    if (rasterImage == null)
		    {
		        return;
		    }

		    // Create an instance of MedianFilterOptions class and set the size.
		    MedianFilterOptions options = new MedianFilterOptions(4);

		    // Apply MedianFilterOptions filter to RasterImage object.
		    rasterImage.filter(image.getBounds(), options);

		    // Save the resultant image
		    image.save(dataDir + "median_test_denoise_out.gif");
		 //ExEnd:ApplyMedianFilter
	}

}
