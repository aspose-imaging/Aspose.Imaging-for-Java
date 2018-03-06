package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadingEXIFData {
	public static void main(String... args) throws Exception {
		//ExStart:ReadingEXIFData
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ReadingEXIFData.class) + "ManipulatingJPEGImages/";
		Image image = Image.load(dataDir + "aspose-logo.jpg");

		// Initialize an object of ExifData and fill it will image's EXIF
		// information
		ExifData exif = ((JpegImage) image).getExifData();

		// Check if image has any EXIF entries defined
		if (exif != null) {
			// Display a few EXIF entries
			System.out.println("Exif WhiteBalance: " + exif.getWhiteBalance());
			System.out.println("Exif PixelXDimension: " + exif.getPixelXDimension());
			System.out.println("Exif PixelYDimension: " + exif.getPixelYDimension());
			System.out.println("Exif ISOSpeed: " + exif.getISOSpeed());
			System.out.println("Exif BodySerialNumber: " + exif.getBodySerialNumber());
			System.out.println("Exif CameraOwnerName: " + exif.getCameraOwnerName());
			System.out.println("Exif ColorSpace: " + exif.getColorSpace());
			System.out.println("Exif Contrast: " + exif.getContrast());
			System.out.println("Exif CustomRendered: " + exif.getCustomRendered());
			System.out.println("Exif DateTimeDigitized: " + exif.getDateTimeDigitized());
			System.out.println("Exif DateTimeOriginal: " + exif.getDateTimeOriginal());
			System.out.println("Exif ExposureMode: " + exif.getExposureMode());
			System.out.println("Exif ExposureProgram: " + exif.getExposureProgram());
			System.out.println("Exif Flash: " + exif.getFlash());
			System.out.println("Exif FocalLengthIn35MmFilm: " + exif.getFocalLengthIn35MmFilm());
			System.out.println("Exif FocalPlaneResolutionUnit: " + exif.getFocalPlaneResolutionUnit());
			System.out.println("Exif GainControl: " + exif.getGainControl());
			System.out.println("Exif ImageUniqueID: " + exif.getImageUniqueID());
			System.out.println("Exif Sharpness: " + exif.getSharpness());
			System.out.println("Exif MeteringMode: " + exif.getMeteringMode());
		}
		//ExEnd:ReadingEXIFData
	}

}
