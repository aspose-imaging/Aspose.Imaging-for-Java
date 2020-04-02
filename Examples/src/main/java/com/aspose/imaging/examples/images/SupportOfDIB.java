package com.aspose.imaging.examples.images;

import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

/**
 * @author mfazi
 */
public class SupportOfDIB
{
    public static void main(String[] args)
    {
        Logger.startExample("SupportOfDIB");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        try (Image image = Image.load(dataDir + "sample.dib"))
        {
            Logger.println(FileFormat.toString(FileFormat.class, image.getFileFormat())); // Output is "Bmp"
            image.save(Utils.getOutDir() + "sample.png", new PngOptions());
        }

        Logger.endExample();
    }

}
