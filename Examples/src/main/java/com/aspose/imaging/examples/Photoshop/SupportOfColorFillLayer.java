/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.imaging.fileformats.psd.layers.fillsettings.IColorFillSettings;

/**
 * @author mfazi
 */
public class SupportOfColorFillLayer
{
    public static void main(String[] args)
    {
        //ExStart:SupportOfColorFillLayer

        String dataDir = Utils.getSharedDataDir() + "Photoshop/";
        String sourceFileName = dataDir + "ColorFillLayer.psd";
        String exportPath = dataDir + "ColorFillLayer_output.psd";

        PsdImage im = (PsdImage) Image.load(sourceFileName);

        try
        {
            for (Layer layer : im.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (FillLayer) layer;

                    if (fillLayer.getFillSettings().getFillType() != FillType.Color)
                    {
                        throw new RuntimeException("Wrong Fill Layer");
                    }

                    IColorFillSettings settings = (IColorFillSettings) fillLayer.getFillSettings();

                    settings.setColor(Color.getRed());
                    fillLayer.update();
                    im.save(exportPath);
                    break;
                }
            }
        }
        finally
        {
            im.close();
        }
        //ExEnd:SupportOfColorFillLayer

    }
}
