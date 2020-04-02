package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;

public class LockImageLayers
{
    public static void main(String... args)
    {
        Logger.startExample("LockImageLayers");
        String dataDir = Utils.getSharedDataDir() + "Photoshop/";

        String sourceFile = dataDir + "layerLock.psd";
        String outputFile = Utils.getOutDir() + "result.psd";
        PsdImage image = (PsdImage) Image.load(sourceFile);
        try
        {

            Layer[] layers = image.getLayers();
            layers[4].setLayerLock(com.aspose.imaging.fileformats.psd.layers.layerresources.LayerLockType.LockAll);
            layers[2].setLayerLock(com.aspose.imaging.fileformats.psd.layers.layerresources.LayerLockType.None);
            layers[3].setLayerLock(com.aspose.imaging.fileformats.psd.layers.layerresources.LayerLockType.LockTransparentPixels);
            layers[1].setLayerLock(com.aspose.imaging.fileformats.psd.layers.layerresources.LayerLockType.LockImagePixels);
            layers[5].setLayerLock(com.aspose.imaging.fileformats.psd.layers.layerresources.LayerLockType.LockPosition);
            layers[5].setFlags(com.aspose.imaging.fileformats.psd.layers.LayerFlags.TransparencyProtected);
            image.save(outputFile);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }

}
