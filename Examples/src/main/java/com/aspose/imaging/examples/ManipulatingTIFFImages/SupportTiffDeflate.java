/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.TiffOptions;
import junit.framework.Assert;
public class SupportTiffDeflate 
{
//ExStart:SupportTiffDeflate
 public static void main(String... args) throws Exception {

     
String dataDir = Utils.getSharedDataDir(SupportTiffDeflate.class) + "ManipulatingTIFFImages/";

String inputFile = "C:\\Temp\\Errors\\Alpha.png";
String outputFileTiff = "C:\\Temp\\Alpha.tiff";
String outputFilePng = "C:\\Temp\\Alpha1.png";
     
Image image = Image.load(inputFile);
try
{
TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffDeflateRgba);


image.save(outputFileTiff, options);
}
finally
{
image.dispose();
}
 
image = Image.load(outputFileTiff);
try
{
Assert.assertEquals(((RasterImage)image).hasAlpha(), true);
PngOptions options = new PngOptions();
options.setColorType(PngColorType.TruecolorWithAlpha);
image.save(outputFilePng, options);
}
finally
{
image.dispose();
}
//ExEnd:SupportTiffDeflate
}
}