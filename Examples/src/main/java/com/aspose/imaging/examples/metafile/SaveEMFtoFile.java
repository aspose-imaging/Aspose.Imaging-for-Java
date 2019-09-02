package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEMFtoFile
{
    public static void main(String... args)
    {
        //ExStart:SaveEMFtoFile
        String dataDir = Utils.getSharedDataDir() + "metafile/";

        String path = dataDir + "TestEmfBezier.emf";
        EmfImage image = (EmfImage) Image.load(path);
        try
        {
            image.save(path + ".emf", new EmfOptions());
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SaveEMFtoFile
    }
}
