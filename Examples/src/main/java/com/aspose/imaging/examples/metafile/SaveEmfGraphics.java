/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.Font;
import com.aspose.imaging.FontStyle;
import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.ConvertingImages.ConvertRasterFormatToSVG;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.emf.EmfImage;
import com.aspose.imaging.fileformats.metafile.EmfRecorderGraphics2D;
import com.aspose.imaging.imageoptions.EmfOptions;


public class SaveEmfGraphics 
{

    public static void main(String... args) throws Exception 
    {

        String dataDir = Utils.getSharedDataDir(ConvertRasterFormatToSVG.class) + "metafile/";
          //ExStart:SaveEmfGraphics
        EmfRecorderGraphics2D graphics = new EmfRecorderGraphics2D(
        new Rectangle(0, 0, 5000, 5000),
        new Size(5000, 5000),
        new Size(1000, 1000));
        {
            Font font = new Font("Arial", 10, FontStyle.Bold | FontStyle.Underline);
            graphics.drawString(font.getName ()+ " " + font.getSize ()+ " " + FontStyle.getName(FontStyle.class, font.getStyle()), font, Color.getBrown(), 10, 10);
            graphics.drawString("some text", font, Color.getBrown(), 10, 30);

            font = new Font("Arial", 24, FontStyle.Italic | FontStyle.Strikeout);
            graphics.drawString(font.getName ()+ " " + font.getSize ()+ " " + FontStyle.getName(FontStyle.class, font.getStyle()), font, Color.getBrown(), 20, 50);
            graphics.drawString("some text", font, Color.getBrown(), 20, 80);

            EmfImage image = graphics.endRecording();
            try
           {
                String path = dataDir+"Fonts.emf";
                image.save(path, new EmfOptions());
            }
        finally
        {
            image.dispose();
        }
    }
 
//ExEnd:SaveEmfGraphics

    }
}
