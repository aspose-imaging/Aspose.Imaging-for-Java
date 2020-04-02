package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Graphics;
import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;

public class AddSignatureToImage
{
    public static void main(String... args)
    {
        Logger.startExample("AddSignatureToImage");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        // Create an instance of Image and load the primary image
        try (Image canvas = Image.load(dataDir + "sampleTiff1.tiff"))
        {
            // Create another instance of Image and load the secondary image containing the signature graphics
            try (Image signature = Image.load(dataDir + "signature.gif"))
            {
                // Create an instance of Graphics class and initialize it using the object of the primary image
                Graphics graphics = new Graphics(canvas);

                // Call the DrawImage method while passing the instance of secondary image and appropriate location. The following snippet tries to draw the secondary image at the right bottom of the primary image
                graphics.drawImage(signature, new Point(canvas.getHeight() - signature.getHeight(), canvas.getWidth() - signature.getWidth()));
                canvas.save(Utils.getOutDir() + "AddSignatureToImage_out.png", new PngOptions());
            }
        }
        Logger.endExample();
    }
}
