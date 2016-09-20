package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.examples.Utils;

public class ChangeBackgroundColor {
	public static void main(String... args) throws Exception {
		// ExStart:ChangeBackgroundColor
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ChangeBackgroundColor.class) + "ManipulatingPNGImages/";

		// Create an instance of Image class and load a PNG image
		com.aspose.imaging.Image img = com.aspose.imaging.Image.load(dataDir + "aspose_logo.png");

		// Create an instance of RasterImage and get the pixels array by calling
		// method LoadArgb32Pixels.
		com.aspose.imaging.RasterImage rasterImg = (com.aspose.imaging.RasterImage) img;

		int[] pixels = rasterImg.loadArgb32Pixels(img.getBounds());

		// Iterate through the pixel array.
		for (int i = 0; i < pixels.length; i++) {
			// Check the pixel information that if it is a transparent color
			// pixel
			if (pixels[i] == rasterImg.getTransparentColor().toArgb()) {
				// Change the pixel color to white
				pixels[i] = com.aspose.imaging.Color.getWhite().toArgb();
			}
		}
		// Replace the pixel array into the image.
		rasterImg.saveArgb32Pixels(img.getBounds(), pixels);

		// Save the updated image to disk.
		rasterImg.save(dataDir + "ChangeBackgroundColor_out.png");
		// ExEnd:ChangeBackgroundColor
	}

}
