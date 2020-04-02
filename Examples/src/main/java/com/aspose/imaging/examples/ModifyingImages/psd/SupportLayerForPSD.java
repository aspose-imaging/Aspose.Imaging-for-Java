package com.aspose.imaging.examples.ModifyingImages.psd;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Assert;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageloadoptions.PsdLoadOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportLayerForPSD
{
    public static void main(String[] args)
    {
        Logger.startExample("SupportLayerForPSD");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "psd/";

        String sourceFileName = dataDir + "dropShadow.psd";
        String output = Utils.getOutDir() + "dropShadow.png";

        try (
                PsdImage image =
                        (PsdImage)
                                Image.load(
                                        sourceFileName,
                                        new PsdLoadOptions()
                                        {{
                                            setLoadEffectsResource(true);
                                            setUseDiskForLoadEffectsResource(true);
                                        }}))
        {
            Assert.assertTrue(image.getLayers()[2] != null, "Layer with effects resource was not recognized");

            image.save(output, new PngOptions()
            {{
                setColorType(PngColorType.TruecolorWithAlpha);
            }});
        }

        Logger.endExample();
    }
}
