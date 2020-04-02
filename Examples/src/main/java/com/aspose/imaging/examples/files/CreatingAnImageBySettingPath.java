package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class CreatingAnImageBySettingPath
{
    public static void main(String[] args)
    {
        Logger.startExample("CreatingAnImageBySettingPath");

        //Creates an instance of BmpOptions and set its various properties
        // to be sure that file is released
        try (com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions())
        {
            createOptions.setBitsPerPixel(24);

            //Create an instance of FileCreateSource and assign it as Source for the instance of BmpOptions
            //If second parameter is not passed, then by default the file has IsTemporal set to True
            createOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(Utils.getOutDir() + "sample.bmp"));

            //Creates an instance of Image
            try (com.aspose.imaging.Image image = com.aspose.imaging.Image.create(createOptions, 500, 500))
            {
                image.save();

                // Display Status.
                Logger.println("Image created successfully!");
            }
        }
        Logger.endExample();
    }
}




