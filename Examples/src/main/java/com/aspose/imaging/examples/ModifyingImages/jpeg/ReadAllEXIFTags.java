package com.aspose.imaging.examples.ModifyingImages.jpeg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.JpegExifData;
import com.aspose.imaging.exif.enums.ExifOrientation;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

public class ReadAllEXIFTags
{
    public static void main(String... args)
    {
        Logger.startExample("ReadAllEXIFTags");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";
        try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg"))
        {
            JpegExifData exifData = image.getJpegExifData();

            if (exifData == null)
                return;

            Logger.println("Camera Owner Name: " + exifData.getCameraOwnerName());
            Logger.println("Aperture Value: " + exifData.getApertureValue());
            Logger.println("Orientation: " + ExifOrientation.toString(ExifOrientation.class, exifData.getOrientation()));
            Logger.println("Focal Length: " + exifData.getFocalLength());
            Logger.println("Compression: " + exifData.getCompression());
        }
        Logger.endExample();
    }
}
