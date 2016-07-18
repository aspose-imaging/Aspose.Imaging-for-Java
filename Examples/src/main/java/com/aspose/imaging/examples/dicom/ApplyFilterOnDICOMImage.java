package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;

public class ApplyFilterOnDICOMImage {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getDataDir(ApplyFilterOnDICOMImage.class);
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "brightness.bmp";

		// Load an image
		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		// Supply the filters to DICOM image.
		image.filter(image.getBounds(), new com.aspose.imaging.imagefilters.filteroptions.MedianFilterOptions(8));

		// Save the results to output path.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
