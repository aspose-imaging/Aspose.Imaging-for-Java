package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class SupportOfGetOriginalOptions
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String filePath = Utils.getSharedDataDir() + "tiff/";

        String inputFile = "lichee.tif";
        try (Image image = Image.load(Path.combine(filePath,inputFile)))
        {
            final String outDir = Utils.getOutDir("tiff");
            String output1 = Path.combine(outDir, "result1.tiff");
            String output2 = Path.combine(outDir, "result2.tiff");
            image.save(output1, image.getOriginalOptions());

            TiffFrame frame = ((TiffImage)image).getFrames()[0];
            frame.save(output2, frame.getOriginalOptions());

            Utils.deleteFile(output1);
            Utils.deleteFile(output2);
        }

        Logger.endExample();
    }
}
