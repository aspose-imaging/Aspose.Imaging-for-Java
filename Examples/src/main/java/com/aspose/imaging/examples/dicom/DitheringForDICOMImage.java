package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class DitheringForDICOMImage {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(DitheringForDICOMImage.class);
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "DitheringThreshold.bmp";

		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Peform Threshold dithering on the image
		image.dither(com.aspose.imaging.DitheringMethod.ThresholdDithering, 1);

		// Save the image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
