package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.JpegExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AddThumbnailtoEXIFSegment {
	public static void main(String... args) throws Exception {
		// ExStart:AddThumbnailtoEXIFSegment
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(AddThumbnailtoEXIFSegment.class) + "ManipulatingJPEGImages/";

		// Create an instance of JpegImage to store the thumbnail
		JpegImage thumbnailImage = new JpegImage(100, 100);

		// Create another instance of JpegImage as primary image
		JpegImage image = new JpegImage(1000, 1000);

		// Set the ExifData value as new JpegExifData
		image.setExifData(new JpegExifData());

		// Store the thumbnail in the Exif segment
		image.getExifData().setThumbnail(thumbnailImage);

		// Save the resultant image
		image.save(dataDir + "AddThumbnailtoEXIFSegment_out.jpg");
		// ExEnd:AddThumbnailtoEXIFSegment
	}

}
