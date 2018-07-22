/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

public class ConvOfOtherFormatsToSVG {
    	public static void main(String... args) throws Exception {
	String dataDir = Utils.getSharedDataDir(ConvertRasterFormatToSVG.class) + "ConvertingImages/";
        
    //ExStart:ConvOfOtherFormatsToSVG
  
        Image image = Image.load(dataDir+"mysvg.svg");
        try
        {
            image.save(dataDir+"yoursvg.svg");
        }
        finally
        {
            image.dispose();
        }
//ExEnd:ConvOfOtherFormatsToSVG
}
}
//


