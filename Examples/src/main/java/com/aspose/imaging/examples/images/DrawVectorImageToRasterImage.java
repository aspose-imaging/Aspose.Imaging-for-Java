/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.fileformats.svg.graphics.SvgGraphics2D;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author mfazi
 */
public class DrawVectorImageToRasterImage {
    
    public static void main(String[] args) throws IOException
    {
        Logger.startExample("DrawVectorImageToRasterImage");
     
        String dir = Utils.getSharedDataDir() + "images/";

        try (ByteArrayOutputStream drawnImageStream = new ByteArrayOutputStream())
        {
            // First, rasterize Svg to Png and write the result to a stream.
            try (SvgImage svgImage = (SvgImage) Image.load(dir + "asposenet_220_src02.svg"))
            {
                SvgRasterizationOptions rasterizationOptions = new SvgRasterizationOptions();
                rasterizationOptions.setPageSize(Size.to_SizeF(svgImage.getSize()));

                PngOptions saveOptions = new PngOptions();
                saveOptions.setVectorRasterizationOptions(rasterizationOptions);

                svgImage.save(drawnImageStream, saveOptions);

                // Now load a Png image from stream for further drawing.
                try (RasterImage imageToDraw = (RasterImage) Image.load(new ByteArrayInputStream(drawnImageStream.toByteArray())))
                {
                    // Drawing on the existing Svg image.
                    SvgGraphics2D graphics = new SvgGraphics2D(svgImage);

                    // Scale down the entire drawn image by 2 times and draw it to the center of the drawing surface.
                    int width = imageToDraw.getWidth() / 2;
                    int height = imageToDraw.getHeight() / 2;
                    Point origin = new Point((svgImage.getWidth() - width) / 2, (svgImage.getHeight() - height) / 2);
                    Size size = new Size(width, height);

                    graphics.drawImage(imageToDraw, origin, size);

                    // Save the result image
                    try (SvgImage resultImage = graphics.endRecording())
                    {
                        resultImage.save(Utils.getOutDir() + "asposenet_220_src02.DrawVectorImage.svg");
                    }
                }
            }
        }
        Logger.endExample();
    }
}
