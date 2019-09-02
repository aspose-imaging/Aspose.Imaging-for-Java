package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class ConvOfOtherFormatsToSVG
{
    public static void main(String... args)
    {
        //ExStart:ConvOfOtherFormatsToSVG
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        Image image = Image.load(dataDir + "mysvg.svg");
        try
        {
            image.save(dataDir + "yoursvg.svg");
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:ConvOfOtherFormatsToSVG
    }
}
