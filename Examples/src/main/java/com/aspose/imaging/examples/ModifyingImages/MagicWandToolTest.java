package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.magicwand.MagicWandSettings;
import com.aspose.imaging.magicwand.MagicWandTool;
import com.aspose.imaging.magicwand.imagemasks.FeatheringSettings;
import com.aspose.imaging.magicwand.imagemasks.RectangleMask;

public class MagicWandToolTest
{
    public static void main(String[] args)
    {
        Logger.startExample("ImageTransparency");
        // The path to the documents' directory.

        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("Png");
        try (RasterImage image = (RasterImage) Image.load(dataDir + "src.png"))
        {
            // Create a new mask using magic wand tool based on tone and color of pixel {845, 128}
            MagicWandTool.select(image, new MagicWandSettings(845, 128))
                    // Union the existing mask with the specified one created by magic wand tool
                    .union(new MagicWandSettings(416, 387))
                    // Invert the existing mask
                    .invert()
                    // Subtract the specified mask created by magic wand tool from the existing one
                    .subtract(new MagicWandSettings(1482, 346) {{ setThreshold(69); }})
                    // Subtract four specified rectangle masks from the existing mask one by one
                    .subtract(new RectangleMask(0, 0, 800, 150))
                    .subtract(new RectangleMask(0, 380, 600, 220))
                    .subtract(new RectangleMask(930, 520, 110, 40))
                    .subtract(new RectangleMask(1370, 400, 120, 200))
                    // Feather mask with specified settings
                    .getFeathered(new FeatheringSettings() {{ setSize(3); }})
                    // Apply mask to the image
                    .apply();
            image.save(outDir + "/result.png");
        }

        Utils.deleteFile(outDir + "/result.png");

        Logger.endExample();
    }
}
