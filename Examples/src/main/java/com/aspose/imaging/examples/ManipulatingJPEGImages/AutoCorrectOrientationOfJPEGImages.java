package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AutoCorrectOrientationOfJPEGImages
{
    public static void main(String... args)
    {
		//ExStart:AutoCorrectOrientationOfJPEGImages

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        //Load a Jpeg image from file path location or stream
        JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg");

		try
		{
			//Perform the automatic rotation on the image depending on the orientation data stored in the EXIF
			image.autoRotate();

			//Save the result on disc or stream
			image.save(dataDir + "AutoCorrectOrientationOfJPEGImages_out.jpg");
		}
		finally
		{
			image.close();
		}
		//ExEnd:AutoCorrectOrientationOfJPEGImages
    }

}
