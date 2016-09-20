package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.ColorModes;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.imageoptions.PsdOptions;

public class ExportImagestoPSDFormat {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ExportImagestoPSDFormat.class) + "Photoshop/";
		String sourceFileName = dataDir + "sample.bmp";
		Image image = Image.load(sourceFileName);

		// Create an instance of PsdOptions and set it’s various properties
		PsdOptions psdOptions = new PsdOptions();
		psdOptions.setColorMode(ColorModes.Rgb);
		psdOptions.setCompressionMethod(CompressionMethod.RLE);
		psdOptions.setVersion(4);

		// Save image to disk in PSD format
		image.save(dataDir + "ExportImagestoPSDFormat_out.psd", psdOptions);
	}

}
