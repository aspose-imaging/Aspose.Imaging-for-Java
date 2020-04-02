package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AdjustContrastDICOM
{
    public static void main(String... args)
    {
        Logger.startExample("AdjustContrastDICOM");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";

        String inputFile = dataDir + "image.dcm";
        String outputFile = Utils.getOutDir() + "AdjustingContrast_out.bmp";

        // Load a DICOM image in an instance of DicomImage

        File file = new File(inputFile);

        try(FileInputStream fis = new FileInputStream(file))
        {
            // Load a DICOM image in an instance of DicomImage

            try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(fis))
            {
                // Adjust the contrast
                image.adjustContrast(50);

                // Create an instance of BmpOptions for the resultant image and Save the
                // resultant image
                image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
            }
        }
        catch (IOException ex)
        {
            Logger.println(ex.getMessage());
            ex.printStackTrace();
        }

        Logger.endExample();
    }
}
