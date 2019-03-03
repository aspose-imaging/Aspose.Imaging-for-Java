/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.CMX;

import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.PositioningTypes;

/**
 *
 * @author mfazi
 */
public class CMXToPNGConversion {
    public static void main(String[] args) throws Exception {
        //ExStart:CMXToPNGConversion 
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(CMXToPNGConversion.class) + "CMX/";
        
        
        // Example of exporting the entire document page
        String[] fileNames = new String[] {
         "Rectangle.cmx",
         "Rectangle+Fill.cmx",
         "Ellipse.cmx",
         "Ellipse+fill.cmx",
         "brushes.cmx",
         "outlines.cmx",
         "order.cmx",
         "many_images.cmx",
        };
        for (String fileName: fileNames) {
         Image image = Image.load(dataDir + fileName);
         try {
          CmxRasterizationOptions cmxRasterizationOptions = new CmxRasterizationOptions();
          cmxRasterizationOptions.setPositioning(PositioningTypes.DefinedByDocument);
          cmxRasterizationOptions.setSmoothingMode(SmoothingMode.AntiAlias);
          PngOptions options = new PngOptions();
          options.setVectorRasterizationOptions(cmxRasterizationOptions);
          image.save(dataDir + fileName + ".docpage.png", options);
         } finally {
          image.close();
         }
        }
        //ExEnd:CMXToPNGConversion
    }
    
    public static void CMXToPNGConversion(){
    
        //ExStart:CMXToPNGConversion 
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(CMXToPNGConversion.class) + "CMX/";
        
        
        // Example of exporting the entire document page
        String[] fileNames = new String[] {
         "Rectangle.cmx",
         "Rectangle+Fill.cmx",
         "Ellipse.cmx",
         "Ellipse+fill.cmx",
         "brushes.cmx",
         "outlines.cmx",
         "order.cmx",
         "many_images.cmx",
        };
        for (String fileName: fileNames) {
         Image image = Image.load(dataDir + fileName);
         try {
          CmxRasterizationOptions cmxRasterizationOptions = new CmxRasterizationOptions();
          cmxRasterizationOptions.setPositioning(PositioningTypes.DefinedByDocument);
          cmxRasterizationOptions.setSmoothingMode(SmoothingMode.AntiAlias);
          PngOptions options = new PngOptions();
          options.setVectorRasterizationOptions(cmxRasterizationOptions);
          image.save(dataDir + fileName + ".docpage.png", options);
         } finally {
          image.close();
         }
        }
        //ExEnd:CMXToPNGConversion
    }
}
