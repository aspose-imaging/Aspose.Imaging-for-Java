package com.aspose.imaging.examples.images;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class ConcatTIFFImages {
	public static void main(String[] args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ConcatTIFFImages.class) + "images/";
                //ExStart:ConcatTIFFImages 
		// Create an instance of TiffImage and load the copied destination image
		TiffImage image1 = (TiffImage) com.aspose.imaging.Image.load(dataDir + "TestDemo.tif");

		// Create an instance of TiffImage and load the source image
		TiffImage image2 = (TiffImage) com.aspose.imaging.Image.load(dataDir + "sample.tif");

		// Create an instance of TIffFrame and copy active frame of source image
		TiffFrame frame = TiffFrame.copyFrame(image2.getActiveFrame());

		// Add copied frame to destination image
		image1.addFrame(frame);

		// save the image with changes.
		image1.save();

		// Display Status.
		System.out.println("Concatenation of TIF files done successfully!");
                //ExEnd:ConcatTIFFImages 
        
        }
}