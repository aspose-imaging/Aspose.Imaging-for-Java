package com.aspose.imaging.examples.ManipulatingJPEGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ColorTypeAndCompressionType
{
    public static void main(String... args)
    {
        //ExStart:ColorTypeAndCompressionType
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingJPEGImages/";
        Image original = Image.load(dataDir + "ColorGif.gif");
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
     
