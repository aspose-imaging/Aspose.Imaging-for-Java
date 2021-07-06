package com.aspose.imaging.examples.ModifyingImages.apng;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.apng.ApngImage;
import com.aspose.imaging.imageoptions.ApngOptions;

public class GetOriginalOptions
{
    public static void main(String... args)
    {
        Logger.startExample();

        String dataDir = Utils.getSharedDataDir() + "APNG/";

        try (ApngImage image = (ApngImage) Image.load(Path.combine(dataDir, "SteamEngine.png")))
        {
            ApngOptions options = (ApngOptions)image.getOriginalOptions();
            if (options.getNumPlays() != 0 || options.getDefaultFrameTime() != 10 || options.getBitDepth() != 8)
            {
                System.err.println("Exist some errors in default options");
            }
        }

        Logger.endExample();
    }
}