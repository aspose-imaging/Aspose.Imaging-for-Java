package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class CroppingWMFfileWhileConvertingtoPNG {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CroppingWMFfileWhileConvertingtoPNG.class) + "wmf/";
		String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "CroppingWMFfileWhileConvertingtoPNG.png";

		// Load an existing WMF image
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(inputFileName, new com.aspose.imaging.imageloadoptions.MetafileLoadOptions(true));
		try {
			// Create an instance of Rectangle class by passing x,y and
			// width,height
			// Caste the object to WmfImage class type
			// Call the crop method of Image class and pass the rectangle class
			// instance
			((com.aspose.imaging.fileformats.wmf.WmfImage) image).crop(new com.aspose.imaging.Rectangle(3000, 2000, 2000, 2000));

			// Create an instance of EmfRasterizationOptions class and set
			// different properties
			com.aspose.imaging.imageoptions.EmfRasterizationOptions emf = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();
			emf.setPageWidth(2000);
			emf.setPageHeight(2000);
			emf.setBackgroundColor(com.aspose.imaging.Color.getWhiteSmoke());

			// Create an instance of PngOptions class and provide rasterization
			// option
			ImageOptionsBase options = new PngOptions();
			options.setVectorRasterizationOptions(emf);

			// Call the save method, provide output path and PngOptions to
			// convert the cropped WMF file to PNG and save the output
			image.save(outFileName, options);
		} finally {
			image.dispose();
		}

	}
}
