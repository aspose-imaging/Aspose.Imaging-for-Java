package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class Support16BitChannel64BitPng
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("png");

        try (RasterImage image = (RasterImage) Image.load(dataDir + "image0.png"))
        {
            ImageOptionsBase options = image.getOriginalOptions();
            image.save(outDir + "result.png", options);
        }

        Utils.deleteFile(outDir + "result.png");

        Logger.endExample();
    }
}
