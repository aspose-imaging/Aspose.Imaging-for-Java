package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class BinarizationwithOtsuThreshold {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(BinarizationwithOtsuThreshold.class);
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "Fixed.bmp";

		// Load an existing image.
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Binarize image with Otsu Thresholding.
		image.binarizeOtsu();

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
