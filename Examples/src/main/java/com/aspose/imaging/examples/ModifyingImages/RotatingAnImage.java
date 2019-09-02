package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.examples.Utils;

public class RotatingAnImage
{
    public static void main(String... args)
    {
		//ExStart:RotatingAnImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        // loading an Image
		try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Rotating Image
			image.rotateFlip(RotateFlipType.Rotate270FlipNone);
			image.save(dataDir + "RotatingAnImage_out.jpg");
		}
		//ExEnd:RotatingAnImage
    }

}
