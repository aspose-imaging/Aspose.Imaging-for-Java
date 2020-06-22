package com.aspose.imaging.examples.ModifyingImages.apng;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.ApngOptions;

public class CreateAnimationFromMultipageImage
{
    public static void main(String... args)
    {
        Logger.startExample("CreateAnimationFromMultipageImage");
        String dataDir = Utils.getSharedDataDir() + "APNG/";
        String fileName = "img4.tif";
        String inputFilePath = dataDir + fileName;
        String outputFilePath = Utils.getOutDir() + "img4.tif.500ms.png";

        try (Image image = Image.load(inputFilePath))
        {
            // Setting up the default frame duration
            ApngOptions op = new ApngOptions();
            op.setDefaultFrameTime(500); // 500 ms
            image.save(outputFilePath, op);
        }

        Utils.deleteFile(outputFilePath);
        Logger.endExample();
    }
}