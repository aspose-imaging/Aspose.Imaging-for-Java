package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class DrawingUsingGraphicsPath
{
    public static void main(String[] args)
    {
        Logger.startExample("DrawingUsingGraphicsPath");
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

                //Create an instance of GraphicsPath
                GraphicsPath graphicspath = new GraphicsPath();

                //Create an instance of Figure
                Figure figure = new Figure();

                //Add Arc shape to the figure by defining boundary Rectangle
                figure.addShape(new com.aspose.imaging.shapes.ArcShape(new RectangleF(10, 10, 300, 300), 0, 45));

                //Add Arc Polygon shape to the figure by defining boundary Rectangle
                figure.addShape(new com.aspose.imaging.shapes.PolygonShape(new PointF[]{new PointF(150, 10), new PointF(150, 200), new PointF(250, 300), new PointF(350, 400)}, true));

                //Add Arc Polygon shape to the figure by defining boundary Rectangle
                figure.addShape(new com.aspose.imaging.shapes.RectangleShape(new RectangleF(new PointF(250, 250), new SizeF(200, 200))));

                //Add figures to the GraphicsPath object
                graphicspath.addFigures(new Figure[]{figure});

                //Draw Path
                graphics.drawPath(new Pen(Color.getBlack(), 2), graphicspath);

                //Create an instance of HatchBrush and set its properties
                com.aspose.imaging.brushes.HatchBrush hatchbrush = new com.aspose.imaging.brushes.HatchBrush();
                hatchbrush.setBackgroundColor(Color.getBrown());
                hatchbrush.setForegroundColor(Color.getBlue());
                hatchbrush.setHatchStyle(HatchStyle.Vertical);

                //Fill path by supplying the brush and GraphicsPath objects
                graphics.fillPath(hatchbrush, graphicspath);

                // Save the final image.
                image.save();

                // Display Status.
                Logger.println("Processing completed successfully!");
            }
        }
        Logger.endExample();
    }
}




