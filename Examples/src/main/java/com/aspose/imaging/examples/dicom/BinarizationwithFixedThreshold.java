package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class BinarizationwithFixedThreshold {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(BinarizationwithFixedThreshold.class) + "dicom/";
                //ExStart:BinarizationwithFixedThreshold
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "BinarizationwithFixedThreshold_out.bmp";

		 	File file = new File(inputFile);
		FileInputStream fis = null;

		//try {
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		

		// Binarize image with predefined fixed threshold.
		image.binarizeFixed((byte) 100);

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
                 //ExEnd:BinarizationwithFixedThreshold
                }
       
}
