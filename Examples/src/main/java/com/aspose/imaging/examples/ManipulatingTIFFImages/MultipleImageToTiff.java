
package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;

import java.io.File;
import java.io.FilenameFilter;


public class MultipleImageToTiff
{
    public static void main(String... args)
    {
        Logger.startExample("MultipleImageToTiff");

        String dataDir = Utils.getSharedDataDir() + "ManipulatingTIFFImages/";

        Image tempImage = com.aspose.imaging.Image.load(dataDir + "Image1.png");
        int width;
        int height;
        width = tempImage.getWidth();
        height = tempImage.getHeight();
        try (com.aspose.imaging.imageoptions.TiffOptions tiffOptions = new com.aspose.imaging.imageoptions.TiffOptions(TiffExpectedFormat.Default))
        {
            tiffOptions.setSource(new com.aspose.imaging.sources.FileCreateSource(dataDir + "MultiPage.tiff", false));

            try
                    ( //Create an instance of Image and initialize it with instance of BmpOptions by calling Create method
                      TiffImage tiffImage = (TiffImage) com.aspose.imaging.Image.create(tiffOptions, width, height))
            {
                //do some image processing
                File di = new File(dataDir);
                String[] files = di.list(new FilenameFilter()
                {
                    @Override
                    public boolean accept(File dir, String name)
                    {
                        return name.endsWith(".img");
                    }
                });

                if (files == null)
                    return;

                int index = 0;
                for (String file : files)
                {
                    try (Image inputImage = Image.load(dataDir + file))
                    {
                        inputImage.resize(width, height, ResizeType.NearestNeighbourResample);
                        if (index > 0)
                        {
                            TiffFrame newframe = new TiffFrame(tiffOptions, width, height);
                            tiffImage.addFrame(newframe);
                        }
                        TiffFrame frame = tiffImage.getFrames()[index];
                        frame.savePixels(frame.getBounds(), ((RasterImage) inputImage).loadPixels(inputImage.getBounds()));

                        index += 1;
                    }
                }

                // save all changes
                tiffImage.save(Utils.getOutDir() + "output.tiff");
            }
        }

        Logger.endExample();
    }
}