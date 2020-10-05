package com.aspose.imaging.examples.ModifyingImages.dicom;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.dicom.ColorType;
import com.aspose.imaging.fileformats.dicom.Compression;
import com.aspose.imaging.fileformats.dicom.CompressionType;
import com.aspose.imaging.fileformats.jpeg2000.Jpeg2000Codec;
import com.aspose.imaging.imageoptions.DicomOptions;
import com.aspose.imaging.imageoptions.Jpeg2000Options;

public class DicomCompression
{
    public static void main(String[] args)
    {
        Logger.startExample("DicomCompression");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "dicom/";
        String outDir = Utils.getOutDir("dicom");

        String inputFile = dataDir + "original.jpg";
        String output1 = outDir + "original_Uncompressed.dcm";
        String output2 = outDir + "original_JPEG.dcm";
        String output3 = outDir + "original_JPEG2000.dcm";
        String output4 = outDir + "original_RLE.dcm";

        try (Image inputImage = Image.load(inputFile))
        {
            DicomOptions options = new DicomOptions();
            options.setColorType(ColorType.Rgb24Bit);
            Compression compression = new Compression();
            compression.setType(CompressionType.None);
            options.setCompression(compression);

            inputImage.save(output1, options);
        }

        try (Image inputImage = Image.load(inputFile))
        {
            DicomOptions options = new DicomOptions();
            options.setColorType(ColorType.Rgb24Bit);
            Compression compression = new Compression();
            compression.setType(CompressionType.Jpeg);
            options.setCompression(compression);

            inputImage.save(output2, options);
        }

        try (Image inputImage = Image.load(inputFile))
        {
            DicomOptions options = new DicomOptions();
            options.setColorType(ColorType.Rgb24Bit);
            Compression compression = new Compression();
            options.setCompression(compression);

            compression.setType(CompressionType.Jpeg2000);
            Jpeg2000Options jpeg2000Options = new Jpeg2000Options();
            jpeg2000Options.setCodec(Jpeg2000Codec.Jp2);
            jpeg2000Options.setIrreversible(false);
            compression.setJpeg2000(jpeg2000Options);

            inputImage.save(output3, options);
        }

        try (Image inputImage = Image.load(inputFile))
        {
            DicomOptions options = new DicomOptions();
            options.setColorType(ColorType.Rgb24Bit);
            Compression compression = new Compression();
            options.setCompression(compression);
            compression.setType(CompressionType.Rle);

            inputImage.save(output4, options);
        }

        Utils.deleteFile(output1);
        Utils.deleteFile(output2);
        Utils.deleteFile(output3);
        Utils.deleteFile(output4);

        Logger.endExample();
    }
}
