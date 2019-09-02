package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SupportForCMYKAndYCCKColorModesInJPEGLossless
{
    public static void main(String... args)
    {
        //ExStart:SupportForCMYKAndYCCKColorModesInJPEGLossless

        // The path to the documents directory.
        ByteArrayOutputStream jpegStream_cmyk = new ByteArrayOutputStream();
        ByteArrayOutputStream jpegStream_ycck = new ByteArrayOutputStream();

        // Save to JPEG Lossless CMYK
        JpegImage image = (JpegImage) Image.load("056.jpg");
        try
        {
            JpegOptions options = new JpegOptions();
            options.setCompressionType(JpegCompressionMode.Lossless);

            // The default profiles will be used.
            options.setRgbColorProfile(null);
            options.setCmykColorProfile(null);

            // Save to Cmyk
            options.setColorType(JpegCompressionColorMode.Cmyk);
            image.save(jpegStream_cmyk, options);

            // Save to Ycck
            options.setColorType(JpegCompressionColorMode.Ycck);
            image.save(jpegStream_ycck, options);

            options.dispose();
        }
        finally
        {
            image.dispose();
        }

        // Load from JPEG Lossless CMYK
        image = (JpegImage) Image.load(new ByteArrayInputStream(jpegStream_cmyk.toByteArray()));
        try
        {
            image.save("056_cmyk.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }

        // Load from JPEG Lossless Ycck
        image = (JpegImage) Image.load(new ByteArrayInputStream(jpegStream_ycck.toByteArray()));
        try
        {
            image.save("056_ycck.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SupportForCMYKAndYCCKColorModesInJPEGLossless
    }
}
            
