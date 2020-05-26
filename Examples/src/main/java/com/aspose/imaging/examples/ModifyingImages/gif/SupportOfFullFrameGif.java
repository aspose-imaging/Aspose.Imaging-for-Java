package com.aspose.imaging.examples.ModifyingImages.gif;

import com.aspose.imaging.Image;
import com.aspose.imaging.IntRange;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.MultiPageOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.io.File;

public class SupportOfFullFrameGif
{
    public static void main(String... args)
    {
        Logger.startExample("SupportOfFullFrameGif");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String fileName = "Animation.gif";
        String inputFilePath = dataDir + fileName;
        String outputFilePath = Utils.getOutDir() + fileName + "_FullFrame.tif";
        String outputFilePath1 = Utils.getOutDir() + fileName + "_NonFullFrame.tif";
        // Load an image using the factory method Load exposed by Image class
        try (Image image = Image.load(inputFilePath))
        {
            MultiPageOptions multiPageOptions = new MultiPageOptions(new IntRange(2, 5));
            TiffOptions tiffOptions = new TiffOptions(TiffExpectedFormat.TiffDeflateRgb);
            tiffOptions.setMultiPageOptions(multiPageOptions);
            tiffOptions.setFullFrame(true);
            image.save(outputFilePath, tiffOptions);
            tiffOptions.setFullFrame(false);
            image.save(outputFilePath1, tiffOptions);
        }

        File f = new File(outputFilePath);
        f.delete();
        f = new File(outputFilePath1);
        f.delete();

        Logger.endExample();
    }
}
