package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertingWMFtoPNG {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertingWMFtoPNG.class) + "wmf/";
		String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "ConvertingWMFtoPNG_out.png";

		// Load an existing WMF image
		Image image = Image.load(inputFileName, new com.aspose.imaging.imageloadoptions.MetafileLoadOptions(true));
		try {
			// Calculate new height
			double k = (image.getWidth() * 1.00) / image.getHeight();

			// Create an instance of EmfRasterizationOptions class and define
			// settings
			com.aspose.imaging.imageoptions.EmfRasterizationOptions emf = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();
			emf.setPageWidth(400);
			emf.setPageHeight((int) Math.round(400 / k));
			emf.setBorderX(5);
			emf.setBorderY(10);
			emf.setBackgroundColor(com.aspose.imaging.Color.getWhiteSmoke());

			// Create an instance of PngOptions class and provide rasterization
			// option
			PngOptions options = new PngOptions();
			options.setVectorRasterizationOptions(emf);

			// Call the save method, provide output path and PngOptions to
			// convert the WMF file to PNG and save the output
			image.save(outFileName, options);
		} finally {
			image.dispose();
		}

	}
}
