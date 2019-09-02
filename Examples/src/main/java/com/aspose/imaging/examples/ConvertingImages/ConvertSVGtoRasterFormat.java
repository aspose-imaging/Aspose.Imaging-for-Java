package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class ConvertSVGtoRasterFormat
{
    public static void main(String... args)
    {
        //ExStart:ConvertSVGtoRasterFormat

        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        // Load the image
        SvgImage image = (SvgImage) Image.load(dataDir + "aspose-logo.Svg");

        // Create an instance of PNG options
        PngOptions pngOptions = new PngOptions();

        // Save the results to disk
        image.save(dataDir + "ConvertingSVGToRasterImages_out.png", pngOptions);
    }
    //ExEnd:ConvertSVGtoRasterFormat
}
