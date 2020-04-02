package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.layers.Layer;

public class ExportPSDLayerToRasterImage
{
    public static void main(String... args)
    {
		Logger.startExample("ExportPSDLayerToRasterImage");
		String dataDir = Utils.getSharedDataDir() + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
        // Create an instance of Image class and load PSD file as image.
		com.aspose.imaging.fileformats.psd.PsdImage psdImage;
		try (com.aspose.imaging.Image objImage = com.aspose.imaging.Image.load(sourceFileName))
		{

			// Cast image object to PSD image
			psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) objImage;

			// Create an instance of PngOptions class
			com.aspose.imaging.imageoptions.PngOptions pngOptions = new com.aspose.imaging.imageoptions.PngOptions();
			pngOptions.setColorType(com.aspose.imaging.fileformats.png.PngColorType.TruecolorWithAlpha);

			// Loop through the list of layers
			Layer[] layers = psdImage.getLayers();
			for (int i = 0; i < layers.length; i++)
			{
				// convert and save the layer to PNG file format.
				layers[i].save(Utils.getOutDir() + "ExportPSDLayertoRasterImage_out" + (i + 1) + ".png", pngOptions);
			}
		}

		Logger.endExample();
    }

}
