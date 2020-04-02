package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.DitheringMethod;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class DitheringRasterImages
{
    public static void main(String... args)
    {
		Logger.startExample("DitheringRasterImages");
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
		try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Perform Floyd Steinberg dithering on the current image
			image.dither(DitheringMethod.ThresholdDithering, 4);

			// Save the resultant image
			image.save(Utils.getOutDir() + "DitheringRasterImages_out.bmp");
		}
		Logger.endExample();
    }

}
