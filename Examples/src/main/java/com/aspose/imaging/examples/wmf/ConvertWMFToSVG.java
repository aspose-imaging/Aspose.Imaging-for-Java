/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

/**
 * @author mfazi
 */
public class ConvertWMFToSVG
{
    public static void main(String[] args)
    {
        Logger.startExample("ConvertWMFToSVG");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "svg/";

        String inputFileName = dataDir + "thistlegirl_wmfsample.wmf";
        String outputFileNameSvg = Utils.getOutDir() + "thistlegirl_wmfsample.svg";
        try (Image image = Image.load(inputFileName))
        {
            WmfRasterizationOptions rasterizationOptions = new WmfRasterizationOptions();
            rasterizationOptions.setBackgroundColor(Color.getWhiteSmoke());
            rasterizationOptions.setPageWidth(image.getWidth());
            rasterizationOptions.setPageHeight(image.getHeight());

            SvgOptions svgOptions = new SvgOptions();
            svgOptions.setVectorRasterizationOptions(rasterizationOptions);

            image.save(outputFileNameSvg, svgOptions);
        }
        Logger.endExample();
    }
}
