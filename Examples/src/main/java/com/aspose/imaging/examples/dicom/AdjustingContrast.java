package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdjustingContrast {

    private static Object com;
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(AdjustingContrast.class) + "dicom/";
             
                //ExStart:AdjustingContrast
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "AdjustingContrast_out.bmp";

		// Load a DICOM image in an instance of DicomImage

		File file = new File(inputFile);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
             
		// Adjust the contrast
		image.adjustContrast(50);

		// Create an instance of BmpOptions for the resultant image and Save the
		// resultant image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
                }
                catch (FileNotFoundException ex) 
                 {
                Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
            }
                //ExEnd:AdjustingContrast
}
}
