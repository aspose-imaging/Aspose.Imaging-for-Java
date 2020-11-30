package com.aspose.imaging.examples.ModifyingImages.gif;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.gif.GifImage;
import com.aspose.imaging.fileformats.gif.blocks.GifFrameBlock;

import java.io.File;
import java.util.Iterator;

public class CreateGifUsingAddPage
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("gif");

        // Load frames
        Iterable<RasterImage> frames = loadFrames(dataDir + "Animation frames");

        GifImage image = null;

        for (RasterImage frame : frames)
        {
            if (image == null)
            {
                // Create GIF image using the first frame
                image = new GifImage(new GifFrameBlock(frame));
                continue;
            }

            // Add frames to the GIF image using the AddPage method
            image.addPage(frame);
        }

        if (image != null)
        {
            image.save(outDir + "Multipage.gif");
            // Clear all resources
            image.close();
            Utils.deleteFile(outDir + "MultiPage.gif");
        }

        Logger.endExample();
    }

    private static Iterable<RasterImage> loadFrames(String directory)
    {
        return new FileList(directory);
    }

    private static class FileList implements Iterable<RasterImage>
    {
        private final File[] images;

        FileList(String directory)
        {
            images = new File(directory).listFiles();
        }

        @Override
        public Iterator<RasterImage> iterator()
        {
            return new Iterator<RasterImage>(){

                int index = -1;

                @Override
                public boolean hasNext()
                {
                    if (images == null || index + 1 >= images.length)
                    return false;

                    index++;
                    return true;
                }

                @Override
                public RasterImage next()
                {
                    return (RasterImage) Image.load(images[index].getAbsolutePath());
                }
            };
        }
    }
}
