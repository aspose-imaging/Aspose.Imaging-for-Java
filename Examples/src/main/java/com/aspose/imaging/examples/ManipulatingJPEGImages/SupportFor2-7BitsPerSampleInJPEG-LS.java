package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class SupportFor2-7BitsPerSampleInJPEG-LS {
	public static void main(String... args) throws Exception {
		// ExStart:SupportFor2-7BitsPerSampleInJPEG-LS
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SupportFor2-7BitsPerSampleInJPEG-LS.class) + "ManipulatingJPEGImages/";

		int bpp = 2; // Set 2 bits per sample to see the difference in size and quality

                // The origin PNG with 8 bits per sample
                String originPngFileName = "lena24b.png";

                // The output JPEG-LS with 2 bits per sample.
                String outputJpegFileName = "lena24b " + bpp + "-bit Gold.jls";

                PngImage pngImage = (PngImage)Image.load(originPngFileName);
       try
          {
        	JpegOptions jpegOptions = new JpegOptions();
	        jpegOptions.setBitsPerChannel((byte)bpp);
	        jpegOptions.setCompressionType(JpegCompressionMode.JpegLs);
	        pngImage.save(outputJpegFileName, jpegOptions);
          }
     finally
          {
	        pngImage.dispose();
           }

                // The output PNG is produced from JPEG-LS to check image visually.
                String outputPngFileName = "lena24b " + bpp + "-bit Gold.png";
                JpegImage jpegImage = (JpegImage)Image.load(outputJpegFileName);
         try
          {
	        jpegImage.save(outputPngFileName, new PngOptions());
          }
       finally
       {
         	jpegImage.dispose();
      }
		// ExEnd:SupportFor2-7BitsPerSampleInJPEG-LS
  }

}
