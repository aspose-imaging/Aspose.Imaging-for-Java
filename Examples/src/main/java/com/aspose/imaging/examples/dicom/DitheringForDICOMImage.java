package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class DitheringForDICOMImage {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(DitheringForDICOMImage.class) + "dicom/";
                //ExStart:DitheringForDICOMImage
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "DitheringForDICOMImage_out.bmp";

		 	File file = new File(inputFile);
		FileInputStream fis = null;

		
			fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		
		// Peform Threshold dithering on the image
		image.dither(com.aspose.imaging.DitheringMethod.ThresholdDithering, 1);

		// Save the image
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	
        //ExEnd:DitheringForDICOMImage
    }
}
