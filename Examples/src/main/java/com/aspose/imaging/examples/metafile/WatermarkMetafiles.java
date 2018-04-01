package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.FontStyle;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class WatermarkMetafiles {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(WatermarkMetafiles.class) + "metafile/";
		// Load an EMF image in an instance of EmfMetafileImage
               //ExStart:WatermarkMetafiles
                EmfMetafileImage image = (EmfMetafileImage) Image.load(dataDir + "Sample1.emf");
		try {
			// Create an instance of Graphics2D by calling
			// EmfMetafileImage.getWatermarkDrawer
			java.awt.Graphics2D drawer = image.getWatermarkDrawer();
			// Creates an instance of Font and initialize it with font name,
			// style and size
			java.awt.Font font = new java.awt.Font("Times New Roman", FontStyle.Bold, 32);
			// Set font to the instance of Graphics2D
			drawer.setFont(font);
			// Set the Paint attribute for the Graphics2D context with an
			// instance of Color
			drawer.setPaint(new java.awt.Color(0, 0, 255, 127));
			// Create an instance of Rectangle2D by getting the string bounds
			java.awt.geom.Rectangle2D rect = font.getStringBounds("This is the custom", drawer.getFontRenderContext());
			// Estimate the X & Y positions where watermark will render on image
			float posx = (float) (image.getWidth() - rect.getWidth()) / 2;
			float posy = (float) (image.getHeight() - rect.getHeight()) / 2;
			// Draw watermark on the image
			drawer.drawString("This is the custom", posx, posy);
			drawer.drawString("watermark string!", posx, posy + 30);
			// Save the result in raster image format
			image.save(dataDir + "WatermarkMetafiles_out.png", new PngOptions());

		} finally {
			// Dispose image
			image.dispose();
		}
        //ExEnd:WatermarkMetafiles
	}
}
