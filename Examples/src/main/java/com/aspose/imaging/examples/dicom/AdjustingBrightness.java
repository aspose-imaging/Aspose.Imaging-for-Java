package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;

public class AdjustingBrightness
{

    public static void main(String... args)
    {
        Logger.startExample("AdjustingBrightness");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = Utils.getOutDir() + "AdjustingBrightness_out.bmp";

        // Load a DICOM image in an instance of DicomImage
        try (DicomImage image = (DicomImage) Image.load(inputFile))
        {
            //yar Image image = Image.load(dataDir + "aspose-logo.dxf");
            // Adjust the brightness
            image.adjustBrightness(50);

            // Create an instance of BmpOptions for the resultant image and Save the
            // resultant image
            image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
        }

        Logger.endExample();
    }

}
