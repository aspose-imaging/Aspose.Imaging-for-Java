package com.aspose.imaging.examples.ModifyingImages.webp;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.gif.GifImage;
import com.aspose.imaging.fileformats.gif.IGifBlock;
import com.aspose.imaging.fileformats.gif.blocks.GifFrameBlock;
import com.aspose.imaging.fileformats.webp.WebPFrameBlock;
import com.aspose.imaging.fileformats.webp.WebPImage;
import com.aspose.imaging.imageoptions.WebPOptions;

public class ConvertGIFFImageFrame
{
    public static void main(String[] args)
    {
        Logger.startExample("ConvertGIFFImageFrame");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load GIFF image into the instance of image class.
        try (GifImage gif = (GifImage)Image.load(dataDir + "aspose-logo.gif"))
        {
            // Load an existing WebP image into the instance of WebPImage class.
            try (WebPImage webp = new WebPImage(gif.getWidth(), gif.getHeight(), null))
            {
                // Loop through the GIFF frames
                IGifBlock[] blocks = gif.getBlocks();
                for (IGifBlock tmpBlock : blocks)
                {
                    // Convert GIFF block to GIFF Frame
                    if (!(tmpBlock instanceof GifFrameBlock))
                    {
                        continue;
                    }

                    final GifFrameBlock gifBlock = (GifFrameBlock) tmpBlock;

                    // Create an instance of WebP Frame instance by passing GIFF frame to class constructor.
                    WebPFrameBlock block = new WebPFrameBlock(gifBlock)
                    {{
                        setTop((short) gifBlock.getTop());
                        setLeft((short) gifBlock.getLeft());
                        setDuration((short) gifBlock.getControlBlock().getDelayTime());
                    }};

                    // Add WebP frame to WebP image block list
                    webp.addBlock(block);
                }

                // Set Properties of WebP image.
                WebPOptions options = webp.getOptions();
                options.setAnimBackgroundColor(0xff); // Black
                options.setAnimLoopCount(0); // Infinity
                options.setQuality(50);
                options.setLossless(false);

                // Save WebP image.
                webp.save(Utils.getOutDir() + "ConvertGIFFImageFrame_out.webp");
            }
        }
        Logger.endExample();
    }
}
