/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.wmf.WmfImage;

/**
 *
 * @author mfazi
 */
public class CropWMFFile {
    
    public static void main(String[] args)  {
         
         //ExStart:CropWMFFile
     
        String dataDir = Utils.getSharedDataDir(CropWMFFile.class) + "WMF/";
        
        WmfImage image = (WmfImage)Image.load(dataDir + "test.wmf");
        
        image.crop(new Rectangle(10, 10, 100, 150));
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        image.save(dataDir + "test.wmf_crop.wmf");
        //ExEnd:CropWMFFile
    }
    
}
