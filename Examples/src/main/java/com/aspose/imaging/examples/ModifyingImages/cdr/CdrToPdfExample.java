package com.aspose.imaging.examples.ModifyingImages.cdr;

import com.aspose.imaging.Image;
import com.aspose.imaging.VectorMultipageImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.ModifyingImages.PageOptionsBuilder;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.CdrRasterizationOptions;
import com.aspose.imaging.imageoptions.MultiPageOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CdrToPdfExample
{
    public static void main(String[] args)
    {
        Logger.startExample("CdrToPngExample");

        String inputFileName = Utils.getSharedDataDir() + "CDR/MultiPage2.cdr";
        String outFile = Utils.getOutDir("CDR") + "/MultiPage2.cdr.pdf";

        try (VectorMultipageImage image = (VectorMultipageImage) Image.load(inputFileName))
        {
            // Create page rasterization options
            VectorRasterizationOptions[] pageOptions = PageOptionsBuilder.createPageOptions(CdrRasterizationOptions.class, image);

            // Create PDF options
            PdfOptions options = new PdfOptions();
            MultiPageOptions multiPageOptions = new MultiPageOptions();
            multiPageOptions.setPageRasterizationOptions(pageOptions);
            options.setMultiPageOptions(multiPageOptions);

            // Export image to PDF format
            image.save(outFile, options);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }

}
