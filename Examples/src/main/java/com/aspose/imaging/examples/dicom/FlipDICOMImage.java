package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class FlipDICOMImage {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
                //ExStart:FlipDICOMImage
                String dataDir = Utils.getSharedDataDir(FlipDICOMImage.class) + "dicom/";
		String inputFile = dataDir + "image.dcm";
		String outputFile = "FlipDICOMImage_out.bmp";

		 	File file = new File(inputFile);
		FileInputStream fis = null;

	
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		

		image.rotateFlip(com.aspose.imaging.RotateFlipType.Rotate180FlipNone);
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}
        //ExEnd:FlipDICOMImage
}
