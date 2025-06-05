package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.File;

public class PngCompressionLevelExample
{
    public static void main(String[] args)
    {
        Logger.startExample();

        String dataDir = Utils.getSharedDataDir() + "Png" + File.separator;
        String outDir = Utils.getOutDir("Png") + File.separator;

        try (RasterImage image = (RasterImage) Image.load(dataDir + "aspose_logo.png"))
        {
            for (int compression = 0; compression <= 10; compression++)
            {
                String outputFile = outDir + String.format("compressionTest%d.png", compression);
                PngOptions options = new PngOptions();
                options.setPngCompressionLevel(compression);
                image.save(outputFile, options);

                Utils.deleteFile(outputFile);
            }
        }

        Logger.endExample();
    }
}
