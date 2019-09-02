package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class SavingtoDisk
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        //ExStart:SavingtoDisk
        Image image = Image.load(dataDir + "aspose-logo.jpg");
        try
        {
            // save to the same format
            image.save("SavingtoDisk_out.bmp");
        }
        finally
        {
            image.close();
        }
        //ExEnd:SavingtoDisk

    }

}
