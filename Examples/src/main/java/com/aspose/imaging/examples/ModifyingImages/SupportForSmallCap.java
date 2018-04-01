/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;


public class SupportForSmallCap {
    
      public static void main(String... args) throws Exception {
		
		// Create an instance of JpegImage and load an image as of JpegImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SupportForSmallCap.class) + "ModifyingImages/";
//ExStart:SupportForSmallCap
		Image image = Image.load(dataDir + "aspose-logo.jpg");

		image.resize(300, 300);
		image.save(dataDir + "SimpleResizing_out.jpg");
		//ExEnd:SupportForSmallCap
	}

}

