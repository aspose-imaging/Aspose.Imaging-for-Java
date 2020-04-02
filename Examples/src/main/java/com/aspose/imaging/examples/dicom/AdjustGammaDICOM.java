package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AdjustGammaDICOM
{
    public static void main(String... args)
    {
        com.aspose.imaging.examples.Logger.startExample("AdjustGammaDICOM");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "AdjustingGamma.bmp";


        File file = new File(inputFile);
        try(FileInputStream fis = new FileInputStream(file);)
        {
            // Load a DICOM image in an instance of DicomImage
            try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(fis))
            {
                // Adjust the gamma
                image.adjustGamma(50);

                // Create an instance of BmpOptions for the resultant image and Save the
                // resultant image
                image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
            }
		}
        catch (IOException ex)
        {
            com.aspose.imaging.examples.Logger.println(ex.getMessage());
            ex.printStackTrace();
        }
        com.aspose.imaging.examples.Logger.endExample();
    }
}