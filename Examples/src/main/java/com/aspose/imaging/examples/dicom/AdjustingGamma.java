package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class AdjustingGamma {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(AdjustingGamma.class);
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "brightness.bmp";

		// Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Adjust the gamma
		image.adjustGamma(50);

		// Create an instance of BmpOptions for the resultant image and Save the
		// resultant image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
