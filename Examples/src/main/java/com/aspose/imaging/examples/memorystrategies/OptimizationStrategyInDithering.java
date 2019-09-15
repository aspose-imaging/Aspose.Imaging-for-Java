package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.DitheringMethod;
import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;

public class OptimizationStrategyInDithering
{
    public static void main(String... args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String fileName = "SampleTiff1.tiff";
        String output = "SampleTiff1.out.tiff";
        String inputFileName = dataDir + fileName;

        // Setting a memory limit of 50 megabytes for target loaded image
        try (RasterImage image = (RasterImage) Image.load(inputFileName, new LoadOptions() {{ setBufferSizeHint(50); }}))
        {
            // perform dithering operation
            image.dither(DitheringMethod.FloydSteinbergDithering, 1);

            image.save(Utils.getOutDir() + output);
        }
    }
}
