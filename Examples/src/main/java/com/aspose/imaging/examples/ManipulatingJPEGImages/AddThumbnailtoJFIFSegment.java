package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JFIFData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class AddThumbnailtoJFIFSegment {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(AddThumbnailtoJFIFSegment.class) + "ManipulatingJPEGImages/";
		//ExStart:AddThumbnailtoJFIFSegment
		
		//Create an instance of JpegImage to store the thumbnail
		JpegImage thumbnailImage = new JpegImage(100, 100);

		//Create another instance of JpegImage as primary image
		JpegImage image = new JpegImage(1000, 1000);

		//Set the Jfif value as new JFIFData
		image.setJfif( new JFIFData());

		//Store the thumbnail in the Jfif segment
		image.getJfif().setThumbnail(thumbnailImage);

		//Save the resultant image
		image.save(dataDir + "AddThumbnailtoJFIFSegment_out.jpg");
		//ExEnd:AddThumbnailtoJFIFSegment
	}

}
