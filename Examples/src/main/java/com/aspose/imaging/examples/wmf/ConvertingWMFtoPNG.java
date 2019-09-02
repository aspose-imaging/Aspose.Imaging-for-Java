/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

/**
 * @author mfazi
 */
public class ConvertingWMFtoPNG
{

    public static void main(String[] args)
    {

        //ExStart:ConvertingWMFtoPNG
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "wmf/";

        String inputFileName = dataDir + "thistlegirl_wmfsample.wmf";
        String outputFileNamePng = dataDir + "thistlegirl_wmfsample.png";
        Image image = Image.load(inputFileName);
        try
        {
            WmfRasterizationOptions rasterizationOptions = new WmfRasterizationOptions();
            rasterizationOptions.setBackgroundColor(Color.getWhiteSmoke());
            rasterizationOptions.setPageWidth(image.getWidth());
            rasterizationOptions.setPageHeight(image.getHeight());

            PngOptions pngOptions = new PngOptions();
            pngOptions.setVectorRasterizationOptions(rasterizationOptions);

            image.save(outputFileNamePng, pngOptions);

        }
        finally
        {
            image.close();
        }
        //ExEnd:ConvertingWMFtoPNG
    }

}
