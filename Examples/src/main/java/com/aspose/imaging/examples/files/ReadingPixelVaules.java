package com.aspose.imaging.examples.files;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;


public class ReadingPixelVaules {
    
 public static void main(String... args) throws Exception{

     //ExStart:ReadingPixelVaules 
// The path to the documents directory.
String dataDir = Utils.getSharedDataDir(ReadingPixelVaules.class) + "files/";     
//String dir = "C:\\Errors\\1006\\";
String fileName = "16bit Uncompressed, BigEndian, Rgb, Contiguous Gamma1.0.tif";
 
// ICC profile is not applied for 16-bit color components at the moment, so disable that option explicitly.
LoadOptions loadOptions = new LoadOptions();
loadOptions.setUseIccProfileConversion(false);
 
Rectangle desiredArea = new Rectangle(470, 1350, 30, 30);
 
RasterImage image = (RasterImage)Image.load(dataDir + fileName, loadOptions);
try
{
    long[] colors64Bit = image.loadArgb64Pixels(image.getBounds());
 
    int alpha, red, green, blue;
    for (int y = desiredArea.getTop(); y < desiredArea.getBottom(); ++y)
    {
        for (int x = desiredArea.getLeft(); x < desiredArea.getRight(); ++x)
        {
            int offset = y * image.getWidth() + x;
            long color64 = colors64Bit[offset];
 
            alpha = (int)((color64 >> 48) & 0xffff);
            red = (int)((color64 >> 32) & 0xffff);
            green = (int)((color64 >> 16) & 0xffff);
            blue = (int)(color64 & 0xffff);
 
            System.out.format("A=%X, R=%X, G=%X, B=%X\n", alpha, red, green, blue);
        }
    }
}
finally{
    image.dispose();
}
//ExEnd:ReadingPixelVaules 
}
}