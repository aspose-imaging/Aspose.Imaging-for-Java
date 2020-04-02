package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

public class ConvertRasterFormatToSVG
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertRasterFormatToSVG");
		String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        String[] paths = new String[]
                {
                        "butterfly.gif",
                        "33715-cmyk.jpeg",
                        "3.JPG",
                        "test.j2k",
                        "Rings.png",
                        "3layers_maximized_comp.psd",
                        "img4.TIF",
                        "Lossy5.webp"
                };

        for (String path : paths)
        {
            String destPath = Utils.getOutDir() + path + ".svg";

            Image image = Image.load(dataDir + path);
            try
            {
                SvgOptions svgOptions = new SvgOptions();
                SvgRasterizationOptions svgRasterizationOptions = new SvgRasterizationOptions();
                svgRasterizationOptions.setPageWidth(image.getWidth());
                svgRasterizationOptions.setPageHeight(image.getHeight());
                svgOptions.setVectorRasterizationOptions(svgRasterizationOptions);

                image.save(destPath, svgOptions);
            }
            finally
            {
                image.dispose();
            }
        }
        Logger.endExample();
    }
}
