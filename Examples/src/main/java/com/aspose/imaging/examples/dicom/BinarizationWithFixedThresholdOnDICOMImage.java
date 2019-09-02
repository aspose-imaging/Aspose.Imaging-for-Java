package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class BinarizationWithFixedThresholdOnDICOMImage
{
    public static void main(String... args)
    {
		//ExStart:BinarizationWithFixedThresholdOnDICOMImage

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "BinarizationWithFixedThresholdOnDICOMImage_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			// Binarize image with predefined fixed threshold.
			image.binarizeFixed((byte) 100);

			// Save the resultant image.
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:BinarizationWithFixedThresholdOnDICOMImage
    }

}
