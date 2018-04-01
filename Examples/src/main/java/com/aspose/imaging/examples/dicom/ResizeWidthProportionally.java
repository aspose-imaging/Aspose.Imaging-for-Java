package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;
import java.io.File;
import java.io.FileInputStream;

public class ResizeWidthProportionally {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ResizeWidthProportionally.class) + "dicom/";
                //ExStart:ResizeWidthProportionally
                String inputFile = dataDir + "image.dcm";
		String outputFile = dataDir + "ResizeWidthProportionally_out.bmp";

		 	File file = new File(inputFile);
		FileInputStream fis = null;
                fis = new FileInputStream(file);

                // Load a DICOM image in an instance of DicomImage
                com.aspose.imaging.fileformats.dicom.DicomImage image = new com.aspose.imaging.fileformats.dicom.DicomImage(fis);
		

		image.resizeWidthProportionally(150, ResizeType.AdaptiveResample);
		image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
	
        //ExEnd:ResizeWidthProportionally
    }
}
