package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class ResizeHeightProportionally
{
    public static void main(String... args)
    {
		Logger.startExample("ResizeHeightProportionally");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = Utils.getOutDir() + "ResizeHeightProportionally_out.bmp";

        // Load a DICOM image in an instance of DicomImage
		try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(inputFile))
		{
			image.resizeHeightProportionally(100, ResizeType.AdaptiveResample);
			image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
		}

		Logger.endExample();
    }
}
