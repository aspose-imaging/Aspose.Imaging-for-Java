package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.psd.layers.Layer;
import com.aspose.imaging.imageoptions.PngOptions;

import static com.aspose.imaging.KnownColor.LightGreen;
import static com.aspose.imaging.KnownColor.Orange;


public class ColorReplacement
{
    public static void main(String... args)
    {
        //ExStart:ColorReplacement

        String dataDir = Utils.getSharedDataDir() + "psd/";

        String fileName = dataDir + "photooverlay_5_new";
        PngOptions pngOptions = new PngOptions()
        {{
            setColorType(PngColorType.TruecolorWithAlpha);
        }};
        PsdImage input = (PsdImage) Image.load(fileName + ".psd");
        try
        {
            for (Layer layer : input.getLayers())
            {
                if (layer.getName().equals("Maincolor"))
                {
                    layer.replaceNonTransparentColors(Orange);
                    //      replaceNonTransparentColors(Color.getOrange());
                    input.save(fileName + "_nonTransparentColors_result.png", pngOptions);
                    input.save(fileName + "_nonTransparentColors_result.psd");
                    break;
                }
            }
        }
        finally
        {
            input.dispose();
        }

        input = (PsdImage) Image.load(fileName + ".psd");
        try
        {
            for (Layer layer : input.getLayers())
            {
                if (layer.getName().equals("Maincolor"))
                {
                    layer.replaceColor(LightGreen, (byte) 40, Orange);

                    input.save(fileName + "_specificColor_result.png", pngOptions);
                    input.save(fileName + "_specificColor_result.psd");
                    break;
                }
            }
        }
        finally
        {
            input.dispose();

        }
        //ExEnd:ColorReplacement
    }
}

	
        