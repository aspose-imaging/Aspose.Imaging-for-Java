/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmerguide.drawingshapes.drawingellipse.java;

import com.aspose.imaging.Pen;

public class DrawingEllipse
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmerguide/drawingshapes/drawingellipse/data/";

        // Creates an instance of BmpOptions and set its various properties
        com.aspose.imaging.imageoptions.BmpOptions bmpCreateOptions = new com.aspose.imaging.imageoptions.BmpOptions();
        bmpCreateOptions.setBitsPerPixel(32);

        // Define the source property for the instance of BmpOptions
        bmpCreateOptions.setSource(new com.aspose.imaging.sources.StreamSource(new java.io.ByteArrayInputStream(new byte[100 * 100 * 4])));

        // Creates an instance of Image and call create method by passing the bmpCreateOptions object
        com.aspose.imaging.Image image = com.aspose.imaging.Image.create(bmpCreateOptions, 100, 100);

        // Create and initialize an instance of Graphics class
        com.aspose.imaging.Graphics graphic = new com.aspose.imaging.Graphics(image);

        // Clear the image surface with Yellow color
        graphic.clear(com.aspose.imaging.Color.getYellow());

        // Draw a dotted ellipse shape by specifying the Pen object having red color and a surrounding Rectangle
        graphic.drawEllipse(new Pen(com.aspose.imaging.Color.getRed()),new com.aspose.imaging.Rectangle(30, 10, 40, 80));

        // Draw a continuous ellipse shape by specifying the Pen object having solid brush with blue color and a surrounding Rectangle
        graphic.drawEllipse(new Pen(new com.aspose.imaging.brushes.SolidBrush(com.aspose.imaging.Color.getBlue())),new com.aspose.imaging.Rectangle(10, 30, 80, 40));

        // Save all changes.
        image.save(dataDir + "output.bmp");

        // Display Status.
        System.out.println("Ellipse has been drawn in image successfully!");
    }
}




