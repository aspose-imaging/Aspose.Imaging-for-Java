package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdjustGammaDICOM
{
    public static void main(String... args)
    {
		//ExStart:AdjustingGamma

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "AdjustingGamma.bmp";


        File file = new File(inputFile);
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream(file);

            // Load a DICOM image in an instance of DicomImage
            com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage)Image.load(fis);

			try
			{
				// Adjust the gamma
				image.adjustGamma(50);

				// Create an instance of BmpOptions for the resultant image and Save the
				// resultant image
				image.save(outputFile, new com.aspose.imaging.imageoptions.BmpOptions());
			}
			finally
			{
				image.close();
			}

			fis.close();
		}
        catch (IOException ex)
        {
            Logger.getLogger(AdjustingBrightness.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ExEnd:AdjustingGamma
    }
}