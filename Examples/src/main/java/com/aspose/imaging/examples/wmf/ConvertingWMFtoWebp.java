package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;

public class ConvertingWMFtoWebp {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertingWMFtoWebp.class) + "wmf/";
		String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "ConvertingWMFtoWebp_out.webp";

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

			// Create an instance of WebPOptions class and provide rasterization
			// option
			ImageOptionsBase options = new com.aspose.imaging.imageoptions.WebPOptions();
			options.setVectorRasterizationOptions(emf);

			// Call the save method, provide output path and WebPOptions to
			// convert the WMF file to Webp and save the output
			image.save(outFileName, options);
		} finally {
			image.dispose();
		}

	}
}
