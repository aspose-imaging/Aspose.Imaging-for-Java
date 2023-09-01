package com.aspose.imaging.examples.images;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class GraphicsMeasureString
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String dataDir = Utils.getSharedDataDir() + "jpeg/";
        // Declare variable to store file path for input image
        String path = dataDir + "input.jpg";

        try (RasterImage backgroundImage = (RasterImage) Image.load(path))
        {
            Graphics gr = new Graphics(backgroundImage);
            StringFormat format = new StringFormat();
            SizeF size = gr.measureString("Test", new Font("Arial", 10), SizeF.getEmpty(), format);
            System.out.println("Size: " + size);
        }
        Logger.endExample();
    }
}
