package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;


public class RasterImageToPDF {
    
 public static void main(String... args) throws Exception{
   
     //ExStart:RasterImageToPDF
    String dataDir = Utils.getSharedDataDir(RasterImageToPDF.class) + "ConvertingImages/";
    String destFilePath = "transparent_orig.gif.pdf";
    Image image = Image.load(dataDir);
    try
    {
        image.save(destFilePath, new PdfOptions());
    }
    finally
    {
        image.dispose();
    }
    //ExEnd:RasterImageToPDF
  }
}