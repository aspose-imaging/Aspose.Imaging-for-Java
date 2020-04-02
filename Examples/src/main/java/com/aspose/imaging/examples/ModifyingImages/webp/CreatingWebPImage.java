package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.WebPOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class CreatingWebPImage
{
    public static void main(String[] args)
    {
        Logger.startExample("CreatingWebPImage");

        // Create an instance of WebPOptions class and set properties
        WebPOptions imageOptions = new WebPOptions();
        imageOptions.setLossless(true);
        imageOptions.setSource(new FileCreateSource(Utils.getOutDir() + "CreatingWebPImage_out.webp", false));

        // Create an instance of image class by using WebOptions instance that you have just created.
        try (Image image = Image.create(imageOptions, 500, 500))
        {
            image.save();
        }
        Logger.endExample();
    }
}
