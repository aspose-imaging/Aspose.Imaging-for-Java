package com.aspose.imaging.examples.ModifyingImages.psd;

import com.aspose.imaging.Graphics;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PsdOptions;

public class UncompressedImageUsingFile
{
    public static void main(String[] args)
    {
        //ExStart:UncompressedImageUsingFile
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "psd/";

        // First convert the image to raw PSD format.
        try (PsdImage psdImage = (PsdImage) Image.load(dataDir + "PsdImage.psd"))
        {
            PsdOptions saveOptions = new PsdOptions();
            saveOptions.setCompressionMethod(CompressionMethod.Raw);
            psdImage.save(dataDir + "uncompressed_out.psd", saveOptions);
        }

        // Now reopen the newly created image.
        try (PsdImage psdImage = (PsdImage)Image.load(dataDir + "uncompressed_out.psd"))
        {
            Graphics graphics = new Graphics(psdImage);
            // Perform graphics operations.

        }
        //ExEnd:UncompressedImageUsingFile
    }
}
