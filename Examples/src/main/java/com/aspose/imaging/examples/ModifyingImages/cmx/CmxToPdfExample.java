package com.aspose.imaging.examples.ModifyingImages.cmx;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.TextRenderingHint;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CmxToPdfExample
{
    public static void main(String... args)
    {
        Logger.startExample("CmxToPdfExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "CMX/";
        String inputFileName = dataDir + "MultiPage.cmx";
        String outFile = Utils.getOutDir() + "MultiPage.pdf";

        try (Image image = Image.load(inputFileName))
        {
            PdfOptions options = new PdfOptions();
            options.setPdfDocumentInfo(new PdfDocumentInfo());

            // Set rasterization options for fileformat
            VectorRasterizationOptions defaultOptions = image.getDefaultOptions(new Object[]{Color.getWhite(), image.getWidth(), image.getHeight()})
                    .getVectorRasterizationOptions();
            options.setVectorRasterizationOptions(defaultOptions);
            defaultOptions.setTextRenderingHint(TextRenderingHint.SingleBitPerPixel);
            defaultOptions.setSmoothingMode(SmoothingMode.None);

            image.save(outFile, options);
        }

        Utils.deleteFile(outFile);

        Logger.endExample();
    }
}
