package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BmpImage;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PdfOptions;
public class BMPToPDF {

    public static void main(String... args) throws Exception

    {   
        //ExStart:BMPToPDF 
        String dataDir = Utils.getSharedDataDir(BMPToPDF.class) + "ConvertingImages/";
        String outputFile = "result.pdf";
        BmpImage image = (BmpImage)Image.load(dataDir);
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