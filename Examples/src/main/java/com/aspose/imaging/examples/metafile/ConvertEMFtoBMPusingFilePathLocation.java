package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ConvertEMFtoBMPusingFilePathLocation
{
    public static void main(String... args)
    {
		Logger.startExample("ConvertEMFtoBMPusingFilePathLocation");
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        String filePath = dataDir + "picture1.emf";
        // Load a Metafile in an instance of EmfMetafileImage class

		try (EmfImage metafile = (EmfImage) Image.load(filePath))
		{
			// Save image to BMP using BmpOptions object
			metafile.save(Utils.getOutDir() + "ConvertEMFtoBMPusingFilePathLocation_out.bmp", new BmpOptions());
		}
		Logger.endExample();
    }

}
