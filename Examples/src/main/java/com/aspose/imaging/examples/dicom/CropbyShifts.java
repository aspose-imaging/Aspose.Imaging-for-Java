package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class CropbyShifts {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(CropbyShifts.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "CropbyShifts_out.bmp";

		// Load an existing image.
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Call and supply the four values to Crop method.
		image.crop(10, 20, 30, 40);

		// Save the results to disk
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
