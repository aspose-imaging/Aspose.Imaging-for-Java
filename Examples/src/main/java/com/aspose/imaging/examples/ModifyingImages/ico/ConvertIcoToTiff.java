package com.aspose.imaging.examples.ModifyingImages.ico;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertIcoToTiff
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "ico/";
        String outDir = Utils.getOutDir("ico");

        try (Image image = Image.load(dataDir + "notebook-ico.ico"))
        {
            image.save(outDir + "result.tiff", new TiffOptions(TiffExpectedFormat.Default));
        }

        Utils.deleteFile(outDir + "result.tiff");

        Logger.endExample();
    }
}
