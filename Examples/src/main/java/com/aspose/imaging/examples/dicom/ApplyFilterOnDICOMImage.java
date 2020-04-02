package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ApplyFilterOnDICOMImage
{
    public static void main(String... args)
    {
        Logger.startExample("ApplyFilterOnDICOMImage");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "image.dcm";
        String outputFile = dataDir + "ApplyFilterOnDICOMImage_out.bmp";
        File file = new File(inputFile);
        try(FileInputStream fis = new FileInputStream(file))
        {
            // Load a DICOM image in an instance of DicomImage
            try (com.aspose.imaging.fileformats.dicom.DicomImage image = (com.aspose.imaging.fileformats.dicom.DicomImage) Image.load(fis))
            {
                // Supply the filters to DICOM image.
                image.filter(image.getBounds(), new com.aspose.imaging.imagefilters.filteroptions.MedianFilterOptions(8));

                // Save the results to output path.
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