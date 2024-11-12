package com.aspose.imaging.examples.avif;


import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.avif.AvifImage;


public class LoadAvif
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String baseFolder = Utils.getSharedDataDir() + "AVIF/";

        try (AvifImage image = (AvifImage) Image.load(baseFolder + "example.avif"))
        {
            System.out.println("AVIF image is loaded! Format: " + FileFormat.toString(FileFormat.class, image.getFileFormat()));
            System.out.println("Size: " + image.getSize());
        }

        Logger.endExample();
    }
}