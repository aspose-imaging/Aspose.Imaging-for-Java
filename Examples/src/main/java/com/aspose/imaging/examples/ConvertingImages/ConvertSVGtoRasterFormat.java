package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.;

public class ConvertSVGtoRasterFormat {
	public static void main(String... args) throws Exception {
	String dataDir = Utils.getDataDir(ConvertGIFImageLayersToTIFF.class);
	
	// Load the image
	SvgImage image = (SvgImage)Image.load(dataDir + "aspose_logo.Svg");
	
		// Create an instance of PNG options
		PngOptions pngOptions = new PngOptions();

		// Save the results to disk
		image.save(dataDir + "ConvertingSVGToRasterImages_out.png", pngOptions);
	}
}
