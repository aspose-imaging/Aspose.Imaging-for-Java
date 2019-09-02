package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportBMPHeader
{


    public static void main(String... args) throws Exception
    {
        //ExStart:SupportBMPHeader
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        Image image = Image.load(dataDir + "test.bmp");
        try
        {
            image.save("test.bmp.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SupportBMPHeader
    }
}