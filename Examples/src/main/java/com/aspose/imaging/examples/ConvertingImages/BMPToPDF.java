package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.imageoptions.PdfOptions;

public class BMPToPDF
{

    public static void main(String... args)
    {
        //ExStart:BMPToPDF 
        String dataDir = Utils.getSharedDataDir() + "export/";
        String outputFile = "result.pdf";
        BmpImage image = (BmpImage) Image.load(dataDir + "sample.bmp");
        try
        {
            PdfOptions exportOptions = new PdfOptions();
            exportOptions.setPdfDocumentInfo(new PdfDocumentInfo());

            image.save(outputFile, exportOptions);
        }
        finally
        {
            image.close();
        }

        //ExEnd:BMPToPDF
    }
}