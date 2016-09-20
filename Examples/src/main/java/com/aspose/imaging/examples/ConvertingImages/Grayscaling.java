package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterCachedImage;
import com.aspose.imaging.examples.Utils;

public class Grayscaling {
	public static void main(String... args) throws Exception {
		// ExStart:Grayscaling
		String dataDir = Utils.getSharedDataDir(Grayscaling.class) + "ConvertingImages/";

		Image image = Image.load(dataDir + "aspose-logo.jpg");
		// Cast the image to RasterCachedImage
		RasterCachedImage rasterCachedImage = (RasterCachedImage) image;
		// Check if image is cached
		if (!rasterCachedImage.isCached()) {
			// Cache image if not already cached
			rasterCachedImage.cacheData();
		}
		// Transform image to its grayscale representation
		rasterCachedImage.grayscale();
		// Save the resultant image
		rasterCachedImage.save(dataDir + "Grayscaling_out.jpg");
		// ExEnd:Grayscaling
	}

}
