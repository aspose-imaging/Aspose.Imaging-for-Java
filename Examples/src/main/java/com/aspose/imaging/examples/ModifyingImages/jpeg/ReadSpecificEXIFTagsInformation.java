package com.aspose.imaging.examples.ModifyingImages.jpeg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.ExifData;
import com.aspose.imaging.exif.enums.ExifWhiteBalance;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadSpecificEXIFTagsInformation
{
    public static void main(String... args)
    {
        Logger.startExample("ReadSpecificEXIFTagsInformation");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";
        // Load an image using the factory method Load exposed by Image class
        try (Image image = Image.load(dataDir + "aspose-logo.jpg"))
        {
            // Initialize an object of ExifData and fill it will image's EXIF information
            ExifData exif = ((JpegImage)image).getExifData();

            // Check if image has any EXIF entries defined and Display a few EXIF entries
            if (exif != null)
            {
                Logger.println("Exif WhiteBalance: " + ExifWhiteBalance.toString(ExifWhiteBalance.class, exif.getWhiteBalance()));
                Logger.println("Exif PixelXDimension: " + exif.getPixelXDimension());
                Logger.println("Exif PixelYDimension: " + exif.getPixelYDimension());
                Logger.println("Exif ISOSpeed: " + exif.getISOSpeed());
                Logger.println("Exif FocalLength: " + exif.getFocalLength());
            }
        }
        Logger.endExample();
    }
}
