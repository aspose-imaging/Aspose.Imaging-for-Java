package com.aspose.imaging.examples.ModifyingImages.multipage;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

import java.util.LinkedList;
import java.util.List;

public class MultipageFromImages
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir();

        String baseFolder = dataDir + "Multipage/";

        String outputFilePath = Utils.getOutDir("Multipage") + "\\MultipageImageCreateTest.tif";
        String[] files = new String[]
                {
                        "33266.tif", "Animation.gif", "elephant.png",
                        "MultiPage.cdr"
                };
        List<Image> images = new LinkedList<>();
        for (String file : files)
        {
            String filePath = baseFolder + file;
            images.add(Image.load(filePath));
        }

        try (Image image = Image.create(images.toArray(new Image[0]), true))
        {
            image.save(outputFilePath, new TiffOptions(TiffExpectedFormat.TiffJpegRgb));
        }

        Utils.deleteFile(outputFilePath);

        Logger.endExample();
    }
}
