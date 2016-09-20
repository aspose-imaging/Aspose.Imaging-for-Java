package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Utils;

public class UpdateTextLayerInPSDFile {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(UpdateTextLayerInPSDFile.class) + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
		String outputFile = dataDir + "UpdateTextLayerInPSDFile.psd";

		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName);
		try {
			com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;
			com.aspose.imaging.fileformats.psd.layers.TextLayer textLayer1 = (com.aspose.imaging.fileformats.psd.layers.TextLayer) psdImage
					.getLayers()[1];
			com.aspose.imaging.fileformats.psd.layers.TextLayer textLayer2 = (com.aspose.imaging.fileformats.psd.layers.TextLayer) psdImage
					.getLayers()[2];

			textLayer2.updateText("test update", new com.aspose.imaging.Point(100, 100), 72.0f,
					com.aspose.imaging.Color.getPurple());

			com.aspose.imaging.imageoptions.PsdOptions psdOpt = new com.aspose.imaging.imageoptions.PsdOptions();
			psdOpt.setCompressionMethod(com.aspose.imaging.fileformats.psd.CompressionMethod.RLE);
			psdImage.save(outputFile);
		} finally {
			image.dispose();
		}
	}

}
