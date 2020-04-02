package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
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
        Logger.startExample("ColorReplacement");

        String dataDir = Utils.getSharedDataDir() + "psd/";

        String tmpFileName = "photooverlay_5_new";
        String fileName = dataDir + tmpFileName;
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
                    input.save(Utils.getOutDir() + tmpFileName + "_nonTransparentColors_result.png", pngOptions);
                    input.save(Utils.getOutDir() + tmpFileName + "_nonTransparentColors_result.psd");
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

                    input.save(Utils.getOutDir() + tmpFileName + "_specificColor_result.png", pngOptions);
                    input.save(Utils.getOutDir() + tmpFileName + "_specificColor_result.psd");
                    break;
                }
            }
        }
        finally
        {
            input.dispose();

        }
        Logger.endExample();
    }
}

	
        