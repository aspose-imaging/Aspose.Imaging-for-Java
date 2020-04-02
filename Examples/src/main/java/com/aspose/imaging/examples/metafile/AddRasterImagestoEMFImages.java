package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.emf.graphics.EmfRecorderGraphics2D;

public class AddRasterImagestoEMFImages
{
    public static void main(String... args)
    {
        Logger.startExample("AddRasterImagestoEMFImages");
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load the image to be inserted
        RasterImage image = (RasterImage)Image.load(dataDir + "aspose-logo.jpg");
        try
        {
            // Create an instance of Rectangle to store the dimensions of the
            // destination image
            Rectangle rectange = new Rectangle(0, 0, image.getWidth()*10, image.getHeight()*10);
            // Create an instance of Dimension to store the dimensions of the
            // source image
            Size dimension = new Size(image.getWidth(), image.getHeight());
            // Create an instance of EmfRecorderGraphics2D
            EmfRecorderGraphics2D emfRecorderGraphics = new EmfRecorderGraphics2D(rectange, dimension, new Size(1,1));
            // Draw the source image starting from top left corner
            emfRecorderGraphics.drawImage(image, new Point(0, 0));
            // Create an instance of EmfImage
            try(EmfImage emfMetafileImage = emfRecorderGraphics.endRecording())
            {
                // Save the result
                emfMetafileImage.save(Utils.getOutDir() + "AddRasterImagestoEMFImages_out.emf");
            }
        }
        finally
        {
            image.dispose();
        }

        Logger.endExample();
    }
}
