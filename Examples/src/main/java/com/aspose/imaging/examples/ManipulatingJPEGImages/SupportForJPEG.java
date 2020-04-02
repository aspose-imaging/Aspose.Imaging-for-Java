package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.jpeg.JpegLsInterleaveMode;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;

import java.util.Arrays;

public class SupportForJPEG
{
    public static void main(String... args)
    {
        Logger.startExample("SupportForJPEG");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        String sourceJpegFileName = dataDir + "lena24b.jls";
        String outputPngFileName = dataDir + "lena24b.png";
        String outputPngRectFileName = dataDir + "lena24b_rect.png";

        // Decoding
        JpegImage jpegImage = (JpegImage) Image.load(sourceJpegFileName);
        try
        {
            JpegOptions jpegOptions = jpegImage.getJpegOptions();

            // You can read new options:
            Logger.println("Compression type:           ", JpegCompressionMode.getName(JpegCompressionMode.class, jpegOptions.getCompressionType()));
            Logger.println("Allowed lossy error (NEAR): ", jpegOptions.getJpegLsAllowedLossyError());
            Logger.println("Interleaved mode (ILV):     ", JpegLsInterleaveMode.getName(JpegLsInterleaveMode.class, jpegOptions.getJpegLsInterleaveMode()));
            Logger.println("Horizontal sampling:        ", arrayToString(jpegOptions.getHorizontalSampling()));
            Logger.println("Vertical sampling:          ", arrayToString(jpegOptions.getVerticalSampling()));

            // Save the original JPEG-LS image to PNG.
            jpegImage.save(outputPngFileName, new PngOptions());

            // Save the bottom-right quarter of the original JPEG-LS to PNG
            Rectangle quarter = new Rectangle(jpegImage.getWidth() / 2, jpegImage.getHeight() / 2, jpegImage.getWidth() / 2, jpegImage.getHeight() / 2);
            jpegImage.save(outputPngRectFileName, new PngOptions(), quarter);
        }
        finally
        {
            jpegImage.dispose();
        }
        Logger.endExample();
    }

    private static String arrayToString(byte[] array)
    {
        return Arrays.toString(array);
    }

}
