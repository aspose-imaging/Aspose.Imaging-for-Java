package com.aspose.imaging.examples.ModifyingImages.bmp;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bmp.BitmapCompression;
import com.aspose.imaging.imageoptions.BmpOptions;

public class BmpRLE4
{
    public static void main(String[] args)
    {
        Logger.startExample();

        String dataDir = Utils.getSharedDataDir() + "Bmp";
        String ouDir = Utils.getOutDir("Bmp");

        try (Image image = Image.load(dataDir + "\\Rle4.bmp"))
        {
            BmpOptions options = new BmpOptions();
            options.setCompression(BitmapCompression.Rle4);
            options.setBitsPerPixel(4);
            options.setPalette(ColorPaletteHelper.create4Bit());

            image.save(ouDir + "\\output.bmp", options);
        }

        Utils.deleteFile(ouDir + "\\output.bmp");

        Logger.endExample();
    }
}
