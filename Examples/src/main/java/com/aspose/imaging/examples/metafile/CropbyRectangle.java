package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.MetafileImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class CropbyRectangle {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CropbyRectangle.class) + "metafile/";
		// Load an EMF file in an instance of MetafileImage
                //ExStart:CropbyRectangle
                MetafileImage metaImage = (MetafileImage) Image.load(dataDir + "Picture1.emf");

		// Create an instance of Rectangle class with desired size
		Rectangle rectangle = new Rectangle(10, 10, 100, 100);

		// Perform the crop operation on object of Rectangle class
		metaImage.crop(rectangle);

		// Save the result in PNG format
		metaImage.save(dataDir + "CropbyRectangle_out.png", new PngOptions());
	}
        //ExEnd:CropbyRectangle
}
