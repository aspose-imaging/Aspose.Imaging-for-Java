package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.metafile.EmfMetafileImage;
import com.aspose.imaging.fileformats.metafile.EmfRecorderGraphics2D;

public class AddRasterImagestoEMFImages
{
    public static void main(String... args)
    {
		//ExStart:AddRasterImagestoEMFImages
        String dataDir = Utils.getSharedDataDir() + "metafile/";
        // Load the image to be inserted
        Image image = Image.load(dataDir + "aspose-logo.jpg");
        try
        {
            // Store the DPI value
            float dpi = 200f;
            // Create an instance of Rectangle to store the dimensions of the
            // destination image
            java.awt.Rectangle rectange = new java.awt.Rectangle(0, 0, image.getWidth(), image.getHeight());
            // Create an instance of Dimension to store the dimensions of the
            // source image
            java.awt.Dimension dimension = new java.awt.Dimension(image.getWidth(), image.getHeight());
            // Create an instance of EmfRecorderGraphics2D
            EmfRecorderGraphics2D emfRecorderGraphics = EmfMetafileImage.createEmfRecorderGraphics(rectange, dimension,
                    dpi, dpi);
            // Draw the source image starting from top left corner
            emfRecorderGraphics.drawImage(image, 0, 0, null);
            // Create an instance of EmfMetafileImage
            EmfMetafileImage emfMetafileImage = emfRecorderGraphics.endRecording();
            // Save the result
            emfMetafileImage.save(dataDir + "AddRasterImagestoEMFImages_out.emf");
			emfMetafileImage.close();
        }
        finally
        {
            image.dispose();
        }

        //ExEnd:AddRasterImagestoEMFImages 
    }
}
