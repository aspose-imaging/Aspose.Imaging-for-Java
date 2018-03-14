package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Utils;

public class ExportPSDLayertoRasterImage {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ExportPSDLayertoRasterImage.class) + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
                //ExStart:ExportPSDLayertoRasterImage
		// Create an instance of Image class and load PSD file as image.
		com.aspose.imaging.Image objImage = com.aspose.imaging.Image.load(sourceFileName);

		// Cast image object to PSD image
		com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) objImage;

		// Create an instance of PngOptions class
		com.aspose.imaging.imageoptions.PngOptions pngOptions = new com.aspose.imaging.imageoptions.PngOptions();
		pngOptions.setColorType(com.aspose.imaging.fileformats.png.PngColorType.TruecolorWithAlpha);

		// Loop through the list of layers
		for (int i = 0; i < psdImage.getLayers().length; i++) {
			// convert and save the layer to PNG file format.
			psdImage.getLayers()[i].save("ExportPSDLayertoRasterImage_out" + i + 1 + ".png", pngOptions);
		}
	}
               //ExEnd:ExportPSDLayertoRasterImage
}
