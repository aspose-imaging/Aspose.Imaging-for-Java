package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Utils;

public class OpeningImagefilesfromdisk
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(CreatingImageUsingStream.class) + "files/";
        //ExStart:OpeningImagefilesfromdisk
        //Create an Image object and load an existing file using the file path
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.bmp");
        
        //Print message
        System.out.println("Image is loaded successfully.");
    

    //ExEnd:OpeningImagefilesfromdisk
    }
}
