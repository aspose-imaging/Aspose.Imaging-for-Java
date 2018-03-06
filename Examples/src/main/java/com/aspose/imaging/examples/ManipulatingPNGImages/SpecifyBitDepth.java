package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class SpecifyBitDepth {
	public static void main(String... args) throws Exception {
		//ExStart:SpecifyBitDepth
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SpecifyBitDepth.class) + "ManipulatingPNGImages/";

		// Load an existing PNG image
		PngImage pngImage = (PngImage) Image.load(dataDir + "aspose_logo.png");

		// Create an instance of PngOptions
		PngOptions options = new PngOptions();

		// Set the desired ColorType
		options.setColorType(PngColorType.Grayscale);

		// Set the BitDepth according to the specified ColorType
		options.setBitDepth((byte) 1);

		// Save changes to the disc
		pngImage.save(dataDir + "SpecifyBitDepth_out.jpg", options);
		//ExEnd:SpecifyBitDepth
	}

}
