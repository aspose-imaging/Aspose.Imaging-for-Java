/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.imaging.examples.files;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;

public class OpeningImagefilesfromdisk
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(OpeningImagefilesfromdisk.class);
        
        //Create an Image object and load an existing file using the file path
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp");
        
        //Print message
        System.out.println("Image is loaded successfully.");
    }
}