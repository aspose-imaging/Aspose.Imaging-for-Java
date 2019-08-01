package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.RasterImage;

import com.aspose.imaging.imageoptions.TiffOptions;

public class OptimizationStrategyInRotate {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(Utils.class) + "ModifyingImages/";

        String fileName = "SampleTiff1.tiff";
        String inputFileName = dataDir + fileName;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setBufferSizeHint(50);
        try (Image image = Image.load(inputFileName, loadOptions))
        {
            // perform RotateFlip operation
            image.rotateFlip(RotateFlipType.Rotate90FlipNone);
            // perform Rotate operation
            ((RasterImage)image).rotate(60); // rotate 60 degrees clockwise
        }
	}
}
