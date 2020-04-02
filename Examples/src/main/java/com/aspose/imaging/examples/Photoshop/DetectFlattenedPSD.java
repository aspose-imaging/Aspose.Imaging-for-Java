package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DetectFlattenedPSD
{
    public static void main(String... args)
    {
		Logger.startExample("DetectFlattenedPSD");
		String dataDir = Utils.getSharedDataDir() + "Photoshop/";
		String flattenPath = dataDir + "sample.psd";
        // Create an instance of Image class and load PSD file as image.
		com.aspose.imaging.fileformats.psd.PsdImage psdImage;
		try (com.aspose.imaging.Image objImage = com.aspose.imaging.Image.load(flattenPath))
		{

			// Cast image object to PSD image
			psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) objImage;
			// do processing

			// Get the true value if PSD is flatten and false in case the PSD is not flatten.
			Logger.println("Is flatten: " + psdImage.isFlatten());
		}

		Logger.endExample();
    }

}
