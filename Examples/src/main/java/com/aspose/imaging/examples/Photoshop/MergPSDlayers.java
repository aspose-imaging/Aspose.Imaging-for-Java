package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

public class MergPSDlayers {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(MergPSDlayers.class) + "Photoshop/";
                //ExStart:MergPSDlayers
                String sourceFileName = dataDir + "samplePsd.psd";

		// Load an existing PSD file as image
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName);

		// Convert the loaded image to PSDImage
		com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;

		// create a JPG file stream
		java.io.FileInputStream fs = new java.io.FileInputStream(dataDir + "aspose-logo.jpg");

		// Create JPEG option class object
		JpegOptions jpgOptions = new JpegOptions();

		// call the Save the method of PSDImage class to merge the layers and
		// save it as jpg image.
		psdImage.save(dataDir + "MergPSDlayers_out.jpg", jpgOptions);
                //ExEnd:MergPSDlayers
	}
        
}
