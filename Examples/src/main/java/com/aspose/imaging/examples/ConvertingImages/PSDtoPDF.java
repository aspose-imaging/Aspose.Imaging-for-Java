/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PdfOptions;
public class PSDtoPDF 
{
	public static void main(String... args) throws Exception {
        String dataDir = Utils.getSharedDataDir(PSDtoPDF.class) + "ConvertingImages/";
            //ExStart:PSDtoPDF
        Image image = Image.load(dataDir);
    try
      {
         PsdImage psdImage = (PsdImage)image;
         PdfOptions exportOptions = new PdfOptions();
         exportOptions.setPdfDocumentInfo(new com.aspose.imaging.fileformats.pdf.PdfDocumentInfo());
 
         psdImage.save(dataDir+"result.pdf", exportOptions);
         }
finally
       {
       image.dispose();
        }	    
       //ExEnd:PSDtoPDF
        }
}
