package com.aspose.imaging.examples.SVG;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

/**
 * @author mfazi
 */
public class SVGToBMPConversion
{

    public static void main(String[] args)
    {

        Logger.startExample("SVGToBMPConversion");

        String dataDir = Utils.getSharedDataDir() + "SVG/";

        try (Image image = Image.load(dataDir + "test.svg"))
        {
            BmpOptions options = new BmpOptions();
            SvgRasterizationOptions svgOptions = new SvgRasterizationOptions();

            svgOptions.setPageWidth(100);
            svgOptions.setPageHeight(200);

            options.setVectorRasterizationOptions(svgOptions);

            image.save(Utils.getOutDir() + "test.svg_out.bmp", options);
        }
        Logger.endExample();
    }
}
