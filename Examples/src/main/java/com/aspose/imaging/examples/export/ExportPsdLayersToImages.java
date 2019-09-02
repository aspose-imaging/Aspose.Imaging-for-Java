package com.aspose.imaging.examples.export;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.imageoptions.PngOptions;

public class ExportPsdLayersToImages
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getSharedDataDir() + "export/";
        //ExStart:ExportPsdLayersToImages

        Image image = Image.load(dataDir + "sample.psd");
        try
        {
            PsdImage psdImage = (PsdImage) image;
            PngOptions pngOptions = new PngOptions();
            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);

            // for optimization purposes, call psdImage.getLayers() once
            Layer[] layers = psdImage.getLayers();
            for (int i = 0; i < layers.length; i++)
            {
                layers[i].save(dataDir + "ExportPsdLayersToImages_out" + i + ".png", pngOptions);
            }
        }
        finally
        {
            image.close();
        }

        //ExEnd:ExportPsdLayersToImages
    }
}
