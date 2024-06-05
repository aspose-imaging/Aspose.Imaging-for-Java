package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.JpegExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AddThumbnailtoEXIFSegment
{
    public static void main(String... args)
    {
		Logger.startExample("AddThumbnailtoEXIFSegment");

        // Create an instance of JpegImage to store the thumbnail
		try (JpegImage thumbnailImage = new JpegImage(100, 100))
		{
			// Create another instance of JpegImage as primary image
			try (JpegImage image = new JpegImage(1000, 1000))
			{
				// Set the ExifData value as new JpegExifData
				image.setExifData(new JpegExifData());

				// Store the thumbnail in the Exif segment
				image.getJpegExifData().setThumbnail(thumbnailImage);

				// Save the resultant image
				image.save(Utils.getOutDir() + "AddThumbnailtoEXIFSegment_out.jpg");
			}
		}
		Logger.endExample();
    }

}
