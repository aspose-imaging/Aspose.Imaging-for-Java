package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class GraphicsMeasureString
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String dataDir = Utils.getSharedDataDir() + "gif/";
        // Declare variable to store file path for input image
        String path = dataDir + "ezgif.com-gif-maker(1)___.gif";

        com.aspose.imaging.RasterImage backgroundImage = (com.aspose.imaging.RasterImage) Image.load(path);
        try
        {
            Graphics gr = new Graphics(backgroundImage);
            StringFormat format = new StringFormat();
            SizeF size = gr.measureString("Test", new Font("Arial", 10), SizeF.getEmpty(), format);
            System.out.println("Size: " + size);
        }
        finally
        {
            backgroundImage.close();
        }
        Logger.endExample();
    }
}
