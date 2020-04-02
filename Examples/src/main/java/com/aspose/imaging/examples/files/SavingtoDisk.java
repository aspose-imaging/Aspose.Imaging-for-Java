package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class SavingtoDisk
{
    public static void main(String[] args)
    {
        Logger.startExample("SavingtoDisk");
        String dataDir = Utils.getSharedDataDir() + "dicom/";

        try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
        {
            // save to the same format
            image.save(Utils.getOutDir() + "SavingtoDisk_out.bmp");
        }
        Logger.endExample();
    }

}
