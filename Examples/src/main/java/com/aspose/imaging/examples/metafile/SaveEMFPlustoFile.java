package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEMFPlustoFile
{
    public static void main(String... args)
    {
        Logger.startExample("SaveEMFPlustoFile");

        String dataDir = Utils.getSharedDataDir() + "metafile/";

        String path = dataDir + "TestEmfPlusFigures.emf";
        try (EmfImage image = (EmfImage) Image.load(path))
        {
            image.save(Utils.getOutDir() + "TestEmfPlusFigures.emf.emf", new EmfOptions());
        }

        Logger.endExample();
    }
}
