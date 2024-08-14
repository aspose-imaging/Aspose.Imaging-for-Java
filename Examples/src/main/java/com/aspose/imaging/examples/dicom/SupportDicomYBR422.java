package com.aspose.imaging.examples.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class SupportDicomYBR422
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String inputFile = dataDir + "input.dcm";
        String outputFile = Utils.getOutDir() + "SupportDicomYBR422.png";
        try (Image image = Image.load(inputFile))
        {
            image.save(outputFile);
        }

        Utils.deleteFile(outputFile);
        Logger.endExample();
    }
}
