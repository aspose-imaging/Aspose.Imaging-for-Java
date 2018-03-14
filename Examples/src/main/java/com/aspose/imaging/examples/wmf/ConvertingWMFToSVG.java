package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;

public class ConvertingWMFToSVG {
	public static void main(String... args) throws Exception {
		//ExStart:ConvertingWMFToSVG
		String dataDir = Utils.getSharedDataDir(ConvertingWMFToSVG.class) + "wmf/";
		// Path & Name of input file
		String inputFileName = dataDir + "sample.wmf";

		// Path & Name of output file
		String outputFileName = dataDir + "ConvertingWMFToSVG_out.svg";

		// Create an instance of Image class by loading an existing WMF image.
//com.aspose.imaging.Image image = com.aspose.imaging.Image.load(inputFileName, new com.aspose.imaging.imageloadoptions.MetafileLoadOptions(true));
		Image image = Image.load(dataDir + "aspose-logo.dxf");
        
               
                {
			// Create an instance of EmfRasterizationOptions class.
			//final com.aspose.imaging.imageoptions.EmfRasterizationOptions options = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();
			  final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
                        emfRasterizationOptions.setPageWidth(image.getWidth());
			  emfRasterizationOptions.setPageHeight(image.getHeight());

			
                 image.save(outputFileName, emfRasterizationOptions); 
          //          {
	//	    {
	//	setVectorRasterizationOptions(options);
						}
	//				});
	//	} finally {
			image.dispose();
		}
		//ExEnd:ConvertingWMFToSVG
	}
