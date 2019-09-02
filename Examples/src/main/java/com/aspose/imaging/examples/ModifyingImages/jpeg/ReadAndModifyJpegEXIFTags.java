package com.aspose.imaging.examples.ModifyingImages.jpeg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.exif.JpegExifData;
import com.aspose.imaging.fileformats.jpeg.JpegImage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReadAndModifyJpegEXIFTags
{
    public static void main(String... args) throws InvocationTargetException, IllegalAccessException
    {
        //ExStart:ReadAndModifyJpegEXIFTags
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        try (JpegImage image = (JpegImage) Image.load(dataDir + "aspose-logo.jpg"))
        {
            JpegExifData exifData = image.getExifData();

            if (exifData == null)
                return;

            Class type = exifData.getClass();
            Method[] methods = type.getMethods();

            for (Method m : methods)
            {
                if (m.getParameterTypes().length == 0 &&
                        (m.getName().startsWith("get") || m.getName().startsWith("is")
                                || (m.getName().startsWith("has") && !m.getName().equals("hashCode"))))
                {
                    System.out.println(m.getName() + " : " + m.invoke(exifData));
                }
            }
        }
        //ExEnd:ReadAndModifyJpegEXIFTags
    }

}
