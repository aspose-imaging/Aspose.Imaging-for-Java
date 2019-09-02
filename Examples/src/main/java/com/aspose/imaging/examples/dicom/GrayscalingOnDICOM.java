package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class GrayscalingOnDICOM
{
    public static void main(String... args)
    {
		//ExStart:GrayscalingOnDICOM
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "Grayscaling_out.bmp";

        // Load an existing image.
        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			// Transform image to its grayscale representation
			image.grayscale();

			// Save the resultant image.
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:GrayscalingOnDICOM
    }
}
