package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class ConvOfOtherFormatsToSVG
{
    public static void main(String... args)
    {
        Logger.startExample("ConvOfOtherFormatsToSVG");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        Image image = Image.load(dataDir + "mysvg.svg");
        try
        {
            image.save(Utils.getOutDir() + "yoursvg.svg");
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}
