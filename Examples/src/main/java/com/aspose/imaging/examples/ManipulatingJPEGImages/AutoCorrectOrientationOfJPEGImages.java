package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AutoCorrectOrientationOfJPEGImages
{
    public static void main(String... args)
    {
		Logger.startExample("AutoCorrectOrientationOfJPEGImages");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        //Load a Jpeg image from file path location or stream
		try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg"))
		{
			//Perform the automatic rotation on the image depending on the orientation data stored in the EXIF
			image.autoRotate();

			//Save the result on disc or stream
			image.save(Utils.getOutDir() + "AutoCorrectOrientationOfJPEGImages_out.jpg");
		}
		Logger.endExample();
    }

}
