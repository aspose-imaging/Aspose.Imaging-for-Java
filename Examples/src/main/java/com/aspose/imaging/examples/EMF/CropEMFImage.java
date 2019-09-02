package com.aspose.imaging.examples.EMF;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;

/**
 * @author mfazi
 */
public class CropEMFImage
{

    public static void main(String[] args)
    {

        //ExStart:CropEMFFile

        String dataDir = Utils.getSharedDataDir() + "EMF/";

        EmfImage image = (EmfImage) Image.load(dataDir + "test.emf");

        try
        {
            image.crop(new Rectangle(10, 10, 100, 150));
            System.out.println(image.getWidth());
            System.out.println(image.getHeight());
            image.save(dataDir + "test.emf_crop.emf");
        }
        finally
        {
            image.close();
        }

        //ExEnd:CropEMFFile

    }

}
