package com.aspose.imaging.examples.WebP;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.RotateFlipType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.webp.WebPImage;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author mfazi
 */
public class OpenWebPFile
{

    public static void main(String[] args) throws IOException
    {
        Logger.startExample("OpenWebPFile");

        String dataDir = Utils.getSharedDataDir() + "WebP/";

        String inputFile = dataDir + "Animation1.webp";
        String outputFile = Utils.getOutDir() + "Animation2.webp";
        try (ByteArrayOutputStream ms = new ByteArrayOutputStream())
        {
            try (WebPImage image = (WebPImage) Image.load(inputFile))
            {
                image.resize(300, 450, ResizeType.HighQualityResample);
                image.crop(new Rectangle(10, 10, 200, 300));
                image.rotateFlipAll(RotateFlipType.Rotate90FlipX);
                image.save(ms);
            }

            try (FileOutputStream fs = new FileOutputStream(outputFile))
            {
                fs.write(ms.toByteArray());
            }
        }
        Logger.endExample();
    }
}
