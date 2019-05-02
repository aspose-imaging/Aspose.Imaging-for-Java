/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.TextRenderingHint;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.cdr.CdrImage;
import com.aspose.imaging.fileformats.cmx.CmxImage;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.opendocument.OdgImage;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.fileformats.wmf.WmfImage;
import com.aspose.imaging.imageoptions.CdrRasterizationOptions;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.OdgRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

/**
 *
 * @author mfazi
 */
public class SupportOfSmoothingMode {
    
    public static void main(String[] args) throws Exception {
    
        //ExStart:SupportOfSmoothingMode
        // The path to the documents directory.
	String basePath = Utils.getSharedDataDir(ManualImageMasking.class) + "ModifyingImages/";
        
        String[] files = new String[] {
            "SmoothingTest.cdr",
            "SmoothingTest.cmx",
            "SmoothingTest.emf",
            "SmoothingTest.wmf",
            "SmoothingTest.odg",
            "SmoothingTest.svg"
           };
           int[] smoothingModes = new int[] {
            SmoothingMode.AntiAlias, SmoothingMode.None
           };
           for (String fileName: files) {
            Image image = Image.load(basePath + fileName);
            try {
             VectorRasterizationOptions vectorRasterizationOptions;
             if (image instanceof CdrImage) {
              vectorRasterizationOptions = new CdrRasterizationOptions();
             } else if (image instanceof CmxImage) {
              vectorRasterizationOptions = new CmxRasterizationOptions();
             } else if (image instanceof EmfImage) {
              vectorRasterizationOptions = new EmfRasterizationOptions();
             } else if (image instanceof WmfImage) {
              vectorRasterizationOptions = new WmfRasterizationOptions();
             } else if (image instanceof OdgImage) {
              vectorRasterizationOptions = new OdgRasterizationOptions();
             } else if (image instanceof SvgImage) {
              vectorRasterizationOptions = new SvgRasterizationOptions();
             } else {
              throw new RuntimeException("This is image is not supported in this example");
             }
             vectorRasterizationOptions.setPageSize(Size.to_SizeF(image.getSize()));
             for (int smoothingMode: smoothingModes) {
              String outputFileName = basePath + String.format("image_%s%s.png", TextRenderingHint.toString(SmoothingMode.class, smoothingMode), fileName.substring(fileName.lastIndexOf('.')));
              vectorRasterizationOptions.setSmoothingMode(smoothingMode);
              PngOptions pngOptions = new PngOptions();
              pngOptions.setVectorRasterizationOptions(vectorRasterizationOptions);
              image.save(outputFileName, pngOptions);
             }
            } finally {
             image.close();
            }
           }
           //ExEnd:SupportOfSmoothingMode
    }
    
}
