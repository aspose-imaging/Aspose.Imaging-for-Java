package com.aspose.imaging.examples.EMF;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;

/**
 * @author mfazi
 */
public class CropEMFImage
{

    public static void main(String[] args)
    {
        Logger.startExample("CropEMFImage");

        String dataDir = Utils.getSharedDataDir() + "EMF/";

        try (EmfImage image = (EmfImage) Image.load(dataDir + "test.emf"))
        {
            image.crop(new Rectangle(10, 10, 100, 150));
            Logger.println(image.getWidth());
            Logger.println(image.getHeight());
            image.save(Utils.getOutDir() + "test.emf_crop.emf");
        }

        Logger.endExample();
    }

}
