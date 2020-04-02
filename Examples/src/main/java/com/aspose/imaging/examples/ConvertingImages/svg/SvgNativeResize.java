package com.aspose.imaging.examples.ConvertingImages.svg;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

public class SvgNativeResize
{
    public static void main(String[] args)
    {
        Logger.startExample("SvgNativeResize");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String outDir = Utils.getOutDir();

        // Load the image
        try (SvgImage image = (SvgImage) Image.load(dataDir + "aspose_logo.svg"))
        {
            image.resize(image.getWidth() * 10, image.getHeight() * 15);
            image.save(outDir + "Logotype_10_15_out.png", new PngOptions()
            {{
                setVectorRasterizationOptions(new SvgRasterizationOptions());
            }});
        }
        Logger.endExample();
    }
}
