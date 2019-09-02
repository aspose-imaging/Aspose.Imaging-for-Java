package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.HatchBrush;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.wmf.WmfImage;
import com.aspose.imaging.fileformats.wmf.graphics.WmfRecorderGraphics2D;

public class CreateWMFMetaFileImage
{
    public static void main(String... args)
    {
        // WmfRecorderGraphics2D class provides you the frame or canvas to draw shapes on it.  Create an instance of WmfRecorderGraphics2D class. The constructor takes in 2 parameters:  1. Instance of Imaging Rectangle class 2. An integer value for inches
        //ExStart:CreateWMFMetaFileImage
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";

        WmfRecorderGraphics2D graphics = new WmfRecorderGraphics2D(new Rectangle(0, 0, 100, 100), 96);

        // Define background color
        graphics.setBackgroundColor(Color.getWhiteSmoke());

        // Init Create an instance of Imaging Pen class,  Brush class and mention its color.
        Pen pen = new Pen(Color.getBlue());
        Brush brush = new SolidBrush(Color.getYellowGreen());

        // Polygon Fill polygon and then Draw a polygon
        graphics.fillPolygon(brush, new Point[] { new Point(2, 2), new Point(20, 20), new Point(20, 2) });
        graphics.drawPolygon(pen, new Point[] { new Point(2, 2), new Point(20, 20), new Point(20, 2) });
        HatchBrush hatchBrush = new HatchBrush();
        hatchBrush.setHatchStyle(HatchStyle.Cross);
        hatchBrush.setBackgroundColor(Color.getWhite());
        hatchBrush.setForegroundColor(Color.getSilver());
        brush = hatchBrush;

        // Fill ellipse  and  Draw an ellipse
        graphics.fillEllipse(brush, new Rectangle(25, 2, 20, 20));
        graphics.drawEllipse(pen, new Rectangle(25, 2, 20, 20));

        // Arc Define pen style by setting DashStyle value, Set color of the pen
        pen.setDashStyle(DashStyle.Dot);
        pen.setColor(Color.getBlack());

        // Draw an Arc by calling DrawArc method and set CubicBezier
        graphics.drawArc(pen, new Rectangle(50, 2, 20, 20), 0, 180);
        pen.setDashStyle(DashStyle.Solid);
        pen.setColor(Color.getRed());

        // Draw an CubicBezier
        graphics.drawCubicBezier(pen, new Point(10, 25), new Point(20, 50), new Point(30, 50), new Point(40, 25));

        // Image  Create an Instance of Image class.
        try (RasterImage rasterImage = (RasterImage)Image.load(dataDir + "WaterMark.bmp"))
        {
            // Draw an image by calling DrawImage method and passing parameters raster image and point.
            graphics.drawImage(rasterImage, new Point(50, 50));
        }

        // Line Draw a line by calling DrawLine method and passing x,y coordinates of 1st point and same for 2nd point along with color infor as Pen.
        graphics.drawLine(pen, new Point(2, 98), new Point(2, 50));

        // Pie Define settings of the brush object.
        brush = new SolidBrush(Color.getGreen());
        pen.setColor(Color.getDarkGoldenrod());

        // Fill pie by calling FillPie method and passing parameters brush and an instance of Imaging Rectangle class.
        graphics.fillPie(brush, new Rectangle(2, 38, 20, 20), 0, 45);

        // Draw pie by calling DrawPie method and passing parameters pen and an instance of Imaging Rectangle class.
        graphics.drawPie(pen, new Rectangle(2, 38, 20, 20), 0, 45);
        pen.setColor(Color.getAliceBlue());

        // Polyline Draw Polyline by calling DrawPolyline method and passing parameters pen and points.
        graphics.drawPolyline(pen, new Point[] { new Point(50, 40), new Point(75, 40), new Point(75, 45), new Point(50, 45) });

        // For having Strings Create an instance of Font class.
        Font font = new Font("Arial", 16);

        // Draw String by calling DrawString method and passing parameters string to display, color and X & Y coordinates.
        graphics.drawString("Aspose", font, Color.getBlue(), 25, 75);

        // Call end recording of graphics object and save WMF image by calling Save method.
        try (WmfImage image = graphics.endRecording())
        {
            image.save(dataDir + "CreateWMFMetaFileImage.wmf");
        }
        //ExEnd:CreateWMFMetaFileImage
    }
}
