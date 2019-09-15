package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;

public class Deskew
{
    public static void main(String... args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        String fileName = "skewed.png";
        String output = "skewed.out.png";
        String inputFileName = dataDir + fileName;

        // Get rid of the skewed scan with default parameters
        try (RasterImage image = (RasterImage) Image.load(inputFileName))
        {
            image.normalizeAngle(false /*do not resize*/, Color.getLightGray() /*background color*/);
            image.save(Utils.getOutDir() + output);
        }
    }
}
