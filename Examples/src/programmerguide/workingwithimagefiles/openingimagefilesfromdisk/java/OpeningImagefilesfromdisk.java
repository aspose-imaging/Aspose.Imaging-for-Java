/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmerguide.workingwithimagefiles.openingimagefilesfromdisk.java;

import com.aspose.imaging.*;

public class OpeningImagefilesfromdisk
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmerguide/workingwithimagefiles/openingimagefilesfromdisk/data/";
        
        //Create an Image object and load an existing file using the file path
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp");
        
        //Print message
        System.out.println("Image is loaded successfully.");
    }
}