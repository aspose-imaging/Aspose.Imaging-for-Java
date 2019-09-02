package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;

public class ResizeHeightProportionally
{
    public static void main(String... args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        //ExStart:ResizeHeightProportionally
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "ResizeHeightProportionally_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile);

		try
		{
			image.resizeHeightProportionally(100, ResizeType.AdaptiveResample);
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}
		finally
		{
			image.close();
		}

		//ExEnd:ResizeHeightProportionally
    }
}
