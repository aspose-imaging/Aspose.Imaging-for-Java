package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class CropbyShifts {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(CropbyShifts.class) + "dicom/";
                //ExStart:CropbyShifts
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "CropbyShifts_out.bmp";
	
 	        File file = new File(inputFile);
		FileInputStream fis = null;
		//try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		
		// Call and supply the four values to Crop method.
		image.crop(10, 20, 30, 40);

		// Save the results to disk
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}
        //ExEnd:CropbyShifts
}
