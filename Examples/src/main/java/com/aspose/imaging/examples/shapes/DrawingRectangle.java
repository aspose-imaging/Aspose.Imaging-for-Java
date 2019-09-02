package com.aspose.imaging.examples.shapes;

import com.aspose.imaging.Pen;
import com.aspose.imaging.examples.Utils;

public class DrawingRectangle
{
    public static void main(String[] args)
    {
        //ExStart:DrawingRectangle
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "shapes/";
        // Creates an instance of BmpOptions and set its various properties
        try (com.aspose.imaging.imageoptions.BmpOptions bmpCreateOptions = new com.aspose.imaging.imageoptions.BmpOptions())
        {
            bmpCreateOptions.setBitsPerPixel(32);

            // Define the source property for the instance of BmpOptions
            bmpCreateOptions.setSource(new com.aspose.imaging.sources.StreamSource(new java.io.ByteArrayInputStream(new byte[100 * 100 * 4])));

            // Creates an instance of Image and call Create method by passing the bmpCreateOptionsobject
            try (com.aspose.imaging.Image image = com.aspose.imaging.Image.create(bmpCreateOptions, 100, 100))
            {

                // Create and initialize an instance of Graphics class
                com.aspose.imaging.Graphics graphic = new com.aspose.imaging.Graphics(image);

                // Clear the image surface with Yellow color
                graphic.clear(com.aspose.imaging.Color.getYellow());

                // Draw a dotted rectangle shape by specifying the Pen object having red color and a rectangle structure
                graphic.drawRectangle(new Pen(com.aspose.imaging.Color.getRed()), new com.aspose.imaging.Rectangle(30, 10, 40, 80));

                // Draw a continuous rectangle shape by specifying the Pen object having solid brush with blue color and a rectangle structure
                graphic.drawRectangle(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getBlue())), new com.aspose.imaging.Rectangle(10, 30, 80, 40));

                // Save all changes.
                image.save(dataDir + "DrawingRectangle_out.bmp");
            }
        }

        //Print message
        System.out.println("Rectangle created successfully. Check output file.");
        //ExEnd:DrawingRectangle
    }
}
