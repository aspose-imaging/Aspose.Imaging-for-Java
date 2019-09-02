package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;

public class CompressingTIFFImagesWithLZWAlgorithm
{
    public static void main(String... args)
    {
        //ExStart:CompressingTIFFImagesWithLZWAlgorithm
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";

        // Load an image through file path location or stream
        Image image = Image.load(dataDir + "sample.tiff");

        // Create an instance of TiffOptions for the resultant image
        TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);

        // Set BitsPerSample, Compression, Photometric mode and graycale palette
        outputSettings.setBitsPerSample(new int[] { 4 });
        outputSettings.setCompression(TiffCompressions.Lzw);
        outputSettings.setPhotometric(TiffPhotometrics.Palette);
        outputSettings.setPalette(ColorPaletteHelper.create4BitGrayscale(false));
        image.save(dataDir + "SampleTiff_out.tiff", outputSettings);
        //ExEnd:CompressingTIFFImagesWithLZWAlgorithm
    }
}
