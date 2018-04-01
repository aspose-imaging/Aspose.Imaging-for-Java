package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.imageoptions.GifOptions;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertEMFtoAllRasterImageFormats {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertEMFtoAllRasterImageFormats.class) + "metafile/";
		// Load a Metafile in an instance of EmfMetafileImage class
		EmfMetafileImage metafile = new EmfMetafileImage(dataDir + "Picture1.emf");
                //ExStart:ConvertEMFtoAllRasterImageFormats
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
	
        //ExEnd:ConvertEMFtoAllRasterImageFormats
    }
}
