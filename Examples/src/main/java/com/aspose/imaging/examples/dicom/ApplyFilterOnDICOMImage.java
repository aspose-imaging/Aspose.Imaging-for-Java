package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplyFilterOnDICOMImage
{
    public static void main(String... args)
    {
		//ExStart:ApplyFilterOnDICOMImage

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "ApplyFilterOnDICOMImage_out.bmp";
        File file = new File(inputFile);
        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream(file);

            // Load a DICOM image in an instance of DicomImage
			com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(fis);

			try
			{
				// Supply the filters to DICOM image.
				image.filter(image.getBounds(), new com.aspose.imaging.imagefilters.filteroptions.MedianFilterOptions(8));

				// Save the results to output path.
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
        //ExEnd:ApplyFilterOnDICOMImage
    }
}