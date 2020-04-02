package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportFor2
{
    public static void main(String... args)
    {
        Logger.startExample("SupportFor2");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";

        int bpp = 2; // Set 2 bits per sample to see the difference in size and quality

        // The origin PNG with 8 bits per sample
        String originPngFileName = dataDir + "lena24b.png";

        // The output JPEG-LS with 2 bits per sample.
        String outputJpegFileName = Utils.getOutDir() + "lena24b " + bpp + "-bit Gold.jls";

        PngImage pngImage = (PngImage) Image.load(originPngFileName);
        try
        {
            JpegOptions jpegOptions = new JpegOptions();
            jpegOptions.setBitsPerChannel((byte) bpp);
            jpegOptions.setCompressionType(JpegCompressionMode.JpegLs);
            pngImage.save(outputJpegFileName, jpegOptions);
        }
        finally
        {
            pngImage.dispose();
        }

        // The output PNG is produced from JPEG-LS to check image visually.
        String outputPngFileName = Utils.getOutDir() + "lena24b " + bpp + "-bit Gold.png";
        JpegImage jpegImage = (JpegImage) Image.load(outputJpegFileName);
        try
        {
            jpegImage.save(outputPngFileName, new PngOptions());
        }
        finally
        {
            jpegImage.dispose();
        }
        Logger.endExample();
    }

}
