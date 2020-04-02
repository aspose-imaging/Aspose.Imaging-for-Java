package com.aspose.imaging.examples.export;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.imageoptions.PngOptions;

public class ExportPsdLayersToImages
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportPsdLayersToImages");
        String dataDir = Utils.getSharedDataDir() + "export/";

        try (Image image = Image.load(dataDir + "sample.psd"))
        {
            PsdImage psdImage = (PsdImage) image;
            PngOptions pngOptions = new PngOptions();
            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);

            // for optimization purposes, call psdImage.getLayers() once
            Layer[] layers = psdImage.getLayers();
            for (int i = 0; i < layers.length; i++)
            {
                layers[i].save(Utils.getOutDir() + "ExportPsdLayersToImages_out" + i + ".png", pngOptions);
            }
        }

        Logger.endExample();
    }
}
