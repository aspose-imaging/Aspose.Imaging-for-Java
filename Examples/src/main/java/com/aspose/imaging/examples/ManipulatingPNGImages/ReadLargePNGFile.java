/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.JpegOptions;

/**
 * @author mfazi
 */
public class ReadLargePNGFile
{
    public static void main(String[] args)
    {
        Logger.startExample("ReadLargePNGFile");

        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";

        // load image with size more or equals to 500Mb
        try (Image image = Image.load(dataDir + "halfGigImage.png"))
        {
            // Create an instance of JpegOptions
            JpegOptions options = new JpegOptions();

            image.save(Utils.getOutDir() + "halfGigImage.jpg", options);
        }

        Logger.endExample();
    }
}
