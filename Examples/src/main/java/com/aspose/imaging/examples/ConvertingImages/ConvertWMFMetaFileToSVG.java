package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ConvertWMFMetaFileToSVG
{
    public static void main(String... args)
    {
        //ExStart:ConvertWMFMetaFileToSVG
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of Image class by loading an existing .
        try (Image image = Image.load(dataDir + "input.wmf"))
        {
            // Create an instance of EmfRasterizationOptions class.
            final EmfRasterizationOptions options = new EmfRasterizationOptions();
            options.setPageWidth(image.getWidth());
            options.setPageHeight(image.getHeight());

            // Call save method to convert WMF to SVG format by passing output file name and SvgOptions class instance.
            image.save(dataDir + "ConvertWMFMetaFileToSVG_out.svg", new SvgOptions() {{ setVectorRasterizationOptions(options); }});
        }
        //ExEnd:ConvertWMFMetaFileToSVG
    }
}
