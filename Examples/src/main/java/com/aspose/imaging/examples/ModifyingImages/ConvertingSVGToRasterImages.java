package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertingSVGToRasterImages
{
    public static void main(String[] args)
    {
        Logger.startExample("ConvertingSVGToRasterImages");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";;

        // Load the image
        try (SvgImage image = (SvgImage) Image.load(dataDir + "aspose_logo.Svg"))
        {
            // Create an instance of PNG options and Save the results to disk
            PngOptions pngOptions = new PngOptions();
            image.save(Utils.getOutDir() + "ConvertingSVGToRasterImages_out.png", pngOptions);
        }
        Logger.endExample();
    }
}
