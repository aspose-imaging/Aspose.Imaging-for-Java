package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class PixelPerfectTextAlignment
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String baseFolder = Utils.getSharedDataDir() + "CDR";
        String[] alignments = {"Left", "Center", "Right"};
        for (String alignment : alignments)
        {
            drawString(baseFolder, alignment);
        }
        Logger.endExample();
    }

    private static void drawString(String baseFolder, String align)
    {
        String fileName = "output_" + align + ".png";
        String outputFileName = Path.combine(baseFolder, fileName);
        String[] fontNames =
                {
                        "Arial", "Times New Roman",
                        "Bookman Old Style", "Calibri", "Comic Sans MS",
                        "Courier New", "Microsoft Sans Serif", "Tahoma",
                        "Verdana", "Proxima Nova Rg"
                };

        float[] fontSizes = new float[]{10f, 22f, 50f, 100f};
        int width = 3000;
        int height = 3500;

        //Create an instance of PngOptions and set its various properties
        try (PngOptions pngOptions = new PngOptions())
        {
            //Set the Source for PngOptions
            pngOptions.setSource(new FileCreateSource(outputFileName));

            //Create an instance of Image
            try (Image image = Image.create(pngOptions, width, height))
            {
                //Create and initialize an instance of Graphics class
                Graphics graphics = new Graphics(image);
                // To speed up the drawing operations
                graphics.beginUpdate();

                //Clear Graphics surface
                graphics.clear(Color.getWhite());

                //Create a SolidBrush object and set its various properties
                SolidBrush brush = new SolidBrush();
                brush.setColor(Color.getBlack());
                float x = 10;
                int lineX;
                float y = 10;
                float w = width - 20;
                Pen pen = new Pen(Color.getRed(), 1);

                int alignment;
                switch (align)
                {
                    case "Left":
                        alignment = StringAlignment.Near;
                        lineX = Math.round(x);
                        break;

                    case "Center":
                        alignment = StringAlignment.Center;
                        lineX = Math.round(x + w / 2f);
                        break;

                    case "Right":
                        alignment = StringAlignment.Far;
                        lineX = (int) (x + w);
                        break;
                    default:
                        throw new IllegalArgumentException("Wrong alignment: " + align);
                }

                StringFormat stringFormat = new StringFormat(StringFormatFlags.ExactAlignment);
                stringFormat.setAlignment(alignment);
                for (String fontName : fontNames)
                {
                    for (float fontSize : fontSizes)
                    {
                        Font font = new Font(fontName, fontSize);
                        String text = String.format("This is font: %s, size:%d", fontName, (int) fontSize);
                        SizeF s = graphics.measureString(text, font, SizeF.getEmpty(), null);
                        graphics.drawString(text, font, brush, new RectangleF(x, y, w, s.getHeight()), stringFormat);

                        y += s.getHeight();
                    }

                    graphics.drawLine(pen, new Point((int) (x), (int) y), new Point((int) (x + w), (int) y));
                }

                graphics.drawLine(pen, new Point(lineX, 0), new Point(lineX, (int) y));

                graphics.endUpdate();

                // save all changes.
                image.save();
            }
        }

        Path.deleteFile(outputFileName);
    }
}
