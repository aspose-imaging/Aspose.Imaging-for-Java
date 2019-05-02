/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.CDR;

import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

/**
 *
 * @author mfazi
 */
public class SupportOfCDR {
    
    //ExStart:SupportOfCDR
    // The path to the documents directory.
	String baseFolder = Utils.getSharedDataDir(SupportOfCDR.class) + "CDR/";
               
        String inputFileName = baseFolder + "test.cdr";
        long expectedFileFormat = FileFormat.Cdr;
        long realFileFormat = Image.getFileFormat(inputFileName);
       // Assert.assertEquals(expectedFileFormat, realFileFormat, "File format is incorrect!");
    //ExEnd:SupportOfCDR
}
