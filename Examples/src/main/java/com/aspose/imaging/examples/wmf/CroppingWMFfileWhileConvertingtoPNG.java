package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class CroppingWMFfileWhileConvertingtoPNG {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(CroppingWMFfileWhileConvertingtoPNG.class) + "wmf/";
		String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "CroppingWMFfileWhileConvertingtoPNG.png";
                //ExStart:CroppingWMFfileWhileConvertingtoPNG
		// Load an existing WMF image
                     Image image = Image.load(dataDir);
                try {
		

			// Create an instance of EmfRasterizationOptions class and set
			// different properties
			EmfRasterizationOptions emf = new EmfRasterizationOptions();
			emf.setPageWidth(2000);
			emf.setPageHeight(2000);
			emf.setBackgroundColor(Color.getWhiteSmoke());

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
                //ExEnd:CroppingWMFfileWhileConvertingtoPNG
	}
}
