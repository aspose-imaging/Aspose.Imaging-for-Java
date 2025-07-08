package com.aspose.imaging.examples.SVG;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;

public class CommonGraphicsEngineForSvgEmfWmf
{
    public static void main(String[] args)
    {
        Logger.startExample("SVGToBMPConversion");

        String dataDir = Utils.getOutDir();

        String filePath = dataDir + "test.svg";

        try (VectorImage vectorImage = new SvgImage(100, 100))
        {
            Graphics g = new Graphics(vectorImage);
            g.fillRectangle(new SolidBrush(Color.getLightYellow()), 10, 10, 80, 80);
            g.drawRectangle(new Pen(Color.getRed(), 4), 10, 10, 80, 80);
            g.fillEllipse(new SolidBrush(Color.getLightGreen()), 20, 20, 60, 60);
            g.drawEllipse(new Pen(Color.getGreen(), 2), 20, 20, 60, 60);
            g.fillPie(new SolidBrush(Color.getLightBlue()), new Rectangle(30, 30, 40, 40), 0, 45);
            g.drawPie(new Pen(Color.getBlue(), 1), new Rectangle(30, 30, 40, 40), 0, 45);
            g.drawLine(new Pen(Color.getDarkRed(), 1), 10, 20, 90, 20);
            g.drawLines(new Pen(Color.getDarkRed(), 1), new PointF[] { new PointF(10, 90), new PointF(20, 80), new PointF(30, 90) });
            g.drawPolygon(new Pen(Color.getDarkRed(), 1), new PointF[] { new PointF(90, 90), new PointF(80, 80), new PointF(70, 90) });
            g.drawString("Hello World!", new Font("Arial", 14), new SolidBrush(Color.getDarkBlue()), new PointF(10, 50));
            g.drawArc(new Pen(Color.getBrown(), 1), new Rectangle(30, 30, 40, 40), 135, -90);
            vectorImage.save(filePath);
        }

        Utils.deleteFile(filePath);

        Logger.endExample();
    }
}
