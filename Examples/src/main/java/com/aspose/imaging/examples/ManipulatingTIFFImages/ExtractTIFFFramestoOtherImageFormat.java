package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.imageoptions.JpegOptions;

public class ExtractTIFFFramestoOtherImageFormat
{
    public static void main(String... args)
    {
		Logger.startExample("ExtractTIFFFramestoOtherImageFormat");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";
		try (TiffImage multiImage = (TiffImage) Image.load(dataDir + "sample.tif"))
		{
			TiffFrame[] frames = multiImage.getFrames();
			int i = 0;
			for (TiffFrame frame : frames)
			{
				frame.save(Utils.getOutDir() + "ExtractTIFFFramestoOtherImageFormat_out" + i + ".jpg", new JpegOptions());
			}
		}
		Logger.endExample();
    }

}
