package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.imageoptions.PdfOptions;

public class PNGToPDF
{
    public static void main(String... args)
    {
        //ExStart:PNGToPDF
        String dataDir = Utils.getSharedDataDir() + "ManipulatingPNGImages/";
        PngImage pngImage = (PngImage) Image.load(dataDir + "aspose_logo.png");
        try
        {
            PdfOptions exportOptions = new PdfOptions();
            exportOptions.setPdfDocumentInfo(new PdfDocumentInfo());

            pngImage.save("multipage_specificColor_.djvu4_ethalon.pdf", exportOptions);
        }
        finally
        {
            pngImage.close();
        }
        //ExEnd:PNGToPDF
    }
}