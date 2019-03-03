/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.FontSettings;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageloadoptions.PsdLoadOptions;
import com.aspose.imaging.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class SetFontsFolder {
    
     public static void main(String args) throws Exception {
        //ExStart:SetFontsFolder 
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(SetFontsFolder.class) + "Photoshop/";
        String sourceFile = dataDir+"grinched-regular-font.psd";
        String output = dataDir+"grinched-regular-font.psd.png";
        //Folder that contains fonts that we want to use for rendering
        //(file GrinchedRegular.otf must be in this folder for proper work of example)
        // You can use FontSettings.addFontsFolder or you can use FontSettings.setFontsFolder to avoid system fonts
        FontSettings.addFontsFolder(dataDir+"Fonts\\");
        FontSettings.updateFonts();
        PsdImage image = (PsdImage) Image.load(sourceFile, new PsdLoadOptions());
        try {
         image.save(output, new PngOptions());
        } finally {
         image.close();
        }
        //ExEnd:SetFontsFolder
    }
     
     public static void SetFontsFolder(){
     //ExStart:SetFontsFolder 
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(SetFontsFolder.class) + "Photoshop/";
        String sourceFile = dataDir+"grinched-regular-font.psd";
        String output = dataDir+"grinched-regular-font.psd.png";
        //Folder that contains fonts that we want to use for rendering
        //(file GrinchedRegular.otf must be in this folder for proper work of example)
        // You can use FontSettings.addFontsFolder or you can use FontSettings.setFontsFolder to avoid system fonts
        FontSettings.addFontsFolder(dataDir+"Fonts\\");
        FontSettings.updateFonts();
        PsdImage image = (PsdImage) Image.load(sourceFile, new PsdLoadOptions());
        try {
         image.save(output, new PngOptions());
        } finally {
         image.close();
        }
        //ExEnd:SetFontsFolder
     }
}
