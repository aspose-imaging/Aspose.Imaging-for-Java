package com.aspose.imaging.examples.djvu;

import com.aspose.imaging.Image;
import com.aspose.imaging.IntRange;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.djvu.DjvuImage;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.imageoptions.DjvuMultiPageOptions;
import com.aspose.imaging.imageoptions.PdfOptions;

public class ConvertDjVuToPDF
{
    public static void main(String[] args)
    {
        Logger.startExample("ConvertDjVuToPDF");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "djvu/";

        //Load a DjVu image
        try (DjvuImage image = (DjvuImage) Image.load(dataDir + "Sample.djvu"))
        {
            //Create an instance of PdfOptions
            PdfOptions exportOptions = new PdfOptions();

            //Initialize the metadata for Pdf document
            exportOptions.setPdfDocumentInfo(new PdfDocumentInfo());

            //Create an instance of IntRange and initialize it with the range of DjVu pages to be exported
            IntRange range = new IntRange(0, 3); //Export first 3 pages

            //Initialize an instance of DjvuMultiPageOptions with range of DjVu pages to be exported
            exportOptions.setMultiPageOptions(new DjvuMultiPageOptions(range));

            //Save the result in PDF format
            image.save(Utils.getOutDir() + "ConvertDjVuToPDF_out.pdf", exportOptions);

            // Display Status.
            Logger.println("File converted");
        }

        Logger.endExample();
    }
}

