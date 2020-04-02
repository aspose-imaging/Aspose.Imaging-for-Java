package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.GifOptions;
import com.aspose.imaging.sources.StreamSource;

import java.util.Arrays;

public class ControllCacheReallocation
{
    public static void main(String... args)
    {
        Logger.startExample("ControllCacheReallocation");
        // The path to the documents directory.
        String dataDir = Utils.getOutDir();

        // By default the cache folder is set to the local temp directory.  You can specify a different cache folder from the default this way:
        Cache.setCacheFolder(dataDir);

        // Auto mode is flexible and efficient
        Cache.setCacheType(CacheType.Auto);

        // The default cache max value is 0, which means that there is no upper limit
        Cache.setMaxDiskSpaceForCache(1073741824); // 1 gigabyte
        Cache.setMaxMemoryForCache(1073741824); // 1 gigabyte

        // We do not recommend that you change the following property because it may greatly affect performance
        Cache.setExactReallocateOnly(false);

        // At any time you can check how many bytes are currently allocated for the cache in memory or on disk By examining the following properties
        long l1 = Cache.getAllocatedDiskBytesCount();
        long l2 = Cache.getAllocatedMemoryBytesCount();
        GifOptions options = new GifOptions();
        options.setPalette(new ColorPalette(new Color[] { Color.getRed(), Color.getBlue(), Color.getBlack(), Color.getWhite() }));
        options.setSource(new StreamSource());
        try (RasterImage image = (RasterImage) Image.create(options, 100, 100))
        {
            Color[] pixels = new Color[10000];
            Arrays.fill(pixels, Color.getWhite());

            image.savePixels(image.getBounds(), pixels);

            // After executing the code above 40000 bytes are allocated to memory.
            long diskBytes = Cache.getAllocatedDiskBytesCount();
            long memoryBytes = Cache.getAllocatedMemoryBytesCount();
        }

        // The allocation properties may be used to check whether all Aspose.Imaging objects were properly disposed. If you've forgotten to call dispose on an object the cache values will not be 0.
        l1 = Cache.getAllocatedDiskBytesCount();
        l2 = Cache.getAllocatedMemoryBytesCount();
        Logger.endExample();
    }
}
