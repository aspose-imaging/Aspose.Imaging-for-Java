package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class FlipDICOMImage
{
    public static void main(String... args)
    {
		//ExStart:FlipDICOMImage
		// The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = Utils.getOutDir() + "FlipDICOMImage_out.bmp";

        // Load a DICOM image in an instance of DicomImage

		try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile))
		{
			image.rotateFlip(com.aspose.imaging.RotateFlipType.Rotate180FlipNone);
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}

		//ExEnd:FlipDICOMImage
    }
}
