package com.aspose.imaging.examples.images;

import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

/**
 * @author mfazi
 */
public class SupportOfDIB
{
    public static void main(String[] args)
    {
        //ExStart:SupportOfDIB
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        Image image = Image.load(dataDir + "sample.dib");
        try
        {
            System.out.println(FileFormat.toString(FileFormat.class, image.getFileFormat())); // Output is "Bmp"
            image.save(dataDir + "sample.png", new PngOptions());
        }
        finally
        {
            image.close();
        }

        //ExEnd:SupportOfDIB
    }

}
