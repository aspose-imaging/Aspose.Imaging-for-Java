package com.aspose.imaging.examples.images;

import com.aspose.imaging.Color;
import com.aspose.imaging.Graphics;
import com.aspose.imaging.Image;
import com.aspose.imaging.Pen;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.BmpOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class DrawingBezier
{
    public static void main(String[] args)
    {
        Logger.startExample("DrawingBezier");

        // Create an instance of BmpOptions and set its various properties
        try (BmpOptions saveOptions = new BmpOptions())
        {
            saveOptions.setBitsPerPixel(32);

            // Set the Source for BmpOptions and Create an instance of Image
            saveOptions.setSource(new FileCreateSource(Utils.getOutDir() + "DrawingBezier_out.bmp"));
            try (Image image = Image.create(saveOptions, 100, 100))
            {
                // Create and initialize an instance of Graphics class and clear Graphics surface
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());

                // Initializes the instance of PEN class with black color and width
                Pen BlackPen = new Pen(Color.getBlack(), 3);
                float startX = 10;
                float startY = 25;
                float controlX1 = 20;
                float controlY1 = 5;
                float controlX2 = 55;
                float controlY2 = 10;
                float endX = 90;
                float endY = 25;

                // Draw a Bezier shape by specifying the Pen object having black color and co-ordinate Points and save all changes.
                graphic.drawBezier(BlackPen, startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY);
                image.save();
            }
        }

        Logger.endExample();
    }
}
