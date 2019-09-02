package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.*;

public class ConvertEMFtoAllRasterImageFormats
{
    public static void main(String... args) throws Exception
    {
		//ExStart:ConvertEMFtoAllRasterImageFormats
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load a Metafile in an instance of EmfMetafileImage class
        EmfMetafileImage metafile = new EmfMetafileImage(dataDir + "Picture1.emf");
		try
		{
			// Save EMF to BMP using BmpOptions object
			metafile.save(dataDir + "ConvertEMFtoAllRasterImageFormats_out.bmp", new BmpOptions());

			// Save EMF to JPG using JpegOptions object
			metafile.save(dataDir + "ConvertEMFtoAllRasterImageFormats_out.jpg", new JpegOptions());

			// Save EMF to PNG using PngOptions object
			metafile.save(dataDir + "ConvertEMFtoAllRasterImageFormats_out.png", new PngOptions());

			// Save EMF to GIF using GifOptions object
			metafile.save(dataDir + "ConvertEMFtoAllRasterImageFormats_out.gif", new GifOptions());

			// Save EMF to TIFF using TiffOptions object with default settings
			metafile.save(dataDir + "ConvertEMFtoAllRasterImageFormats_out.tiff", new TiffOptions(TiffExpectedFormat.Default));
		}
		finally
		{
			metafile.close();
		}

		//ExEnd:ConvertEMFtoAllRasterImageFormats
    }
}
