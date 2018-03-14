package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class Grayscaling {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(Grayscaling.class) + "dicom/";
                //ExStart:Grayscaling
                String inputFile = dataDir + "image.dcm";
	        String outputFile = dataDir + "Grayscaling_out.bmp";

		// Load an existing image.
		 	File file = new File(inputFile);
		FileInputStream fis = null;

		fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		

		// Transform image to its grayscale representation
		image.grayscale();

		// Save the resultant image.
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	}
        //ExEnd:Grayscaling
}
