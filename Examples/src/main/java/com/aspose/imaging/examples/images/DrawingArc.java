package com.aspose.imaging.examples.images;

import com.aspose.imaging.Pen;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DrawingArc
{
    public static void main(String[] args)
    {
        Logger.startExample("DrawingArc");
        // Creates an instance of BmpOptions and set its various properties
        try (com.aspose.imaging.imageoptions.BmpOptions bmpCreateOptions = new com.aspose.imaging.imageoptions.BmpOptions())
        {
            bmpCreateOptions.setBitsPerPixel(32);

            // Define the source property for the instance of BmpCreateOptions
            bmpCreateOptions.setSource(
                    new com.aspose.imaging.sources.StreamSource(new java.io.ByteArrayInputStream(new byte[100 * 100 * 4])));

            // Creates an instance of Image and call Create method by passing the
            // BmpOptions object
            try (com.aspose.imaging.Image image = com.aspose.imaging.Image.create(bmpCreateOptions, 100, 100))
            {
                // Create and initialize an instance of Graphics class
                com.aspose.imaging.Graphics graphic = new com.aspose.imaging.Graphics(image);

                // Clear the image surface with Yellow color
                graphic.clear(com.aspose.imaging.Color.getYellow());

                // Draw a dotted arc shape by specifying the Pen object having red black
                // color and coordinates, height, width, start & end angles
                int width = 100;
                int height = 200;
                int startAngle = 45;
                int sweepAngle = 270;

                // Draw arc to screen.
                graphic.drawArc(new Pen(com.aspose.imaging.Color.getBlack()), 0, 0, width, height, startAngle, sweepAngle);

                // Save all changes.
                image.save(Utils.getOutDir() + "DrawingArc_out.bmp");
            }
        }
        Logger.endExample();
    }
}
