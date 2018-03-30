/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;


public class RGBColorSystem {
    
    //ExStart:RGBColorSystem
  
       String dataDir = Utils.getSharedDataDir(RGBColorSystem.class) + "ConvertingImages/";
     
    String sourceFilePath = "testTileDeflate.tif";
    String outputFilePath = "testTileDeflate Cmyk.tif";
 
    TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffLzwCmyk);
 
 
    Image image = Image.load(sourceFilePath);
  
{
    image.save(outputFilePath, options);
}
  
   {
    image.dispose();
}
    //ExEnd:RGBColorSystem
}
