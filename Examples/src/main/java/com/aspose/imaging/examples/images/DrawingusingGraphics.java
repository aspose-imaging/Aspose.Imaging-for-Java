/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Imaging. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Utils;

public class DrawingusingGraphics
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DrawingusingGraphics.class);
        
        //Create an instance of BmpCreateOptions and set its various properties
        com.aspose.imaging.imageoptions.BmpOptions createOptions = new com.aspose.imaging.imageoptions.BmpOptions();
        createOptions.setBitsPerPixel(24);

        //Create an instance of FileCreateSource and assign it to Source property
        createOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(dataDir + "sample.bmp",false));
        //Create an instance of Image
        com.aspose.imaging.Image image = com.aspose.imaging.Image.create(createOptions,500,500);
        
        //Create and initialize an instance of Graphics
        com.aspose.imaging.Graphics graphics = new  com.aspose.imaging.Graphics(image);
     
        //Clear the image surface with white color
        graphics.clear(Color.getWhite());
        
        //Create and initialize a Pen object with blue color
        com.aspose.imaging.Pen pen = new com.aspose.imaging.Pen(com.aspose.imaging.Color.getBlue());

        //Draw Ellipse by defining the bounding rectangle of width 150 and height 100
        graphics.drawEllipse(pen, new com.aspose.imaging.Rectangle(10, 10, 150, 100));
        
        // Save all changes.
        image.save(dataDir + "drawImage.out.bmp");
        
        //Print message
        System.out.println("Image drawn successfully. Check output file.");
    }
}