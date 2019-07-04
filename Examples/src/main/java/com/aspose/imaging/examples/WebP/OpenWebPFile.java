/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.WebP;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.webp.WebPImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author mfazi
 */
public class OpenWebPFile {
    
    public static void main(String[] args) throws FileNotFoundException, IOException  {
         
         //ExStart:OpenWebPFile
     
        String dataDir = Utils.getSharedDataDir(OpenWebPFile.class) + "WebP/";
        
        String inputFile = dataDir + "Animation1.webp";
        String outputFile = dataDir + "Animation2.webp";
        ByteArrayOutputStream ms = new ByteArrayOutputStream();
        try
        {
            WebPImage image = (WebPImage)Image.load(inputFile);
            try
            {
                image.resize(300, 450, ResizeType.HighQualityResample);
                image.crop(new Rectangle(10, 10, 200, 300));
                image.rotateFlipAll(RotateFlipType.Rotate90FlipX);
                image.save(ms);
            }
            finally
            {
                image.close();
            }

            FileOutputStream fs = new FileOutputStream(outputFile);
            try
            {
                fs.write(ms.toByteArray());
            }
            finally
            {
                fs.close();
            }
        }
        finally
        {
            ms.close();
        }
        //ExEnd:OpenWebPFile
    }
}
