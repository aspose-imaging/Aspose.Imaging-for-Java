package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.png.PngFilterType;
import com.aspose.imaging.imageoptions.PngOptions;

public class KeepTransparencyWhenIndexingPngImage
{
    public static void main(String[] args)
    {
        Logger.startExample();

        String dataDir = Utils.getSharedDataDir() + "Png/";

        try (RasterImage image = (RasterImage) Image.load(dataDir + "template.png"))
        {
            PngOptions options = new PngOptions();
            options.setCompressionLevel(8);
            options.setColorType(PngColorType.IndexedColor);
            options.setPalette(ColorPaletteHelper.getCloseTransparentImagePalette(image, 256));
            options.setFilterType(PngFilterType.Avg);

            image.save(Utils.getOutDir() + "result.png", options);
        }

        Logger.endExample();
    }
}
