/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForSubscript {
    //ExStart:SupportForSubscript
    public static void main(String... args) throws Exception {
     
   Image image = Image.load("test.bmp");
   try
  {
   image.save("test.bmp.png", new PngOptions());
  }
   finally
  {
   image.dispose();
}
  //ExEnd:SupportForSubscript    

    }
}