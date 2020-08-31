package com.aspose.imaging.examples.ModifyingImages.tiff;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.pathresources.PathResource;
import com.aspose.imaging.fileformats.tiff.pathresources.PathResourceConverter;
import com.aspose.imaging.shapes.BezierShape;

import java.util.Arrays;

public class CreateGraphicsPathFromPathTiffResourcesAndViceVersa
{
    public static void main(String[] args)
    {
        Logger.startExample("CreateGraphicsPathFromPathTiffResourcesAndViceVersa");

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "/Tiff/";
        String outDir = Utils.getOutDir("Tiff");

        try (TiffImage image = (TiffImage) Image.load(Path.combine(dataDir, "Bottle.tif")))
        {
            // Create the GraphicsPath using PathResources from TIFF image
            GraphicsPath graphicsPath = PathResourceConverter.toGraphicsPath(image.getActiveFrame().getPathResources().toArray(new PathResource[0]), image.getActiveFrame().getSize());
            Graphics graphics = new Graphics(image);

            // Draw red line and save the image
            graphics.drawPath(new Pen(Color.getRed(), 10), graphicsPath);
            image.save(Path.combine(outDir, "BottleWithRedBorder.tif"));
        }

        try (TiffImage image = (TiffImage)Image.load(Path.combine(dataDir, "Bottle.tif")))
        {
            // Create rectangular Figure for GraphicsPath
            Figure figure = new Figure();
            figure.addShape(createBezierShape(100f, 100f, 500f, 100f, 500f, 1000f, 100f, 1000f));

            // Create GraphicsPath using our Figure
            GraphicsPath graphicsPath = new GraphicsPath();
            graphicsPath.addFigure(figure);

            // Set PathResources using GraphicsPath
            PathResource[] pathResouze = PathResourceConverter.fromGraphicsPath(graphicsPath, image.getSize());
            image.getActiveFrame().setPathResources(Arrays.asList(pathResouze));

            // Save the image
            image.save(Path.combine(outDir, "BottleWithRectanglePath.tif"));
        }

        Path.deleteFile(Path.combine(outDir, "BottleWithRedBorder.tif"));
        Path.deleteFile(Path.combine(outDir, "BottleWithRectanglePath.tif"));

        Logger.endExample();
    }

    private static BezierShape createBezierShape(float ... coordinates)
    {
        PointF[] bezierPoints = new PointF[coordinates.length/2*3];
        int j = 0;
        final int fixedOffset = 100;
        for (int i = 0; i < coordinates.length - 1; i +=2 )
        {
            bezierPoints[j++] = new PointF(coordinates[i] + fixedOffset, coordinates[i+1] + fixedOffset);
            bezierPoints[j++] = new PointF(coordinates[i] + fixedOffset, coordinates[i+1] + fixedOffset);
            bezierPoints[j++] = new PointF(coordinates[i] + fixedOffset, coordinates[i+1] + fixedOffset);
        }
        return new BezierShape(bezierPoints, true);
    }
}
