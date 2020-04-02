package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PdfOptions;

public class PSDtoPDF
{
    public static void main(String... args)
    {
        Logger.startExample("PSDtoPDF");
        String dataDir = Utils.getSharedDataDir() + "psd/";
        Image image = Image.load(dataDir + "samplePsd.psd");
        try
        {
            PsdImage psdImage = (PsdImage) image;
            PdfOptions exportOptions = new PdfOptions();
            exportOptions.setPdfDocumentInfo(new com.aspose.imaging.fileformats.pdf.PdfDocumentInfo());

            psdImage.save(Utils.getOutDir() + "result.pdf", exportOptions);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}
