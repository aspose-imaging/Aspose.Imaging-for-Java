package com.aspose.imaging.examples.images;

import com.aspose.imaging.Pen;
import com.aspose.imaging.examples.Utils;

public class DrawingLines {
	public static void main(String[] args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(DrawingLines.class);
		// Creates an instance of BmpOptions and set its various properties
		com.aspose.imaging.imageoptions.BmpOptions bmpCreateOptions = new com.aspose.imaging.imageoptions.BmpOptions();
		bmpCreateOptions.setBitsPerPixel(32);

		// Define the source property for the instance of BmpOptions
		bmpCreateOptions.setSource(
				new com.aspose.imaging.sources.StreamSource(new java.io.ByteArrayInputStream(new byte[100 * 100 * 4])));

		// Creates an instance of Image and call create method by passing the
		// bmpCreateOptions object
		com.aspose.imaging.Image image = com.aspose.imaging.Image.create(bmpCreateOptions, 100, 100);

		// Create and initialize an instance of Graphics class
		com.aspose.imaging.Graphics graphic = new com.aspose.imaging.Graphics(image);

		// Clear the image surface with Yellow color
		graphic.clear(com.aspose.imaging.Color.getYellow());

		// Draw a dotted line by specifying the Pen object having blue color and
		// co-ordinate Points
		graphic.drawLine(new Pen(com.aspose.imaging.Color.getBlue()), 9, 9, 90, 90);
		graphic.drawLine(new Pen(com.aspose.imaging.Color.getBlue()), 9, 90, 90, 9);

		// Draw a continuous line by specifying the Pen object having Solid
		// Brush with red color and two point structures
		graphic.drawLine(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getRed())),
				new com.aspose.imaging.Point(9, 9), new com.aspose.imaging.Point(9, 90));

		// Draw a continuous line by specifying the Pen object having Solid
		// Brush with aqua color and two point structures
		graphic.drawLine(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getAqua())),
				new com.aspose.imaging.Point(9, 90), new com.aspose.imaging.Point(90, 90));

		// Draw a continuous line by specifying the Pen object having Solid
		// Brush with black color and two point structures
		graphic.drawLine(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getBlack())),
				new com.aspose.imaging.Point(90, 90), new com.aspose.imaging.Point(90, 9));

		// Draw a continuous line by specifying the Pen object having Solid
		// Brush with white color and two point structures
		graphic.drawLine(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getWhite())),
				new com.aspose.imaging.Point(90, 9), new com.aspose.imaging.Point(9, 9));

		// Save all changes.
		image.save(dataDir + "DrawLinesExample.bmp");
	}

}
