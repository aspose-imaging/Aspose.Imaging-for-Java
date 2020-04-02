package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JFIFData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AddThumbnailtoJFIFSegment
{
    public static void main(String... args)
    {
		Logger.startExample("AddThumbnailtoJFIFSegment");

        // The path to the documents directory.
        String dataDir = Utils.getOutDir();

        //Create an instance of JpegImage to store the thumbnail
		try (JpegImage thumbnailImage = new JpegImage(100, 100))
		{
			//Create another instance of JpegImage as primary image
			try (JpegImage image = new JpegImage(1000, 1000))
			{
				//Set the Jfif value as new JFIFData
				image.setJfif(new JFIFData());

				//Store the thumbnail in the Jfif segment
				image.getJfif().setThumbnail(thumbnailImage);

				//Save the resultant image
				image.save(dataDir + "AddThumbnailtoJFIFSegment_out.jpg");
			}
		}
		Logger.endExample();
    }

}
