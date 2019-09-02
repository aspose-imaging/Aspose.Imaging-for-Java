package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class BinarizationWithBradleysAdaptiveThreshold
{
    public static void main(String... args)
    {
		//ExStart:BinarizationWithBradleysAdaptiveThreshold
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "BinarizationwithBradleyAdaptiveThreshold_out.bmp";

		// Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			// Binarize image with bradley's adaptive threshold.
			image.binarizeBradley(10);

			// Save the resultant image.
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:BinarizationWithBradleysAdaptiveThreshold
    }
}