package com.aspose.imaging.examples.vectors;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CreateVectorImageWithoutSpecifyingFormat
{
    public static void main(String[] args)
    {
        Logger.startExample("SVGToBMPConversion");

        String dataDir = Utils.getOutDir();

        String filePath = dataDir + "output.svg";
        try (VectorImage image = VectorImage.create(500, 500, GraphicsUnit.Pixel))
        {
            Graphics deviceContext = new Graphics(image);
            deviceContext.setPageUnit(GraphicsUnit.Pixel);

            SolidBrush brush = new SolidBrush(Color.getYellow());
            Pen pen = new Pen(Color.getBlue());

            deviceContext.fillPie(brush, new RectangleF(10, 10, 80, 80), -270, 270);
            deviceContext.drawPie(pen, new RectangleF(10, 10, 80, 80), -270, 270);

            deviceContext.drawArc(pen, new RectangleF(100, 10, 80, 80), 180, 90);

            deviceContext.fillEllipse(brush, new RectangleF(200, 10, 80, 80));
            deviceContext.drawEllipse(pen, new RectangleF(200, 10, 80, 80));
            deviceContext.fillRectangle(brush, new RectangleF(300, 10, 80, 80));
            deviceContext.fillRectangle(brush, new RectangleF(400, 10, 80, 80));

            deviceContext.drawString("Hello World!",
                    new Font("Arial", 16, FontStyle.Bold),
                    new SolidBrush(Color.getBlack()), new PointF(10, 110));
            image.save(filePath,
                    new SvgOptions() {{ setVectorRasterizationOptions(
                            new VectorRasterizationOptions() {{
                                setBackgroundColor(Color.getEmpty()); }});
                    }});
        }

        Utils.deleteFile(filePath);

        Logger.endExample();
    }
}
