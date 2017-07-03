package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;

public class FontReplacing {
	public static void main(String... args) throws Exception {
		// ExStart:FontReplacing
		// Create an instance of JpegImage and load an image as of JpegImage
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(FontReplacing.class) + "ModifyingImages/";

		String fileName = "testReplacementNotAvailableFonts.psd";

                PsdImage image = (PsdImage)Image.load(fileName, new PsdLoadOptions(){{ setDefaultReplacementFont ("Arial"); }});
         try
            {
	        image.save("result.png", new PngOptions() {{ setColorType(PngColorType.TruecolorWithAlpha); }});
            }
         finally
            {
	        image.dispose();
            }
 		// ExEnd:FontReplacing
	}

}
