package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ConvertEMFtoBMPusingFilePathLocation {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getDataDir(ConvertEMFtoBMPusingFilePathLocation.class);
		String filePath = dataDir + "picture1.emf";

		// Load a Metafile in an instance of EmfMetafileImage class
		EmfMetafileImage metafile = new EmfMetafileImage(filePath);

		// Save image to BMP using BmpOptions object
		metafile.save(dataDir + "output.bmp", new BmpOptions());
	}

}
