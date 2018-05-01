/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.pdf.PdfDocumentInfo;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PdfOptions;
public class PNGToPDF 
{
 public static void main(String... args) throws Exception    
 {
     //ExStart:PNGToPDF 
 String dataDir = Utils.getSharedDataDir(PNGToPDF.class) + "ConvertingImages/";
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