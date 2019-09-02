package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEMFPlustoFile
{
    public static void main(String... args)
    {
        //ExStart:SaveEMFPlustoFile

        String dataDir = Utils.getSharedDataDir() + "metafile/";

        String path = dataDir + "TestEmfPlusFigures.emf";
        EmfImage image = (EmfImage) Image.load(path);
        try
        {
            image.save(path + ".emf", new EmfOptions());
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SaveEMFPlustoFile
    }
}
