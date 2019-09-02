package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.WebPOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class ConvertWMFToWebp
{
    public static void main(String... args)
    {
        //ExStart:ConvertWMFToWebp
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        // Load an existing WMF image
        try (Image image = Image.load(dataDir + "input.wmf"))
        {
            final double k = (image.getWidth() * 1.00) / image.getHeight();

            // Create an instance of WmfRasterizationOptions class and set different properties
            WmfRasterizationOptions wmfRasterization = new WmfRasterizationOptions()
            {{
                setBackgroundColor(Color.getWhiteSmoke());
                setPageWidth(400);
                setPageHeight((int) Math.round(400 / k));
                setBorderX(5);
                setBorderY(10);
            }};

            // Create an instance of WebPOptions class and provide rasterization option
            ImageOptionsBase imageOptions = new WebPOptions();
            imageOptions.setVectorRasterizationOptions(wmfRasterization);

            // Call the save method, provide output path and WebPOptions to convert the WMF file to Webp and save the output
            image.save(dataDir + "ConvertWMFToWebp_out.webp", imageOptions);
            //ExStart:ConvertWMFToWebp
        }
    }
}
