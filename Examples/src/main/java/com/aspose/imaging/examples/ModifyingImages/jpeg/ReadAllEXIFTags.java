package com.aspose.imaging.examples.ModifyingImages.jpeg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.JpegExifData;
import com.aspose.imaging.exif.enums.ExifOrientation;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadAllEXIFTags
{
    public static void main(String... args)
    {
        //ExStart:ReadAllEXIFTags
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";
        try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg"))
        {
            JpegExifData exifData = image.getExifData();

            if (exifData == null)
                return;

            System.out.println("Camera Owner Name: " + exifData.getCameraOwnerName());
            System.out.println("Aperture Value: " + exifData.getApertureValue());
            System.out.println("Orientation: " + ExifOrientation.toString(ExifOrientation.class, exifData.getOrientation()));
            System.out.println("Focal Length: " + exifData.getFocalLength());
            System.out.println("Compression: " + exifData.getCompression());
        }
        //ExEnd:ReadAllEXIFTags
    }
}
