package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class AutoAdjustImageBrightness
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";

        String outputFilePath = Utils.getOutDir() + "result.png";
        String outputFilePath2 = Utils.getOutDir() + "result2.png";
        // Load an existing JPG image
        try (RasterImage image = (RasterImage) Image.load(dataDir + "sample.png"))
        {
            image.normalizeHistogram();
            image.save(outputFilePath);
            image.adjustContrast(30);
            image.save(outputFilePath2);
        }

        Utils.deleteFile(outputFilePath);
        Utils.deleteFile(outputFilePath2);

        Logger.endExample();
    }
}
