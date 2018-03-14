package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertPSDLayerstoRasterImages {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertPSDLayerstoRasterImages.class) + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
                //ExStart:ConvertPSDLayerstoRasterImages 
		// Create an instance of Image class
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName);

		// Cast image object to PSD image
		com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;

		// Create an instance of PngOptions class
		PngOptions pngOptions = new PngOptions();
		pngOptions.setColorType(com.aspose.imaging.fileformats.png.PngColorType.TruecolorWithAlpha);

		// Access the list of layers in the PSD image object
		com.aspose.imaging.fileformats.psd.layers.Layer[] allLayers = psdImage.getLayers();

		for (int i = 0; i < allLayers.length; i++) {
			// convert and save the layer to PNG file format.
			allLayers[i].save("ConvertPSDLayerstoRasterImages_out" + i + 1 + ".png", pngOptions);
		}
	}
        //ExEnd:ConvertPSDLayerstoRasterImages 
}
