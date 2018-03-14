package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdjustingGamma {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(AdjustingGamma.class) + "dicom/";
                //ExStart:AdjustingGamma
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "AdjustingGamma.bmp";
             
	         
		File file = new File(inputFile);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
             
		// Adjust the gamma
		image.adjustGamma(50);

		// Create an instance of BmpOptions for the resultant image and Save the
		// resultant image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}
          
        catch (FileNotFoundException ex) 
                 {
                Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
            }
}        //ExEnd:AdjustingGamma
}