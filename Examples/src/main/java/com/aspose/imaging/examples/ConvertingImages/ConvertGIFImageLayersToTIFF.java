package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.gif.GifImage;
import com.aspose.imaging.fileformats.gif.IGifBlock;
import com.aspose.imaging.fileformats.gif.blocks.GifFrameBlock;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertGIFImageLayersToTIFF {
	public static void main(String... args) {
		//ExStart:ConvertGIFImageLayersToTIFF
		String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
		// Load a GIF image
		Image objImage = Image.load(dataDir + "aspose-logo.gif");

		try
		{
			// Convert the image to GIF image
			GifImage gif = (GifImage) objImage;

			// iterate through arry of blocks in the GIF image
			IGifBlock[] blocks = gif.getBlocks();
			for (int i = 0; i < blocks.length; i++) {
				// Check if gif block is then ignore it
				if (!(blocks[i] instanceof GifFrameBlock)) {
					continue;
				}

				// convert block to GifFrameBlock class instance
				GifFrameBlock gifBlock = ((GifFrameBlock) (blocks[i]));

				// Create an instance of TIFF Option class
				TiffOptions objTiff = new TiffOptions(TiffExpectedFormat.Default);

				// Save the GIFF block as TIFF image
				gifBlock.save(dataDir + "asposelogo" + i + "_out.tif", objTiff);
			}
		}
		finally
		{
			objImage.close();
		}
		//ExEnd:ConvertGIFImageLayersToTIFF
	}
  
}
