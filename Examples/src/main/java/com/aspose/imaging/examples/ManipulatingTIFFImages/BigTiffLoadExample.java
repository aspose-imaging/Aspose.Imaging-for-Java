package com.aspose.imaging.examples.ManipulatingTIFFImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.bigtiff.BigTiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.BigTiffOptions;

public class BigTiffLoadExample
{
    public static void main(String... args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "Tiff/";

        String fileName = "input-BigTiff.tif";
        String inputFilePath = Path.combine(dataDir, fileName);
        String outputFilePath = Path.combine(Utils.getOutDir("Tiff"), "result.tiff");

        try (BigTiffImage image = (BigTiffImage) Image.load(inputFilePath))
        {
            image.save(outputFilePath, new BigTiffOptions(TiffExpectedFormat.TiffLzwRgba));
        }

        Path.deleteFile(outputFilePath);

        Logger.endExample();
    }
}
