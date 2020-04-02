package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.WebPOptions;

public class ConvertingWMFtoWebp
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertingWMFtoWebp");
		String dataDir = Utils.getSharedDataDir() + "wmf/";
        String inputFileName = dataDir + "sample.wmf";
        String outFileName = Utils.getOutDir() + "ConvertingWMFtoWebp_out.webp";

        // Load an existing WMF image
        Image image = Image.load(inputFileName);
        try
        {
            // Calculate new height
            double k = (image.getWidth() * 1.00) / image.getHeight();

            // Create an instance of EmfRasterizationOptions class and define
            // settings
            EmfRasterizationOptions emf = new EmfRasterizationOptions();
            emf.setPageWidth(400);
            emf.setPageHeight((int) Math.round(400 / k));
            emf.setBorderX(5);
            emf.setBorderY(10);
            emf.setBackgroundColor(Color.getWhiteSmoke());

            // Create an instance of WebPOptions class and provide rasterization
            // option
            ImageOptionsBase options = new WebPOptions();
            options.setVectorRasterizationOptions(emf);

            // Call the save method, provide output path and WebPOptions to
            // convert the WMF file to Webp and save the output
            image.save(outFileName, options);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}
