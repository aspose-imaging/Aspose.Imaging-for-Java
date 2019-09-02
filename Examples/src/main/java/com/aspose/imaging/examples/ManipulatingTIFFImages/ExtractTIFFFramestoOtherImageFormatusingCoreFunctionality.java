package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegImage;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class ExtractTIFFFramestoOtherImageFormatusingCoreFunctionality
{
    public static void main(String... args)
    {
		//ExStart:ExtractTIFFFramestoOtherImageFormatusingCoreFunctionality

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";

        TiffImage multiImage = (TiffImage) Image.load(dataDir + "sample.tif");
		try
		{
			int frameCounter = 0;
			for (TiffFrame tiffFrame : multiImage.getFrames())
			{
				multiImage.setActiveFrame(tiffFrame);
				Color[] pixels = multiImage.loadPixels(tiffFrame.getBounds());
				JpegOptions jpgCreateOptions = new JpegOptions();

				jpgCreateOptions
						.setSource(new FileCreateSource(dataDir + "Concat" + frameCounter + ".jpg", false));
				JpegImage jpgImage = (JpegImage) Image.create(jpgCreateOptions, tiffFrame.getWidth(),
						tiffFrame.getHeight());
				try
				{
					jpgImage.savePixels(tiffFrame.getBounds(), pixels);
					jpgImage.save();
				}
				finally
				{
					jpgImage.close();
					jpgCreateOptions.close();
				}

				frameCounter++;
			}
		}
		finally
		{
			multiImage.close();
		}
		//ExEnd:ExtractTIFFFramestoOtherImageFormatusingCoreFunctionality
    }

}
