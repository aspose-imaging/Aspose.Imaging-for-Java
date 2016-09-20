package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class BinarizationwithFixedThreshold {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(BinarizationwithFixedThreshold.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "BinarizationwithFixedThreshold_out.bmp";

		// Load an existing image.
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Binarize image with predefined fixed threshold.
		image.binarizeFixed((byte) 100);

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
