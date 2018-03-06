package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class AdjustingBrightness {

  

   
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(AdjustingBrightness.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "AdjustingBrightness_out.bmp";

		// Load a DICOM image in an instance of DicomImage
com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(inputFile);

		// Adjust the brightness
		image.adjustBrightness(50);

		// Create an instance of BmpOptions for the resultant image and Save the
		// resultant image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
