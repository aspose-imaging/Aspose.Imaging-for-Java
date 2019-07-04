/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Figure;
import com.aspose.imaging.GraphicsPath;
import com.aspose.imaging.Image;
import com.aspose.imaging.PointF;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.RectangleF;
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
 *
 * @author mfazi
 */
public class ManualImageMasking {
    
    public static void main(String[] args) throws Exception {
    //ExStart:ManualImageMasking
        // The path to the documents directory.
	String dataDir = Utils.getSharedDataDir(ManualImageMasking.class) + "ModifyingImages/";
        String sourceFileName = dataDir + "Colored by Faith_small.psd";
        String outputFileName = dataDir + "Colored by Faith_small_manual.png";
        GraphicsPath manualMask = new GraphicsPath();
        Figure firstFigure = new Figure();
        firstFigure.addShape(new EllipseShape(new RectangleF(100, 30, 40, 40)));
        firstFigure.addShape(new RectangleShape(new RectangleF(10, 200, 50, 30)));
        manualMask.addFigure(firstFigure);
        GraphicsPath subPath = new GraphicsPath();
        Figure secondFigure = new Figure();
        secondFigure.addShape(
         new PolygonShape(new PointF[] {
          new PointF(310, 100), new PointF(350, 200), new PointF(250, 200)
         }, true));
        secondFigure.addShape(new PieShape(new RectangleF(10, 10, 80, 80), 30, 120));
        subPath.addFigure(secondFigure);
        manualMask.addPath(subPath);
        RasterImage image = (RasterImage) Image.load(sourceFileName);
        try {
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
         MaskingResult[] maskingResults = new ImageMasking(image).decompose(maskingOptions);
         Image resultImage = maskingResults[1].getImage();
         try {
          resultImage.save(outputFileName);
         } finally {
          resultImage.close();
         }
        } finally {
         image.close();
        }
    //ExEnd:ManualImageMasking
    }
    
}
