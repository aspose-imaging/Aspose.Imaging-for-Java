/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ConvertImageWithGrayscale {
    
public static void main(String... args) throws Exception {

 String dataDir = Utils.getSharedDataDir(ConvertImageWithGrayscale.class) + "ModifyingImages/"; 
    //ExStart:ConvertImageWithGrayscale
 String srcDir = "IMAGINGNET-2160\\";
 String outputFolder = "C:\\temp\\";
 
      int[] colorTypes = new int[]
 {
  JpegCompressionColorMode.Grayscale,
  JpegCompressionColorMode.YCbCr,
  JpegCompressionColorMode.Rgb,
  JpegCompressionColorMode.Cmyk,
  JpegCompressionColorMode.Ycck,
    };
 
String[] sourceFileNames = new String[]
{
"Rgb.jpg",
"Rgb.jpg",
"Rgb.jpg",
"Rgb.jpg",
"Rgb.jpg",
};
 
JpegOptions options = new JpegOptions();
options.setBitsPerChannel((byte)12);
 
for (int i = 0; i < colorTypes.length; ++i)
{
options.setColorType(colorTypes[i]);
 
String fileName = JpegCompressionColorMode.getName(JpegCompressionColorMode.class, colorTypes[i]) + " 12-bit.jpg";
String referencePath = srcDir + fileName;
String outputPath = outputFolder + fileName;
 
Image image = Image.load(srcDir + sourceFileNames[i]);
try
{
image.save(outputPath, options);
}
finally
{
image.dispose();
}
}

    //ExEnd:ConvertImageWithGrayscale
}
}