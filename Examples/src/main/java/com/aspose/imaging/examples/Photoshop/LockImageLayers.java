package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;

public class LockImageLayers {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(LockImageLayers.class) + "Photoshop/";
		//ExStart:LockImageLayers
               
                String sourceFile = dataDir + "layerLock.psd";
                String outputFile = dataDir + "result.psd";
                PsdImage image = (PsdImage)Image.load(sourceFile);
                try
                {
                    Layer[] layers = image.getLayers();
                    layers[4].setLayerLock(LayerLockType.LockAll);
                    layers[2].setLayerLock(LayerLockType.None);
                    layers[3].setLayerLock(LayerLockType.LockTransparentPixels);
                    layers[1].setLayerLock(LayerLockType.LockImagePixels);
                    layers[5].setLayerLock(LayerLockType.LockPosition);
                    layers[5].setFlags(LayerFlags.TransparencyProtected);
                    image.save(outputFile);
                }
                finally
                {
                    image.dispose();
                }
                //ExEnd:LockImageLayers
        }
       
}
