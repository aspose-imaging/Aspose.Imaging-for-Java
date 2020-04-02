package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.*;

public class ConvertEMFtoAllRasterImageFormats
{
    public static void main(String... args)
    {
		Logger.startExample("ConvertEMFtoAllRasterImageFormats");
        String dataDir = Utils.getSharedDataDir() + "metafile/";
		String outDir = Utils.getOutDir();
        // Load a Metafile in an instance of EmfImage class
		try (EmfImage metafile = (EmfImage) Image.load(dataDir + "Picture1.emf"))
		{
			// Save EMF to BMP using BmpOptions object
			metafile.save(outDir + "ConvertEMFtoAllRasterImageFormats_out.bmp", new BmpOptions());

			// Save EMF to JPG using JpegOptions object
			metafile.save(outDir + "ConvertEMFtoAllRasterImageFormats_out.jpg", new JpegOptions());

			// Save EMF to PNG using PngOptions object
			metafile.save(outDir + "ConvertEMFtoAllRasterImageFormats_out.png", new PngOptions());

			// Save EMF to GIF using GifOptions object
			metafile.save(outDir + "ConvertEMFtoAllRasterImageFormats_out.gif", new GifOptions());

			// Save EMF to TIFF using TiffOptions object with default settings
			metafile.save(outDir + "ConvertEMFtoAllRasterImageFormats_out.tiff", new TiffOptions(TiffExpectedFormat.Default));
		}

		Logger.endExample();
    }
}
