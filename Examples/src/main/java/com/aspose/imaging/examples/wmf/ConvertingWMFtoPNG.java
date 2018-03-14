package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertingWMFtoPNG {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertingWMFtoPNG.class) + "wmf/";
                //ExStart:ConvertingWMFtoPNG 
                String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "ConvertingWMFtoPNG_out.png";
                  Image image = Image.load(dataDir);
		
		try {
			// Calculate new height
			double k = (image.getWidth() * 1.00) / image.getHeight();

			// Create an instance of EmfRasterizationOptions class and define
			
			EmfRasterizationOptions emf = new EmfRasterizationOptions();
			emf.setPageWidth(400);
			emf.setPageHeight((int) Math.round(400 / k));
			emf.setBorderX(5);
			emf.setBorderY(10);
			emf.setBackgroundColor(Color.getWhiteSmoke());
        		PngOptions options = new PngOptions();
			options.setVectorRasterizationOptions(emf);

			// Call the save method, provide output path and PngOptions to
			// convert the WMF file to PNG and save the output
			image.save(outFileName, options);
		} finally {
			image.dispose();
		}
                //ExEnd:ConvertingWMFtoPNG 
	}
}
