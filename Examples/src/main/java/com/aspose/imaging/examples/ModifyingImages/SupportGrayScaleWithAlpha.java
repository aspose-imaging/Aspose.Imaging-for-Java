package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class SupportGrayScaleWithAlpha {
	public static void main(String... args) throws Exception {
		// ExStart:SupportGrayScaleWithAlpha
		// Create an instance of JpegImage and load an image as of JpegImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SupportGrayScaleWithAlpha.class) + "ModifyingImages/";

		String filePath = "ill_bado_gs723.psd";
                Image image = Image.load(filePath);
                try
                {
	          // Cast image object to PSD image
	          PsdImage psdImage = (PsdImage)image;

                 // Create an instance of PngOptions class
	          PngOptions pngOptions = new PngOptions();
	          pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
	          image.save("result.png", pngOptions);
                  }
                  
                finally
                 {
                
                  image.dispose();
                }
		  // ExEnd:SupportGrayScaleWithAlpha
	       
                } 

                }
