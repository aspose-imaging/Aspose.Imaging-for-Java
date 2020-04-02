package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageloadoptions.PsdLoadOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class MissingFonts
{
    public static void main(String[] args)
    {
        Logger.startExample("MissingFonts");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "images/";
        String fileName = dataDir + "testReplacementNotAvailableFonts.psd";
        PsdImage image = (PsdImage) Image.load(fileName, new PsdLoadOptions()
                                {{
                                    setDefaultReplacementFont("Arial");
                                }});
        try
        {
            image.save(Utils.getOutDir() + "result.png", new PngOptions()
            {{
                setColorType(PngColorType.TruecolorWithAlpha);
            }});
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}




