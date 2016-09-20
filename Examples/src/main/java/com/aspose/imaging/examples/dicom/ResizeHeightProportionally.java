package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizeHeightProportionally {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ResizeHeightProportionally.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "ResizeHeightProportionally_out.bmp";

		com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(
				inputFile);

		image.resizeHeightProportionally(100, ResizeType.AdaptiveResample);
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}

}
