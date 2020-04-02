package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class ConvertWMFMetaFileToSVG
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertWMFMetaFileToSVG");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of Image class by loading an existing .
        try (Image image = Image.load(dataDir + "input.wmf"))
        {
            // Create an instance of EmfRasterizationOptions class.
            final WmfRasterizationOptions options = new WmfRasterizationOptions();
            options.setPageWidth(image.getWidth());
            options.setPageHeight(image.getHeight());

            // Call save method to convert WMF to SVG format by passing output file name and SvgOptions class instance.
            image.save(Utils.getOutDir() + "ConvertWMFMetaFileToSVG_out.svg", new SvgOptions() {{ setVectorRasterizationOptions(options); }});
        }
        Logger.endExample();
    }
}
