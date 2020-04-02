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
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.wmf.WmfImage;
import com.aspose.imaging.fileformats.wmf.graphics.WmfRecorderGraphics2D;

/**
 *
 * @author mfazi
 */
public class DrawRasterImageOnWMF {
    
    public static void main(String[] args)  {

        Logger.startExample("DrawRasterImageOnWMF");
     
        String dir = Utils.getSharedDataDir() + "images/";
        
        // Load the image to be drawn
        try (RasterImage imageToDraw = (RasterImage) Image.load(dir + "asposenet_220_src01.png"))
        {
            // Load the image for drawing on it (drawing surface)
            try (WmfImage canvasImage = (WmfImage) Image.load(dir + "asposenet_222_wmf_200.wmf"))
            {
                WmfRecorderGraphics2D graphics = WmfRecorderGraphics2D.fromWmfImage(canvasImage);

                // Draw a rectagular part of the raster image within the specified bounds of the vector image (drawing surface).
                // Note that because the source size is not equal to the destination one, the drawn image is stretched horizontally and vertically.
                graphics.drawImage(
                        imageToDraw,
                        new Rectangle(67, 67, canvasImage.getWidth(), canvasImage.getHeight()),
                        new Rectangle(0, 0, imageToDraw.getWidth(), imageToDraw.getHeight()),
                        GraphicsUnit.Pixel);

                // Save the result image
                try (WmfImage resultImage = graphics.endRecording())
                {
                    resultImage.save(Utils.getOutDir() + "asposenet_222_wmf_200.DrawImage.wmf");
                }
            }
        }
        Logger.endExample();
    }    
}
