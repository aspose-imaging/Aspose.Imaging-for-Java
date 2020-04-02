package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class ResizeWMFFile
{
    public static void main(String... args)
    {
        Logger.startExample("ResizeWMFFile");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing WMF image
        try (Image image = Image.load(dataDir + "input.wmf"))
        {
            // Call the resize method of Image class and width,height values and Calculate new PNG image height
            image.resize(100, 100);
            final double k = (image.getWidth() * 1.00) / image.getHeight();

            // Create an instance of WmfRasterizationOptions class and set different properties
            WmfRasterizationOptions wmfRasterization = new WmfRasterizationOptions()
            {{
                setBackgroundColor(Color.getWhiteSmoke());
                setPageWidth(100);
                setPageHeight((int)Math.round(100 / k));
                setBorderX(5);
                setBorderY(10);
            }};

            // Create an instance of PngOptions class and provide rasterization option
            ImageOptionsBase imageOptions = new PngOptions();
            imageOptions.setVectorRasterizationOptions(wmfRasterization);

            // Call the save method, provide output path and PngOptions to convert the WMF file to PNG and save the output
            image.save(Utils.getOutDir() + "CreateEMFMetaFileImage_out.png", imageOptions);
            Logger.endExample();
        }
    }
}
