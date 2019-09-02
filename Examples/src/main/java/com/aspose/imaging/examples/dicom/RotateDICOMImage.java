package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class RotateDICOMImage
{
    public static void main(String... args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        //ExStart:RotateDICOMImage
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "RotateDICOMImage_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			image.rotate(10);
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:RotateDICOMImage
    }
}
