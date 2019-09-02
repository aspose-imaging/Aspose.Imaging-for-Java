/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Assert;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.fileformats.psd.layers.LayerResource;
import com.aspose.imaging.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.imaging.fileformats.psd.layers.layerresources.SoCoResource;

/**
 * @author mfazi
 */
public class SupportOfSoCoResource
{
    public static void main(String[] args)
    {
        //ExStart:SupportOfSoCoResource

        String dataDir = Utils.getSharedDataDir() + "Photoshop/";

        // Support of SoCoResource
        String sourceFileName = dataDir + "ColorFillLayer.psd";
        String exportPath = dataDir + "SoCoResource_Edited.psd";

        PsdImage im = (PsdImage) Image.load(sourceFileName);

        try
        {
            for (Layer layer : im.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (FillLayer) layer;
                    for (LayerResource resource : fillLayer.getResources())
                    {
                        if (resource instanceof SoCoResource)
                        {
                            SoCoResource socoResource = (SoCoResource) resource;
                            Assert.areEqual(Color.fromArgb(63, 83, 141), socoResource.getColor());
                            socoResource.setColor(Color.getRed());
                            break;
                        }
                    }
                    break;
                }
                im.save(exportPath);
            }
        }
        finally
        {
            im.close();
        }
        //ExEnd:SupportOfSoCoResource
    }
}
