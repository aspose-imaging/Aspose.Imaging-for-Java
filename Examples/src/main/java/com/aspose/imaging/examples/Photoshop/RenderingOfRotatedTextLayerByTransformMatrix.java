package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PngOptions;

/**
 * @author mfazi
 */
public class RenderingOfRotatedTextLayerByTransformMatrix
{
    public static void main(String[] args)
    {
        Logger.startExample("RenderingOfRotatedTextLayerByTransformMatrix");

        String dataDir = Utils.getSharedDataDir() + "Photoshop/";

        String sourceFileName = dataDir + "TransformedText.psd";
        String exportPath = Utils.getOutDir() + "TransformedTextExport.psd";
        String exportPathPng = Utils.getOutDir() + "TransformedTextExport.png";

        try (PsdImage im = (PsdImage) Image.load(sourceFileName))
        {
            im.save(exportPath);
            im.save(exportPathPng, new PngOptions()
                    {{
                        setColorType(PngColorType.TruecolorWithAlpha);
                    }});
        }

        Logger.endExample();
    }
}
