package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
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
        //ExStart:RenderingOfRotatedTextLayerByTransformMatrix

        String dataDir = Utils.getSharedDataDir() + "Photoshop/";

        String sourceFileName = dataDir + "TransformedText.psd";
        String exportPath = dataDir + "TransformedTextExport.psd";
        String exportPathPng = dataDir + "TransformedTextExport.png";

        try (PsdImage im = (PsdImage) Image.load(sourceFileName))
        {
            im.save(exportPath);
            im.save(exportPathPng, new PngOptions()
                    {{
                        setColorType(PngColorType.TruecolorWithAlpha);
                    }});
        }

        //ExEnd:RenderingOfRotatedTextLayerByTransformMatrix
    }
}
