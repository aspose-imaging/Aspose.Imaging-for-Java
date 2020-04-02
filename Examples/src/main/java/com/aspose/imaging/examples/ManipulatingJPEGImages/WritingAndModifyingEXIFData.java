package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class WritingAndModifyingEXIFData
{
    public static void main(String... args) throws IOException
	{
		Logger.startExample("WritingAndModifyingEXIFData");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        // Load an image using the factory method load exposed by Image class
		String workFile = Utils.getOutDir() + "WritingAndModifyingEXIFData.jpg";
		Files.copy(new File(dataDir + "aspose-logo.jpg").toPath(), new File(workFile).toPath(), StandardCopyOption.REPLACE_EXISTING);

		try (Image image = Image.load(workFile))
		{
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
		}
		Logger.endExample();
    }

}
