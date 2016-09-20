package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadJpegEXIFTags {
	public static void main(String... args) throws Exception {
		// ExStart:ReadJpegEXIFTags
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ReadJpegEXIFTags.class) + "ManipulatingJPEGImages/";

		// Load the image in an instance of JpegImage
		JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg");

		if (image.getExifData() != null) {
			// Get the image thumbnail information and save it in an instance of
			// JpegImage
			JpegImage thumbnail = (JpegImage) image.getExifData().getThumbnail();

			// Save the thumbnail to disk with a new name
			thumbnail.save(dataDir + "ReadJpegEXIFTags_out.jpg");
		}
		// ExEnd:ReadJpegEXIFTags
	}

}
