package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Point;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;

public class AddAlphaBlendingForImage
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("Png");

        try (RasterImage background = (RasterImage) Image.load(dataDir + "image0.png"))
        {
            try (RasterImage overlay = (RasterImage) Image.load(dataDir + "aspose_logo.png"))
            {
                Point center = new Point((background.getWidth() - overlay.getWidth()) / 2,
                        (background.getHeight() - overlay.getHeight()) / 2);
                background.blend(center, overlay, overlay.getBounds(), (byte) 127);
                background.save(outDir + "/blended.png", new PngOptions() {{
                    setColorType(PngColorType.TruecolorWithAlpha);
                }});
            }
        }
        Utils.deleteFile(outDir + "/blended.png");

        Logger.endExample();
    }
}
