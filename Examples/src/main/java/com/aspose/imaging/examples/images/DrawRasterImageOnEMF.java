/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.images;

import com.aspose.imaging.GraphicsUnit;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.emf.graphics.EmfRecorderGraphics2D;

/**
 * @author mfazi
 */
public class DrawRasterImageOnEMF
{
    public static void main(String[] args)
    {

        //ExStart:DrawRasterImageOnEMF

        String dir = Utils.getSharedDataDir() + "images/";

        RasterImage imageToDraw = (RasterImage) Image.load(dir + "asposenet_220_src01.png");
        try
        {
            // Load the image for drawing on it (drawing surface)
            EmfImage canvasImage = (EmfImage) Image.load(dir + "input.emf");
            try
            {
                EmfRecorderGraphics2D graphics = EmfRecorderGraphics2D.fromEmfImage(canvasImage);

                // Draw a rectagular part of the raster image within the specified bounds of the vector image (drawing surface).
                // Note that because the source size is not equal to the destination one, the drawn image is stretched horizontally and vertically.
                graphics.drawImage(
                        imageToDraw,
                        new Rectangle(67, 67, canvasImage.getWidth(), canvasImage.getHeight()),
                        new Rectangle(0, 0, imageToDraw.getWidth(), imageToDraw.getHeight()),
                        GraphicsUnit.Pixel);

                // Save the result image
                EmfImage resultImage = graphics.endRecording();
                try
                {
                    resultImage.save(dir + "input.DrawImage.emf");
                }
                finally
                {
                    resultImage.close();
                }
            }
            finally
            {
                canvasImage.close();
            }
        }
        finally
        {
            imageToDraw.close();
        }

        //ExEnd:DrawRasterImageOnEMF

    }

}
