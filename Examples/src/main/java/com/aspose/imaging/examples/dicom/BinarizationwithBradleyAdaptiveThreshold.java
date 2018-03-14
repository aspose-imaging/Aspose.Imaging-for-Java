package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarizationwithBradleyAdaptiveThreshold {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(BinarizationwithBradleyAdaptiveThreshold.class) + "dicom/";
                //ExStart:BinarizationwithBradleyAdaptiveThreshold
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "BinarizationwithBradleyAdaptiveThreshold_out.bmp";
               	File file = new File(inputFile);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		
		

		// Binarize image with bradley's adaptive threshold.
		image.binarizeBradley(10);

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}
              catch (FileNotFoundException ex) 
                 {
                Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
            }
                //ExEnd:BinarizationwithBradleyAdaptiveThreshold
        }
}