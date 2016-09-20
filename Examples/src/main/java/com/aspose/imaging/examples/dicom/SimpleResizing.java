package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class SimpleResizing {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SimpleResizing.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "SimpleResizing_out.bmp";

		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		image.resize(200, 200);
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
