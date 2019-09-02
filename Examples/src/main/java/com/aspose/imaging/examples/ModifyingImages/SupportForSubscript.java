package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForSubscript
{

    public static void main(String... args)
    {
        //ExStart:SupportForSubscript
        Image image = Image.load("test.bmp");
        try
        {
            image.save("test.bmp.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SupportForSubscript

    }
}