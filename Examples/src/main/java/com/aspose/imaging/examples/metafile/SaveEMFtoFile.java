/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.ConvertingImages.ConvertRasterFormatToSVG;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEMFtoFile {
     	public static void main(String... args) throws Exception {
	String dataDir = Utils.getSharedDataDir(ConvertRasterFormatToSVG.class) + "metafile/";
          //ExStart:SaveEMFtoFile

        String path = dataDir+"TestEmfBezier.emf";
        EmfImage image = (EmfImage)Image.load(path);
        try
        {
            image.save(path + ".emf", new EmfOptions());
        }
        finally
        {
            image.dispose();
        } 
//ExEnd:SaveEMFtoFile
}
}
