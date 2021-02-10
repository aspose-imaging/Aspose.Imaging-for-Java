/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.masking.ImageMasking;
import com.aspose.imaging.masking.options.ManualMaskingArgs;
import com.aspose.imaging.masking.options.MaskingOptions;
import com.aspose.imaging.masking.options.SegmentationMethod;
import com.aspose.imaging.masking.result.MaskingResult;
import com.aspose.imaging.shapes.EllipseShape;
import com.aspose.imaging.shapes.PieShape;
import com.aspose.imaging.shapes.PolygonShape;
import com.aspose.imaging.shapes.RectangleShape;
import com.aspose.imaging.sources.StreamSource;

/**
 * @author mfazi
 */
public class ManualImageMasking
{

    public static void main(String[] args)
    {
        Logger.startExample("ManualImageMasking");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String sourceFileName = dataDir + "Colored by Faith_small.png";
        String outputFileName = Utils.getOutDir() + "Colored by Faith_small_manual.png";
        GraphicsPath manualMask = new GraphicsPath();
        Figure firstFigure = new Figure();
        firstFigure.addShape(new EllipseShape(new RectangleF(100, 30, 40, 40)));
        firstFigure.addShape(new RectangleShape(new RectangleF(10, 200, 50, 30)));
        manualMask.addFigure(firstFigure);
        GraphicsPath subPath = new GraphicsPath();
        Figure secondFigure = new Figure();
        secondFigure.addShape(
                new PolygonShape(new PointF[]{
                        new PointF(310, 100), new PointF(350, 200), new PointF(250, 200)
                }, true));
        secondFigure.addShape(new PieShape(new RectangleF(10, 10, 80, 80), 30, 120));
        subPath.addFigure(secondFigure);
        manualMask.addPath(subPath);
        try (RasterImage image = (RasterImage) Image.load(sourceFileName))
        {
            MaskingOptions maskingOptions = new MaskingOptions();
            maskingOptions.setMethod(SegmentationMethod.Manual);
            maskingOptions.setDecompose(false);
            ManualMaskingArgs argus = new ManualMaskingArgs();
            argus.setMask(manualMask);
            maskingOptions.setArgs(argus);
            PngOptions options = new PngOptions();
            options.setColorType(PngColorType.TruecolorWithAlpha);
            options.setSource(new StreamSource());
            maskingOptions.setExportOptions(options);
            try (MaskingResult maskingResults = new ImageMasking(image).decompose(maskingOptions))
            {
                try (Image resultImage = maskingResults.get_Item(1).getImage())
                {
                    resultImage.save(outputFileName);
                }
            }
        }
        Logger.endExample();
    }
}
