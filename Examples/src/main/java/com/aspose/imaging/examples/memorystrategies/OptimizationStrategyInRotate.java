package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class OptimizationStrategyInRotate
{
    public static void main(String... args)
    {
        Logger.startExample();

        // The path to the document directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        String fileName = "SampleTiff1.tiff";
        String inputFileName = dataDir + fileName;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setBufferSizeHint(50);
        try (Image image = Image.load(inputFileName, loadOptions))
        {
            // Perform RotateFlip operation
            image.rotateFlip(RotateFlipType.Rotate90FlipNone);
            // Perform Rotate operation
            image.rotate(60); // Rotate 60 degrees clockwise
        }
        Logger.endExample();
    }
}
