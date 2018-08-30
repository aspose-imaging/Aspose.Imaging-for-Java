
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngImage;


public class ChangeWindowSize {
     public static void main(String... args) throws Exception 
    {
        //ExStart:ChangeWindowSize
    String dataDir = Utils.getSharedDataDir(ChangeWindowSize.class) + "ModifyingImages/";
    String sourceFileName = "test.png";
    String outputFileName = "result.png";

    PngImage image = (PngImage)Image.load(dataDir+sourceFileName);
 try
    {
	image.binarizeBradley(10, 20);
	image.save(dataDir+outputFileName);
     }
 finally
     {
	image.dispose();
     }
  
 //ExEnd:ChangeWindowSize  
    }
}