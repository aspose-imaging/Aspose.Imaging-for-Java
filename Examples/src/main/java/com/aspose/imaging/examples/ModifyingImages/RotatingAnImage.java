package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.examples.Utils;

public class RotatingAnImage {
	public static void main(String... args) throws Exception {
		//ExStart:RotatingAnImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(RotatingAnImage.class) + "ModifyingImages/";
		// loading an Image
		Image image = Image.load(dataDir + "aspose-logo.jpg");

		// Rotating Image
		image.rotateFlip(RotateFlipType.Rotate270FlipNone);
		image.save(dataDir + "RotatingAnImage_out.jpg");
		//ExEnd:RotatingAnImage
	}

}
