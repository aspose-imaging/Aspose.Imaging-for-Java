package com.aspose.imaging.examples.ModifyingImages.apng;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.GifOptions;

public class ExportAPNGToGif
{
    public static void main(String... args)
    {
        Logger.startExample("ExportAPNGToGif");
        String dataDir = Utils.getSharedDataDir() + "APNG/";
        String fileName = "elephant.png";
        String inputFilePath = dataDir + fileName;
        String outputFilePath = Utils.getOutDir() + "elephant_out.png.gif";

        try (Image image = Image.load(inputFilePath))
        {
            image.save(outputFilePath, new GifOptions());
        }

        Utils.deleteFile(outputFilePath);
        Logger.endExample();
    }
}
