package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.DitheringMethod;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class DitheringRasterImages {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(DitheringRasterImages.class) + "ModifyingImages/";
		//ExStart:DitheringRasterImages
		JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg");

		// Perform Floyd Steinberg dithering on the current image
		image.dither(DitheringMethod.ThresholdDithering, 4);

		// Save the resultant image
		image.save(dataDir + "DitheringRasterImages_out.bmp");
		//ExEnd:DitheringRasterImages
	}

}
