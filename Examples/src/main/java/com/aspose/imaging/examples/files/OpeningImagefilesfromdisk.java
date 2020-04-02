package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class OpeningImagefilesfromdisk
{
    public static void main(String[] args)
    {
        Logger.startExample("OpeningImagefilesfromdisk");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "files/";
        //Create an Image object and load an existing file using the file path
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp");
        image.close();

        //Print message
        Logger.println("Image is loaded successfully.");

        Logger.endExample();
    }
}
