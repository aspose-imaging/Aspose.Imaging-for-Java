package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdjustContrastDICOM
{

    private static Object com;

    public static void main(String... args)
    {
        //ExStart:AdjustingContrast
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";

        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "AdjustingContrast_out.bmp";

        // Load a DICOM image in an instance of DicomImage

        File file = new File(inputFile);
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream(file);

            // Load a DICOM image in an instance of DicomImage
            com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(fis);

            try
            {
                // Adjust the contrast
                image.adjustContrast(50);

                // Create an instance of BmpOptions for the resultant image and Save the
                // resultant image
                image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
            }
            finally
            {
                image.close();
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
        }

        //ExEnd:AdjustingContrast
    }
}
