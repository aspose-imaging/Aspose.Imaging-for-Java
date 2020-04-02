package com.aspose.imaging.examples.ModifyingImages.psd;

import com.aspose.imaging.Graphics;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PsdOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class UncompressedImageStreamObject
{
    public static void main(String[] args)
    {
        Logger.startExample("UncompressedImageStreamObject");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "psd/";

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // First convert the image to raw PSD format.
        try (PsdImage psdImage = (PsdImage) Image.load(dataDir + "PsdImage.psd"))
        {
            PsdOptions saveOptions = new PsdOptions();
            saveOptions.setCompressionMethod(CompressionMethod.Raw);
            psdImage.save(stream, saveOptions);
        }

        // Now reopen the newly created image.
        try (PsdImage psdImage = (PsdImage)Image.load(new ByteArrayInputStream(stream.toByteArray())))
        {
            Graphics graphics = new Graphics(psdImage);
            // Perform graphics operations.

        }
        Logger.endExample();
    }
}
