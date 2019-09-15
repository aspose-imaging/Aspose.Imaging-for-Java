/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

/**
 * @author mfazi
 */
public class ReadLargePNGFile
{
    public static void main(String[] args)
    {
        //ExStart:ReadLargePNGFile

        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";

        Image image = Image.load(dataDir + "halfGigImage.png"); // load image with size more or equals to 500Mb

        try
        {
            // Create an instance of JpegOptions
            JpegOptions options = new JpegOptions();

            image.save(dataDir + "halfGigImage.jpg", options);
        }
        finally
        {
            image.close();
        }

        //ExEnd:ReadLargePNGFile
    }
}
