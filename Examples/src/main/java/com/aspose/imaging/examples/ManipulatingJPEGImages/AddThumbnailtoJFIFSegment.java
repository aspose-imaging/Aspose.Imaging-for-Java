package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JFIFData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AddThumbnailtoJFIFSegment
{
    public static void main(String... args)
    {
		//ExStart:AddThumbnailtoJFIFSegment

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        //Create an instance of JpegImage to store the thumbnail
        JpegImage thumbnailImage = new JpegImage(100, 100);

		try
		{
			//Create another instance of JpegImage as primary image
			JpegImage image = new JpegImage(1000, 1000);

			try
			{
				//Set the Jfif value as new JFIFData
				image.setJfif(new JFIFData());

				//Store the thumbnail in the Jfif segment
				image.getJfif().setThumbnail(thumbnailImage);

				//Save the resultant image
				image.save(dataDir + "AddThumbnailtoJFIFSegment_out.jpg");
			}
			finally
			{
				image.close();
			}
		}
		finally
		{
			thumbnailImage.close();
		}
		//ExEnd:AddThumbnailtoJFIFSegment
    }

}
