package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.sources.FileCreateSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SupportForJPEGLS{
	public static void main(String... args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SupportForJPEGLS.class) + "ManipulatingJPEGImages/";
//ExStart:SupportForJPEGLS
		
		ByteArrayOutputStream jpegLsStream = new ByteArrayOutputStream();

               // Save to CMYK JPEG-LS
               JpegImage image = (JpegImage) Image.load("056.jpg");
        try
        {
	       JpegOptions options = new JpegOptions();
	      //Just replace one line given below in example to use YCCK instead of CMYK

              //options.setColorType(JpegCompressionColorMode.Ycck);
               options.setColorType(JpegCompressionColorMode.Cmyk);
	       options.setCompressionType(JpegCompressionMode.JpegLs);

               // The default profiles will be used.
               options.setRgbColorProfile(null);
	       options.setCmykColorProfile(null);

	       image.save(jpegLsStream, options);
         }

        finally
         {
              image.dispose();
         }

              // Load from CMYK JPEG-LS
              image = (JpegImage) Image.load(new ByteArrayInputStream(jpegLsStream.toByteArray()));
       try
        {
  	      image.save("056_cmyk.png", new PngOptions());
        }
        finally
           {
	      image.dispose();
           } 
           //ExEnd:SupportForJPEGLS
}

}
