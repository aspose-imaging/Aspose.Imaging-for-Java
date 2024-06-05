package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.exif.IHasExifData;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.DicomOptions;

import java.util.Date;

public class RemoveAndSaveWithMetadata
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outputFile = Utils.getOutDir() + "output.dcm";

        exportWithMetadata(dataDir + "file.dcm", outputFile, new DicomOptions());

        Utils.deleteFile(outputFile);

        Logger.endExample();
    }

    public static void exportWithMetadata(String inputPath, String outputPath, ImageOptionsBase exportOptions)
    {
        try (Image image = Image.load(inputPath))
        {
            exportOptions.setKeepMetadata(true);
            image.save(outputPath, exportOptions);
        }
    }

    public static void removeMetadata(String inputPath, String outputPath, ImageOptionsBase exportOptions)
    {
        try (Image image = Image.load(inputPath))
        {
            image.removeMetadata();
            image.save(outputPath, exportOptions);
        }
    }

    public static void modifyMetadata(String inputPath, String outputPath, ImageOptionsBase exportOptions)
    {
        try (Image image = Image.load(inputPath))
        {
            if (image instanceof IHasExifData)
            {
                IHasExifData hasExif = (IHasExifData) image;
                if (hasExif.getExifData() != null)
                {
                    hasExif.getExifData().setUserComment("Modified at " + new Date());
                }
                exportOptions.setKeepMetadata(true);
            }

            image.save(outputPath, exportOptions);
        }
    }
}
