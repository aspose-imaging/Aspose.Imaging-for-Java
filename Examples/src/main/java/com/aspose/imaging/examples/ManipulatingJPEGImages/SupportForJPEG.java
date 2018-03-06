package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.jpeg.JpegLsInterleaveMode;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class SupportForJPEG
{
	public static void main(String... args) throws Exception {
		//ExStart:SupportForJPEG
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SupportForJPEG.class) + "ManipulatingJPEGImages/";

		String sourceJpegFileName = "lena24b.jls";
                String outputPngFileName = "lena24b.png";
                String outputPngRectFileName = "lena24b_rect.png";

                // Decoding
                JpegImage jpegImage = (JpegImage)Image.load(sourceJpegFileName);
          try
          {
                JpegOptions jpegOptions = jpegImage.getJpegOptions();

                // You can read new options:
                System.out.format("Compression type:           %s\n", JpegCompressionMode.getName(JpegCompressionMode.class, jpegOptions.getCompressionType()));
                System.out.format("Allowed lossy error (NEAR): %d\n", jpegOptions.getJpegLsAllowedLossyError());
                System.out.format("Interleaved mode (ILV):     %s\n", JpegLsInterleaveMode.getName(JpegLsInterleaveMode.class, jpegOptions.getJpegLsInterleaveMode()));
                System.out.format("Horizontal sampling:        %s\n", arrayToString(jpegOptions.getHorizontalSampling()));
                System.out.format("Vertical sampling:          %s\n", arrayToString(jpegOptions.getVerticalSampling()));

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
		//ExEnd:SupportForJPEG
  }

    private static Object[] arrayToString(byte[] horizontalSampling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
