package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadingEXIFData
{
    public static void main(String... args)
    {
		Logger.startExample("ReadingEXIFData");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

		try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
		{
			// Initialize an object of ExifData and fill it will image's EXIF
			// information
			ExifData exif = ((JpegImage) image).getExifData();

			// Check if image has any EXIF entries defined
			if (exif != null)
			{
				// Display a few EXIF entries
				Logger.println("Exif WhiteBalance: " + exif.getWhiteBalance());
				Logger.println("Exif PixelXDimension: " + exif.getPixelXDimension());
				Logger.println("Exif PixelYDimension: " + exif.getPixelYDimension());
				Logger.println("Exif ISOSpeed: " + exif.getISOSpeed());
				Logger.println("Exif BodySerialNumber: " + exif.getBodySerialNumber());
				Logger.println("Exif CameraOwnerName: " + exif.getCameraOwnerName());
				Logger.println("Exif ColorSpace: " + exif.getColorSpace());
				Logger.println("Exif Contrast: " + exif.getContrast());
				Logger.println("Exif CustomRendered: " + exif.getCustomRendered());
				Logger.println("Exif DateTimeDigitized: " + exif.getDateTimeDigitized());
				Logger.println("Exif DateTimeOriginal: " + exif.getDateTimeOriginal());
				Logger.println("Exif ExposureMode: " + exif.getExposureMode());
				Logger.println("Exif ExposureProgram: " + exif.getExposureProgram());
				Logger.println("Exif Flash: " + exif.getFlash());
				Logger.println("Exif FocalLengthIn35MmFilm: " + exif.getFocalLengthIn35MmFilm());
				Logger.println("Exif FocalPlaneResolutionUnit: " + exif.getFocalPlaneResolutionUnit());
				Logger.println("Exif GainControl: " + exif.getGainControl());
				Logger.println("Exif ImageUniqueID: " + exif.getImageUniqueID());
				Logger.println("Exif Sharpness: " + exif.getSharpness());
				Logger.println("Exif MeteringMode: " + exif.getMeteringMode());
			}
		}
		//ExEnd:ReadingEXIFData
    }

}
