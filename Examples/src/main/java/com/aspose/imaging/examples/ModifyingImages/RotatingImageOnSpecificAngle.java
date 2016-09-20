package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;

public class RotatingImageOnSpecificAngle {
	public static void main(String... args) throws Exception {
		// ExStart:RotatingImageOnSpecificAngle
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(RotatingImageOnSpecificAngle.class) + "ModifyingImages/";

		RasterImage image = (RasterImage) Image.load(dataDir + "aspose-logo.jpg");

		// Before rotation, the image should be cached for better performance
		if (!image.isCached()) {
			image.cacheData();
		}

		// Perform the rotation on 20 degree while keeping the image size
		image.rotate(20f);

		// Save the result to a new file
		image.save(dataDir + "RotatingImageOnSpecificAngle_out.jpg");
		// ExEnd:RotatingImageOnSpecificAngle
	}

}
