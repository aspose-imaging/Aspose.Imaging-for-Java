package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.OpenTypeFontsCache;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;

public class ForceFontCache
{
    public static void main(String[] args) throws Exception
    {
        Logger.startExample("ForceFontCache");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "images/";

        PsdImage image = (PsdImage) Image.load(dataDir + "input.psd");
        try
        {
            image.save(Utils.getOutDir() + "NoFont.psd");
        }
        finally
        {
            image.dispose();
        }

        Logger.println("You have 2 minutes to install the font");
        Thread.sleep(2 * 60 * 1000);
        OpenTypeFontsCache.updateCache();

        image = (PsdImage) Image.load(dataDir + "input.psd");
        try
        {
            image.save(Utils.getOutDir() + "HasFont.psd");
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}




