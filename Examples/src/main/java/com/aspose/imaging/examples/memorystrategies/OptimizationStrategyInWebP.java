package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.WebPOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class OptimizationStrategyInWebP
{
    public static void main(String... args)
    {
        Logger.startExample("OptimizationStrategyInWebP");
        try (WebPOptions imageOptions = new WebPOptions())
        {
            imageOptions.setSource(new FileCreateSource(Utils.getOutDir() + "created.webp", false));
            imageOptions.setBufferSizeHint(50);

            try(Image image = Image.create(imageOptions, 1000, 1000))
            {
                // Do something with the created image
                image.save();
            }
        }
        Logger.endExample();
    }
}
