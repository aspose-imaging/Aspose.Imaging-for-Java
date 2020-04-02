package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DrawingUsingGraphics
{
    public static void main(String[] args)
    {
        Logger.startExample("DrawingUsingGraphics");

        //Create an instance of BmpCreateOptions and set its various properties
        try (com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions())
        {
            createOptions.setBitsPerPixel(24);

            //Create an instance of FileCreateSource and assign it to Source property
            createOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(Utils.getOutDir() + "sample.bmp", false));
            //Create an instance of Image
            try (Image image = Image.create(createOptions, 500, 500))
            {
                //Create and initialize an instance of Graphics
                Graphics graphics = new Graphics(image);

                //Clear the image surface with white color
                graphics.clear(Color.getWhite());

                //Create and initialize a Pen object with blue color
                Pen pen = new Pen(Color.getBlue());

                //Draw Ellipse by defining the bounding rectangle of width 150 and height 100
                graphics.drawEllipse(pen, new Rectangle(10, 10, 150, 100));

                // Save all changes.
                image.save(Utils.getOutDir() + "DrawingUsingGraphics_out.bmp");

                //Print message
                Logger.println("Image drawn successfully. Check output file.");
            }
        }
        Logger.endExample();
    }
}
