package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.filteroptions.FilterOptionsBase;
import com.aspose.imaging.imagefilters.filteroptions.MedianFilterOptions;

public class OptimizationStrategyInFilters
{
    public static void main(String... args)
    {
        Logger.startExample("OptimizationStrategyInFilters");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String fileName = "SampleTiff1.tiff";
        String output = "SampleTiff1.out.tiff";
        String inputFileName = dataDir + fileName;

        // Setting a memory limit of 50 megabytes for target loaded image
        try (RasterImage image = (RasterImage) Image.load(inputFileName, new LoadOptions() {{ setBufferSizeHint(50); }}))
        {
            FilterOptionsBase filterOptions = new MedianFilterOptions(6 /*size*/);
            image.filter(image.getBounds(), filterOptions);
            image.save(Utils.getOutDir() + output);
        }
        Logger.endExample();
    }
}
