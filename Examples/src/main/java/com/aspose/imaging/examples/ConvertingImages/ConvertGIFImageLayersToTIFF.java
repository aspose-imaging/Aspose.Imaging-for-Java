package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.gif.GifImage;
import com.aspose.imaging.fileformats.gif.blocks.GifFrameBlock;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertGIFImageLayersToTIFF {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertGIFImageLayersToTIFF.class) + "ConvertingImages/";
                //ExStart:ConvertGIFImageLayersToTIFF 
		// Load a GIF image
		Image objImage = Image.load(dataDir + "aspose-logo.gif");

		// Convert the image to GIF image
		GifImage gif = (GifImage) objImage;

		// iterate through arry of blocks in the GIF image
		for (int i = 0; i < gif.getBlocks().length; i++) {
			// convert block to GifFrameBlock class instance
			GifFrameBlock gifBlock = ((GifFrameBlock) (gif.getBlocks()[i]));

			// Check if gif block is then ignore it
			if (gifBlock == null) {
				continue;
			}

			// Create an instance of TIFF Option class
			TiffOptions objTiff = new TiffOptions(TiffExpectedFormat.Default);

			// Save the GIFF block as TIFF image
			gifBlock.save(dataDir + "asposelogo" + i + "_out.tif", objTiff);

		}

	}
        //ExEnd:ConvertGIFImageLayersToTIFF 
}
