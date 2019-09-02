package com.aspose.imaging.examples.images;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.GifOptions;

public class ImplementationOfLossyGIFCompressor
{
    public static void main(String[] args) throws Exception
    {
        //ExStart:ImplementationOfLossyGIFCompressor
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "images/";

        // Sets the maximum allowed pixel difference. If greater than zero, lossy compression will be used.
        //  Recommended value for optimal lossy compression is 80. 30 is very light compression, 200 is heavy.
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "aspose-logo.gif");
        try
        {
            GifOptions gifExport = new GifOptions();
            gifExport.setMaxDiff(80);
            image.save(dataDir + "anim_lossy-80.gif", gifExport);
        }
        finally
        {
            image.close();
        }

        //ExEnd:ImplementationOfLossyGIFCompressor
    }
}
       




