package com.aspose.imaging.examples.ModifyingImages.jpeg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class JpegSavedQualityEstimation
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "/jpeg/";
        try (JpegImage image = (JpegImage) Image.load(dataDir + "test.jpg"))
        {
            boolean isNotDefaultQuality = image.getJpegOptions().getQuality() != 75;
            Logger.printf("isNotDefaultQuality = %b\n", isNotDefaultQuality);
        }

        Logger.endExample();
    }
}
