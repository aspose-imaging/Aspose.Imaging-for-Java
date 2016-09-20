package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class WritingAndModifyingEXIFData {
	public static void main(String... args) throws Exception {
		// ExStart:WritingAndModifyingEXIFData
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(WritingAndModifyingEXIFData.class) + "ManipulatingJPEGImages/";

		// Load an image using the factory method load exposed by Image class
		Image image = Image.load(dataDir + "aspose-logo.jpg");

		// Initialize an object of ExifData and fill it will image's EXIF
		// information
		ExifData exif = ((JpegImage) image).getExifData();

		// Set Lens Make information
		exif.setLensMake("Sony");

		// Set WhiteBalance information
		exif.setWhiteBalance(com.aspose.imaging.exif.enums.ExifWhiteBalance.Auto);

		// Set that Flash was fires
		exif.setFlash(com.aspose.imaging.exif.enums.ExifFlash.Fired);

		// Save the changes to the original image
		image.save();
		// ExEnd:WritingAndModifyingEXIFData
	}

}
