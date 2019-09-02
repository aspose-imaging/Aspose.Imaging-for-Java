package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class CropbyShifts
{
    public static void main(String... args)
    {
		//ExStart:CropbyShifts

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "CropbyShifts_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			// Call and supply the four values to Crop method.
			image.crop(10, 20, 30, 40);

			// Save the results to disk
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:CropbyShifts
    }
}
