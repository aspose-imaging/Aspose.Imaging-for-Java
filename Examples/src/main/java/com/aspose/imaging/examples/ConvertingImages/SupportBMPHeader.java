/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportBMPHeader {
    

public static void main(String... args) throws Exception {

    //ExStart:SupportBMPHeader 
       String dataDir = Utils.getSharedDataDir(SupportBMPHeader.class) + "ConvertingImages/";
       Image image = Image.load(dataDir+"test.bmp");
    try
     {
	image.save("test.bmp.png", new PngOptions());
      }
    finally
     {
	image.dispose();
     }
    //ExEnd:SupportBMPHeader 
}
}