package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class OptimizationStrategyInResize
{
    public static void main(String... args)
    {
        Logger.startExample("OptimizationStrategyInResize");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String fileName = "SampleTiff1.tiff";
        String output = Utils.getOutDir() + "SampleTiff1.out.tiff";
        String inputFileName = dataDir + fileName;

        // Setting a memory limit of 50 megabytes for target loaded image
        try (RasterImage image = (RasterImage) Image.load(inputFileName, new LoadOptions() {{ setBufferSizeHint(50); }}))
        {
            // perform Resize operation
            image.resize(300, 200, ResizeType.LanczosResample);
            image.save(output);
        }
        Logger.endExample();
    }
}
