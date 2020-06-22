package com.aspose.imaging.examples.ModifyingImages.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class DicomToPngExample
{
    public static void main(String[] args)
    {
        Logger.startExample("DicomToPngExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outFile = Utils.getOutDir() + "MultiframePage1.png";

        String inputFile = dataDir + "MultiframePage1.dicom";

        try (Image image = Image.load(inputFile))
        {
            PngOptions options = new PngOptions();

            image.save(outFile, options);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }
}
