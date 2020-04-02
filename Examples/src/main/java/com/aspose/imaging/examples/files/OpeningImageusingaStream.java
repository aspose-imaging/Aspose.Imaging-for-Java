package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class OpeningImageusingaStream
{
    public static void main(String[] args) throws Exception
    {
        Logger.startExample("OpeningImageusingaStream");
        // Create a Stream Object
        try (java.io.InputStream stream = new java.io.FileInputStream(Utils.getSharedDataDir() + "/images/sample.bmp"))
        {
            // Create an Image Object and open an existing file using the Stream
            // Object
            com.aspose.imaging.Image image = com.aspose.imaging.Image.load(stream);
            image.close();

            // do some image processing
        }
        Logger.endExample();
    }
}
