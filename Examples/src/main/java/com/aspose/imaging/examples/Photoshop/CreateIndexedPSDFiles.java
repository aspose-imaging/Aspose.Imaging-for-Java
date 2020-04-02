package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Color;
import com.aspose.imaging.Graphics;
import com.aspose.imaging.Pen;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.ColorModes;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PsdOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class CreateIndexedPSDFiles
{
    public static void main(String... args)
    {
		Logger.startExample("CreateIndexedPSDFiles");

		String dataDir = Utils.getSharedDataDir() + "Photoshop/";
		// Create an instance of PsdOptions and set it's properties
		try (PsdOptions createOptions = new PsdOptions())
		{
			// Set source
			createOptions.setSource(new FileCreateSource(Utils.getOutDir() + "output.psd", false));
			// Set ColorMode to Indexed
			createOptions.setColorMode(ColorModes.Indexed);
			// Set PSD file version
			createOptions.setVersion(5);
			// Create a new color patelle having RGB colors
			Color[] palette = new Color[]{Color.getRed(), Color.getGreen(), Color.getBlue()};
			// Set Palette property to newly created palette
			createOptions.setPalette(new com.aspose.imaging.fileformats.psd.PsdColorPalette(palette));
			// Set compression method
			createOptions.setCompressionMethod(CompressionMethod.RLE);

			// Create a new PSD with PsdOptions created previously
			try (PsdImage psd = (PsdImage) PsdImage.create(createOptions, 500, 500))
			{
				// Draw some graphics over the newly created PSD
				Graphics graphics = new Graphics(psd);
				graphics.clear(Color.getWhite());
				graphics.drawEllipse(new Pen(Color.getRed(), 6), new Rectangle(0, 0, 400, 400));
				psd.save();
			}
		}
		Logger.endExample();
    }

}
