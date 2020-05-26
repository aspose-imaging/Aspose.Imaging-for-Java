package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Color;
import com.aspose.imaging.Graphics;
import com.aspose.imaging.Image;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.DicomImage;
import com.aspose.imaging.fileformats.dicom.DicomPage;
import com.aspose.imaging.imageoptions.DicomOptions;
import com.aspose.imaging.sources.StreamSource;

import java.io.File;

public class OptimizationStrategyInDicom
{
    public static void main(String... args)
    {
        Logger.startExample("OptimizationStrategyInDicom");
        String path = Utils.getOutDir() + "output.dcm";

        try (DicomOptions imageOptions = new DicomOptions())
        {
            imageOptions.setSource(new StreamSource());
            imageOptions.setBufferSizeHint(50); // Max memory consumption is 50MB

            try(DicomImage image = (DicomImage)Image.create(imageOptions, 100, 100))
            {
                // Draw something using vector graphics
                Graphics graphics = new Graphics(image);
                graphics.fillRectangle(new SolidBrush(Color.getBlueViolet()), image.getBounds());
                graphics.fillRectangle(new SolidBrush(Color.getAqua()), 10, 20, 50, 20);
                graphics.fillEllipse(new SolidBrush(Color.getOrange()), 30, 50, 70, 30);

                // Save the pixels of the drawn image. They are now on the first page of the Dicom image.
                int[] pixels = image.loadArgb32Pixels(image.getBounds());

                // Add a few pages after, making them darker
                for (int i = 1; i < 5; i++)
                {
                    DicomPage page = image.addPage();
                    page.saveArgb32Pixels(page.getBounds(), pixels);
                    page.adjustBrightness(i * 30);
                }

                // Add a few pages in front of the main page, making them brighter
                for (int i = 1; i < 5; i++)
                {
                    DicomPage page = image.insertPage(0);
                    page.saveArgb32Pixels(page.getBounds(), pixels);
                    page.adjustBrightness(-i * 30);
                }

                // Save the created multi-page image to the output file
                image.save(path);
            }
        }
        File f = new File(path);
        f.delete();
        Logger.endExample();
    }
}
