package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.imageoptions.BmpOptions;

public class ConvertEMFtoBMPusingFilePathLocation
{
    public static void main(String... args) throws Exception
    {
		//ExStart:ConvertEMFtoBMPusingFilePathLocation
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        String filePath = dataDir + "picture1.emf";
        // Load a Metafile in an instance of EmfMetafileImage class
        EmfMetafileImage metafile = new EmfMetafileImage(filePath);

		try
		{
			// Save image to BMP using BmpOptions object
			metafile.save(dataDir + "ConvertEMFtoBMPusingFilePathLocation_out.bmp", new BmpOptions());
		}
		finally
		{
			metafile.close();
		}
		//ExEnd:ConvertEMFtoBMPusingFilePathLocation
    }

}
