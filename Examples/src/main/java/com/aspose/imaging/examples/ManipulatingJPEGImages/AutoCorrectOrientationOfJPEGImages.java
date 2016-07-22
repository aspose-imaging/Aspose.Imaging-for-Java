package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AutoCorrectOrientationOfJPEGImages {
	public static void main(String... args) throws Exception {
		// ExStart:AutoCorrectOrientationOfJPEGImages
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(AutoCorrectOrientationOfJPEGImages.class);
		
		//Load a Jpeg image from file path location or stream
		JpegImage image = (JpegImage)Image.load(dataDir + "aspose-logo.jpg");

		//Perform the automatic rotation on the image depending on the orientation data stored in the EXIF
		image.autoRotate();

		//Save the result on disc or stream
		image.save(dataDir + "aspose-logo_out.jpg");
		// ExEnd:AutoCorrectOrientationOfJPEGImages
	}

}
