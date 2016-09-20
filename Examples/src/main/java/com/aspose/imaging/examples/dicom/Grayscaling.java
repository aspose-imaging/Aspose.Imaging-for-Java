package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class Grayscaling {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(Grayscaling.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "Grayscaling_out.bmp";

		// Load an existing image.
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Transform image to its grayscale representation
		image.grayscale();

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
