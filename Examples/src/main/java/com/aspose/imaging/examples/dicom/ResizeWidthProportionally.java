package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizeWidthProportionally
{
    public static void main(String... args) throws Exception
    {
		//ExStart:ResizeWidthProportionally
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "ResizeWidthProportionally_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			image.resizeWidthProportionally(150, ResizeType.AdaptiveResample);
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:ResizeWidthProportionally
    }
}
