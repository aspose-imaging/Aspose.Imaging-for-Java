package com.aspose.imaging.examples.memorystrategies;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionMode;
import com.aspose.imaging.fileformats.jpeg.JpegLsInterleaveMode;
import com.aspose.imaging.imageoptions.JpegOptions;

public class OptimizationStrategyInJPEG
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        String outDir = Utils.getOutDir();

        String fileName = "aspose-logo.jpg";
        String inputFileName = dataDir + fileName;

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setBufferSizeHint(50);

        try (Image image = Image.load(inputFileName, loadOptions))
        {
            JpegOptions jpegOptions = new JpegOptions();
            jpegOptions.setCompressionType(JpegCompressionMode.Baseline);
            jpegOptions.setQuality(100);
            image.save(outDir + "outputFile_Baseline.jpg", jpegOptions);
            jpegOptions = new JpegOptions();
            jpegOptions.setCompressionType(JpegCompressionMode.Progressive);
            image.save(outDir + "outputFile_Progressive.jpg", jpegOptions);
            jpegOptions = new JpegOptions();
            jpegOptions.setCompressionType(JpegCompressionMode.Lossless);
            jpegOptions.setColorType(JpegCompressionColorMode.YCbCr);
            jpegOptions.setBitsPerChannel((byte)4);
            image.save(outDir + "outputFile_Lossless.jpg" , jpegOptions);
            jpegOptions = new JpegOptions();
            jpegOptions.setColorType(JpegCompressionColorMode.YCbCr);
            jpegOptions.setCompressionType(JpegCompressionMode.JpegLs);
            jpegOptions.setJpegLsInterleaveMode(JpegLsInterleaveMode.None);
            jpegOptions.setJpegLsAllowedLossyError(3);
            jpegOptions.setJpegLsPreset(null);
            image.save(outDir + "outputFile_JpegLs.jpg", jpegOptions);
        }
    }
}
