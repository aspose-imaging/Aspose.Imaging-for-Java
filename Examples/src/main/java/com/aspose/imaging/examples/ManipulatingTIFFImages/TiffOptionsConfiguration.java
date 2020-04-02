package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

public class TiffOptionsConfiguration
{
    public static void main(String... args)
    {
		Logger.startExample("TiffOptionsConfiguration");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";

        // Load an image through file path location or stream
		try (Image image = Image.load(dataDir + "new.tiff"))
		{
			// Create an instance of TiffOptions while specifying desired format. Passing TiffExpectedFormat.TiffJpegRGB will set the compression to Jpeg
			// and BitsPerPixel according to the RGB color space
			TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffJpegRgb);

			// Save the result in Tiff format RGB with Jpeg compression
			image.save(Utils.getOutDir() + "TiffOptionsConfiguration_out.tiff", options);
		}
		Logger.endExample();
    }

}
