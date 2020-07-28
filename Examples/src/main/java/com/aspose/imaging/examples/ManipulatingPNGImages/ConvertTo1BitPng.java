package com.aspose.imaging.examples.ManipulatingPNGImages;

import com.aspose.imaging.*;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.JpegOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ConvertTo1BitPng
{
    public static void main(String[] args)
    {
        Logger.startExample("ConvertTo1BitPng");
        String inputFilePath = Utils.getSharedDataDir() + "Png/00020.png";
        String outputFilePath = Utils.getOutDir("Png") + "00020_ png.png";
        exportImage(inputFilePath, outputFilePath, FileFormat.Png, 0, null);
        Logger.endExample();
    }

    @SuppressWarnings("SameParameterValue")
    private static void exportImage(
            String sourceImageFilePath,
            String outputImageFilePath,
            long targetFormat,
            float rotateAngle,
            Integer rotateFlipType)
    {
        LoadOptions options = new LoadOptions();
        options.setBufferSizeHint(450);
        try (RasterImage image = (RasterImage) Image.load(sourceImageFilePath, options))
        {
            if (!image.isCached())
            {
                // !!! The caching call was in the customer example.
                // We strongly recommend that you do not use caching in this case,
                // since this leads to a noticeable decrease in performance in this case (in memory optimization strategy).
                image.cacheData();
            }

            if (rotateAngle != 0)
            {
                image.rotate(rotateAngle);
            }

            if (rotateFlipType != null)
            {
                image.rotateFlip(rotateFlipType);
            }

            int bitsPerPixel = image.getBitsPerPixel();
            int bitDepth = bitsPerPixel == 1 ? 1 : bitsPerPixel < 8 ? 8 : 24;

            ImageOptionsBase exportOptions;
            if (targetFormat == FileFormat.Jpeg)
            {
                if (bitDepth <= 8)
                {
                    JpegOptions jpegOptions = new JpegOptions();
                    jpegOptions.setPalette(ColorPaletteHelper.create8BitGrayscale(true));
                    jpegOptions.setColorType(JpegCompressionColorMode.Grayscale);
                    exportOptions = jpegOptions;
                }
                else
                {
                    exportOptions = new JpegOptions();
                }
            }
            else if (targetFormat == FileFormat.Png)
            {
                PngOptions pngOptions = new PngOptions();
                pngOptions.setProgressive(false);
                if (bitDepth <= 8)
                {
                    pngOptions.setColorType(PngColorType.Grayscale);
                    pngOptions.setBitDepth((byte) bitDepth);
                }
                exportOptions = pngOptions;
            }
            else if (targetFormat == FileFormat.Tiff)
            {
                TiffOptions tiffOptions = new TiffOptions(TiffExpectedFormat.Default);
                exportOptions = tiffOptions;
                switch (bitDepth)
                {
                    case 1:
                        tiffOptions.setPhotometric(TiffPhotometrics.MinIsWhite);
                        tiffOptions.setPalette(ColorPaletteHelper.createMonochrome());
                        tiffOptions.setCompression(TiffCompressions.CcittFax4);
                        tiffOptions.setBitsPerSample(new int[]{1});
                        break;
                    case 8:
                        tiffOptions.setPhotometric(TiffPhotometrics.MinIsWhite);
                        tiffOptions.setPalette(ColorPaletteHelper.create8BitGrayscale(true));
                        tiffOptions.setCompression(TiffCompressions.Deflate);
                        tiffOptions.setBitsPerSample(new int[]{8});
                        break;
                    default:
                        int bitsPerSample = bitDepth / 3;
                        tiffOptions.setPhotometric(TiffPhotometrics.Rgb);
                        tiffOptions.setCompression(TiffCompressions.Jpeg);
                        tiffOptions.setBitsPerSample(new int[]{bitsPerSample, bitsPerSample, bitsPerSample});
                        break;
                }
            }
            else
            {
                return;
            }

            exportOptions.setBufferSizeHint(2056);
            exportOptions.setResolutionSettings(new ResolutionSetting(50, 50));

            image.save(outputImageFilePath, exportOptions);
        }
    }
}
