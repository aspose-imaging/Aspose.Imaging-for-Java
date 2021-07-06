package com.aspose.imaging.examples.ModifyingImages.gif;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.gif.GifImage;
import com.aspose.imaging.fileformats.gif.blocks.GifFrameBlock;
import com.aspose.imaging.imageoptions.GifOptions;

public class SupportGifFrameDurationAndNumberOfCycles
{
    public static void main(String... args)
    {
        Logger.startExample();
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "GIF";
        String filepath = Path.combine(dataDir, "ezgif.com-gif-maker(1)___.gif");
        String outputPath = Utils.getOutDir() + "output.gif";

        try (GifImage image = (GifImage) Image.load(filepath))
        {
            image.setFrameTime(2000);
            ((GifFrameBlock)image.getPages()[0]).setFrameTime(200);
            image.save(outputPath, new GifOptions() {{ setLoopsCount(4); }});
        }

        Utils.deleteFile(outputPath);
        Logger.endExample();
    }
}
