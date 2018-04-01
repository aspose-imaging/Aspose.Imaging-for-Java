package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;

public class ConvertingWMFToSVG {
	public static void main(String... args) throws Exception {
		
		String dataDir = Utils.getSharedDataDir(ConvertingWMFToSVG.class) + "wmf/";
		// Path & Name of input file
		//ExStart:ConvertingWMFToSVG
                String inputFileName = dataDir + "sample.wmf";
                // Path & Name of output file
		String outputFileName = dataDir + "ConvertingWMFToSVG_out.svg";

                // Create an instance of Image class by loading an existing WMF image.
                Image image = Image.load(inputFileName);               
                // Create an instance of EmfRasterizationOptions class.
                final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
                emfRasterizationOptions.setPageWidth(image.getWidth());
                emfRasterizationOptions.setPageHeight(image.getHeight());
                image.save(outputFileName, emfRasterizationOptions); 

        	//ExEnd:ConvertingWMFToSVG
        }
                
			
	
}
