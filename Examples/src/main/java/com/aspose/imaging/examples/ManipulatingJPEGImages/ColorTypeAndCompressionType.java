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
import com.aspose.imaging.sources.FileCreateSource;

public class ColorTypeAndCompressionType {
	public static void main(String... args) throws Exception {
		
              //ExStart:ColorTypeAndCompressionType
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ColorTypeAndCompressionType.class) + "ManipulatingJPEGImages/";
                Image original = Image.load(dataDir+"ColorGif.gif");
         try
          {
	     JpegOptions jpegOptions = new JpegOptions()
	 {{
		setColorType(JpegCompressionColorMode.Grayscale);
		setCompressionType(JpegCompressionMode.Progressive);
	}};
	     original.save("result.jpg", jpegOptions);
          }
      finally
          {
	   original.dispose();
          }
          }
		//ExEnd:ColorTypeAndCompressionType
        }
     
