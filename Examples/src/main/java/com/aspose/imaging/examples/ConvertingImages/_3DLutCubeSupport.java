package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.lut.cubelut.CubeLut;

public class _3DLutCubeSupport
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String outDir = Utils.getOutDir("ModifyingImages");

        Rectangle rectangle = new Rectangle(0, 0, 720, 960);

        try (RasterImage image =
                (RasterImage) Image.load(dataDir + "multipage.tiff"))
        {
            image.applyCubeLut(dataDir + "bleach-bypass.cube", rectangle);
            image.save(dataDir + "result-rectangle.tiff");
        }

        rectangle = new Rectangle(0, 0, 720, 960);
        CubeLut cubeLut = CubeLut.load(dataDir +"bleach-bypass.cube");

        try (RasterImage image = (RasterImage)Image.load(dataDir + "multipage.tiff"))
        {
            image.applyCubeLut(cubeLut, rectangle);
            image.save(dataDir + "result-rectangle.tiff");
        }

        Utils.deleteFile(outDir + "result-rectangle.tiff");
        Logger.endExample();
    }
}
