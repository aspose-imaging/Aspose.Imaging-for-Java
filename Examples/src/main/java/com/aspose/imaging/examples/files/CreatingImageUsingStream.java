package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Utils;

public class CreatingImageUsingStream
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir(CreatingImageUsingStream.class) + "files/";

        //Creates an instance of BmpOptions and set its various properties
        com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions();

        createOptions.setBitsPerPixel(24);

        //Create an instance of FileCreateSource and assign it as Source for the instance of BmpOptions
        //If second parameter is not passed, then by default the file has IsTemporal set to True
        createOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(dataDir + "sample.bmp"));

        //Creates an instance of Image
        com.aspose.imaging.Image image = com.aspose.imaging.Image.create(createOptions,500,500);

        image.save();

        // Display Status.
        System.out.println("Image created successfully!");
        
    }
}




