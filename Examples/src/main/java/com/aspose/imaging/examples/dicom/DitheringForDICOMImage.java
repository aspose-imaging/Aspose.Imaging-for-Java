package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DitheringForDICOMImage
{
    public static void main(String... args)
    {
		Logger.startExample("DitheringForDICOMImage");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = Utils.getOutDir() + "DitheringForDICOMImage_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile))
		{
			// Peform Threshold dithering on the image
			image.dither(com.aspose.imaging.DitheringMethod.ThresholdDithering, 1);

			// Save the image
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}

		Logger.endExample();
    }
}
