package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.WmfRasterizationOptions;

public class ConvertWMFToPDF
{
    public static void main(String... args)
    {
        Logger.startExample("ConvertWMFToPDF");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Load an existing WMF image
        try (Image image = Image.load(dataDir + "input.wmf"))
        {
            // Create an instance of WmfRasterizationOptions class and set different properties
            WmfRasterizationOptions wmfRasterizationOptions = new WmfRasterizationOptions();
            wmfRasterizationOptions.setBackgroundColor(Color.getWhiteSmoke());
            wmfRasterizationOptions.setPageWidth(image.getWidth());
            wmfRasterizationOptions.setPageHeight(image.getHeight());

            // Create an instance of PdfOptions class and provide rasterization option
            PdfOptions pdfOptions = new PdfOptions();
            pdfOptions.setVectorRasterizationOptions(wmfRasterizationOptions);

            // Call the save method, provide output path and PdfOptions to convert the WMF file to PDF and save the output
            image.save(Utils.getOutDir() + "ConvertWMFToPDF_out.pdf", pdfOptions);
        }
        Logger.endExample();
    }
}
