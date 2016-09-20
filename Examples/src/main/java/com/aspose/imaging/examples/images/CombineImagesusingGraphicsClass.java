package com.aspose.imaging.examples.images;

import com.aspose.imaging.examples.Utils;

public class CombineImagesusingGraphicsClass {
	public static void main(String[] args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CombineImagesusingGraphicsClass.class) + "images/";
		// Create an instance of JpegOptions and set its various properties
		com.aspose.imaging.imageoptions.JpegOptions ImageOptions = new com.aspose.imaging.imageoptions.JpegOptions();

		// Create an instance of FileCreateSource and assign it to Source
		// property
		ImageOptions.setSource(
				new com.aspose.imaging.sources.FileCreateSource(dataDir + "two_images_result.jpeg", false));

		// Create an instance of Image
		com.aspose.imaging.Image image = com.aspose.imaging.Image.create(ImageOptions, 600, 600);

		// Create and initialize an instance of Graphics
		com.aspose.imaging.Graphics graphics = new com.aspose.imaging.Graphics(image);

		// Clear the image surface with white color
		graphics.clear(com.aspose.imaging.Color.getWhite());

		// Draw Image
		graphics.drawImage(com.aspose.imaging.Image.load(dataDir + "aspose-logo.jpg"), 0, 0, 600, 300);

		// Call save method to save the resultant image.
		image.save();
	}

}
