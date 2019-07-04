/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.EMF;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import java.io.Console;

/**
 *
 * @author mfazi
 */
public class CropEMFFile {
    
    public static void main(String[] args)  {
         
         //ExStart:CropEMFFile
     
        String dataDir = Utils.getSharedDataDir(CropEMFFile.class) + "EMF/";
        
        EmfImage image = (EmfImage)Image.load(dataDir + "test.emf");
        
        image.crop(new Rectangle(10, 10, 100, 150));
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        image.save(dataDir + "test.emf_crop.emf");
        
        //ExEnd:CropEMFFile
        
    }
    
}
