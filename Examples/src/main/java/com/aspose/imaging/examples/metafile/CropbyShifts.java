package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.MetafileImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class CropbyShifts {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CropbyShifts.class) + "metafile/";
		// Load an EMF file in an instance of MetafileImage
                //ExStart:CropbyShifts 
                MetafileImage metaImage = (MetafileImage) Image.load(dataDir + "Picture1.emf");

		// Define shift values for all four sides
		int leftShift = 10;
		int rightShift = 10;
		int topShift = 10;
		int bottomShift = 10;

		// Based on the shift values, apply the cropping on image
		// Crop method will shift the image bounds toward the center of image
		metaImage.crop(leftShift, rightShift, topShift, bottomShift);

		// Save the result in PNG format
		metaImage.save(dataDir + "CropbyShifts_out.png", new PngOptions());
	}
               //ExEnd:CropbyShifts 
}
