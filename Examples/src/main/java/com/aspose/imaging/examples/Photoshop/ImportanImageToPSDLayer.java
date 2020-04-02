package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class ImportanImageToPSDLayer
{
    public static void main(String... args)
    {
		Logger.startExample("ImportanImageToPSDLayer");
		// Declare variables to store file paths for input and output.
		String dataDir = Utils.getSharedDataDir() + "Photoshop/";
        String sourceFileName = dataDir + "samplePsd.psd";
        String outputFileName = Utils.getOutDir() + "ImportanImageToPSDLayer_out.psd";

        // Load a PSD file as an image and caste it into PsdImage
		try (com.aspose.imaging.fileformats.psd.PsdImage image = (com.aspose.imaging.fileformats.psd.PsdImage) com.aspose.imaging.Image
				.load(sourceFileName))
		{
			//Extract a layer from PSDImage
			com.aspose.imaging.fileformats.psd.layers.Layer layer = image.getLayers()[1];

			// Load the image that is needed to be imported into the PSD file.
			String normalImagePath = dataDir + "aspose_logo.png";

			try (com.aspose.imaging.RasterImage drawImage = (com.aspose.imaging.RasterImage) com.aspose.imaging.Image
					.load(normalImagePath))
			{
				// Call DrawImage method of the Layer class and pass the image instance.
				layer.drawImage(new com.aspose.imaging.Point(10, 10), drawImage);
			}

			// Save the results to output path.
			image.save(outputFileName, new com.aspose.imaging.imageoptions.PsdOptions());
		}
		Logger.endExample();
    }

}
