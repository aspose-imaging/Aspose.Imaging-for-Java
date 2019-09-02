
package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageloadoptions.PsdLoadOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportEffectsforPSD
{
    public static void main(String... args)
    {
        //ExStart:SupportEffectsforPSD
        String dataDir = Utils.getSharedDataDir() + "psd/";
        String output = "dropShadow.png";

        PsdLoadOptions psdLoadOptions = new PsdLoadOptions();
        psdLoadOptions.setLoadEffectsResource(true);
        psdLoadOptions.setUseDiskForLoadEffectsResource(true);
        PsdImage image = (PsdImage) Image.load(dataDir + "test.psd", psdLoadOptions);
        try
        {
            PngOptions pngOptions = new PngOptions();
            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);

            image.save(output, pngOptions);
        }
        finally
        {
            image.dispose();
        }

        //ExEnd:SupportEffectsforPSD
    }
}
