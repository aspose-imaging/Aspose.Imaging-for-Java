/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.SVG;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

/**
 *
 * @author mfazi
 */
public class SVGToBMPConversion {
    
     public static void main(String[] args)  {
         
         //ExStart:SVGToBMPConversion
     
        String dataDir = Utils.getSharedDataDir(SVGToBMPConversion.class) + "SVG/";
      
        
        Image image = Image.load(dataDir + "test.svg");
        
         BmpOptions options = new BmpOptions();
                SvgRasterizationOptions svgOptions = new SvgRasterizationOptions();

                svgOptions.setPageWidth(100);
                svgOptions.setPageHeight(200);


                options.setVectorRasterizationOptions(svgOptions);

                image.save(dataDir + "test.svg_out.bmp", options);
        //ExEnd:SVGToBMPConversion
        
     }    
}
