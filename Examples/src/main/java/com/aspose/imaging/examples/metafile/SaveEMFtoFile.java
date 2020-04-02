package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEMFtoFile
{
    public static void main(String... args)
    {
        Logger.startExample("SaveEMFtoFile");
        String dataDir = Utils.getSharedDataDir() + "metafile/";

        String path = dataDir + "TestEmfBezier.emf";
        EmfImage image = (EmfImage) Image.load(path);
        try
        {
            image.save(Utils.getOutDir() + "TestEmfBezier.emf.emf", new EmfOptions());
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }
}
