package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngImage;
import com.aspose.imaging.shapes.EllipseShape;
import com.aspose.imaging.watermark.WatermarkRemover;
import com.aspose.imaging.watermark.options.ContentAwareFillWatermarkOptions;

public class RemoveWatermarkFilter
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String baseFolder = Utils.getSharedDataDir() + "Png";
        String imageFilePath = baseFolder + "/ball.png";
        String outputFilePath = Utils.getOutDir() + "/result.png";
        try (Image image = Image.load(imageFilePath))
        {
            PngImage pngImage = (PngImage)image;
            GraphicsPath mask = new GraphicsPath();
            Figure firstFigure = new Figure();
            firstFigure.addShape(new EllipseShape(new RectangleF(350, 170, 570 - 350, 400 - 170)));
            mask.addFigure(firstFigure);

            ContentAwareFillWatermarkOptions options = new ContentAwareFillWatermarkOptions(mask);
            options.setMaxPaintingAttempts(4);
            RasterImage result = WatermarkRemover.paintOver(pngImage, options);
            result.save(outputFilePath);
        }

        Logger.endExample();
    }
}
