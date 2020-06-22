package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.imageoptions.PdfOptions;

public class WebPToPdfExample
{
    public static void main(String... args)
    {
        Logger.startExample("WebPToPdfExample");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "WebP/";
        String inputFile = dataDir + "Animation.webp";
        String outputFile = Utils.getOutDir() + "Animation.pdf";

        try (Image image = Image.load(inputFile))
        {
            PdfOptions options = new PdfOptions();
            options.setPdfDocumentInfo(new PdfDocumentInfo());

            image.save(outputFile, options);
        }

        Utils.deleteFile(outputFile);

        Logger.endExample();
    }
}
