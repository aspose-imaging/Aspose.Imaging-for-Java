package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.sources.StreamSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;

public class SupportForCMYKAndYCCKColorModesInJPEGLosslessUsingRGBProfile
{
    public static void main(String... args) throws Exception
    {
        Logger.startExample("SupportForCMYKAndYCCKColorModesInJPEGLosslessUsingRGBProfile");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        ByteArrayOutputStream jpegStream_cmyk = new ByteArrayOutputStream();
        ByteArrayOutputStream jpegStream_ycck = new ByteArrayOutputStream();

        // Save to JPEG Lossless CMYK
        JpegImage image = (JpegImage) Image.load(dataDir + "056.jpg");
        try
        {
            JpegOptions options = new JpegOptions();
            options.setCompressionType(JpegCompressionMode.Lossless);

            // Save with specified profiles
            StreamSource rgbColorProfile = new StreamSource(new RandomAccessFile(dataDir + "eciRGB_v2.icc", "r"));
            StreamSource cmykColorProfile = new StreamSource(new RandomAccessFile(dataDir + "ISOcoated_v2_FullGamut4.icc", "r"));

            // The default profiles will be used.
            options.setRgbColorProfile(rgbColorProfile);
            options.setCmykColorProfile(cmykColorProfile);

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
            image.save(Utils.getOutDir() + "056_cmyk_profile.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }

        // Load from JPEG Lossless Ycck
        image = (JpegImage) Image.load(new ByteArrayInputStream(jpegStream_ycck.toByteArray()));
        try
        {
            image.save(Utils.getOutDir() + "056_ycck_profile.png", new PngOptions());
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }

}
