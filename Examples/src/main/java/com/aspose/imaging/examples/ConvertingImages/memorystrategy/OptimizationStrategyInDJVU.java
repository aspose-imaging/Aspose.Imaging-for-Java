package com.aspose.imaging.examples.ConvertingImages.memorystrategy;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.djvu.DjvuPage;
import com.aspose.imaging.imageoptions.PngOptions;

public class OptimizationStrategyInDJVU
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        try (DjvuImage image = (DjvuImage) Image.load(Path.combine(dataDir,"test.djvu"), new LoadOptions() {{ setBufferSizeHint(50); }}))
        {
            int pageNum = 0;
            for (DjvuPage page : image.getPages())
            {
                page.save(Path.combine(Utils.getOutDir(), "page" + pageNum + ".png"), new PngOptions());
                pageNum++;
            }
        }
    }
}
