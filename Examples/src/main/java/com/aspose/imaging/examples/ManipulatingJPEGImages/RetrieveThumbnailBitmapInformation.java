package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class RetrieveThumbnailBitmapInformation {
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(RetrieveThumbnailBitmapInformation.class) + "ManipulatingJPEGImages/";
//ExStart:RetrieveThumbnailBitmapInformation
		
		// Load the image in an instance of JpegImage
		JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg");

		// Get the image thumbnail information and save it in an instance of
		// JpegImage
		JpegImage thumbnail = (JpegImage) image.getExifData().getThumbnail();

		// Retrieve the thumbnail bitmap information/Pixels in an array of type
		// Color
		Color[] pixels = thumbnail.loadPixels(new Rectangle(0, 0, thumbnail.getWidth(), thumbnail.getHeight()));

		// To save the thumbnail as BMP image, create an instance of BmpOptions
		BmpOptions bmpOptions = new BmpOptions();

		// Set file source in which the results will be stores; last Boolean
		// parameter denotes isTemporal
		bmpOptions.setSource(new FileCreateSource(dataDir + "RetrieveThumbnailBitmapInformation_out.jpg", false));

		// Create a BmpImage while using the instance of BmpOptions and
		// providing resultant dimensions
		BmpImage bmpImage = (BmpImage) Image.create(bmpOptions, thumbnail.getWidth(), thumbnail.getHeight());

		// Copy the thumbnail pixels onto the newly created canvas
		bmpImage.savePixels(bmpImage.getBounds(), pixels);

		// Save the results
		bmpImage.save();
		//ExEnd:RetrieveThumbnailBitmapInformation
	}

}
