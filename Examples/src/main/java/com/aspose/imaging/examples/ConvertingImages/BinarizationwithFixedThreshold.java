package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterCachedImage;
import com.aspose.imaging.examples.Utils;

public class BinarizationwithFixedThreshold {
	public static void main(String... args) throws Exception {
		//ExStart:BinarizationwithFixedThreshold
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(BinarizationwithFixedThreshold.class) + "ConvertingImages/";

		// Load an image in an instance of Image
		Image image = Image.load(dataDir + "aspose-logo.jpg");

		// Cast the image to RasterCachedImage
		RasterCachedImage rasterCachedImage = (RasterCachedImage) image;
		// Check if image is cached
		if (!rasterCachedImage.isCached()) {
			// Cache image if not already cached
			rasterCachedImage.cacheData();
		}
		// Binarize image with pre defined fixed threshold
		rasterCachedImage.binarizeFixed((byte) 100);
		// Save the resultant image
		rasterCachedImage.save(dataDir + "BinarizationWithFixedThreshold_out.jpg");
		//ExEnd:BinarizationwithFixedThreshold
	}

}
