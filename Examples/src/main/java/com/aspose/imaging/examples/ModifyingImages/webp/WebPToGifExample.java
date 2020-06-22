package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.GifOptions;

public class WebPToGifExample
{
    public static void main(String... args)
    {
        Logger.startExample("WebPToGifExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "WebP/";
        String inputFile = dataDir + "Animation.webp";
        String outputFile = Utils.getOutDir() + "Animation.gif";

        try (Image image = Image.load(inputFile))
        {
            GifOptions options = new GifOptions();

            image.save(outputFile, options);
        }

        Utils.deleteFile(outputFile);

        Logger.endExample();
    }
}
