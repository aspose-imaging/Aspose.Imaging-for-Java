package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class CompressingFiles
{
    public static void main(String... args)
    {
		Logger.startExample("CompressingFiles");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir();
        // Load an image from file (or stream)
		try (Image image = Image.load(dataDir + "aspose_logo.png"))
		{
			// Loop over possible CompressionLevel range
			for (int i = 0; i <= 9; i++)
			{
				// Create an instance of PngOptions for each resultant PNG
				PngOptions options = new PngOptions();
				// Set CompressionLevel
				options.setCompressionLevel(i);
				// Save result on disk (or stream)
				image.save(outDir + "CompressingFiles_out" + i + ".png", options);
			}
		}
		Logger.endExample();
    }

}
