package com.aspose.imaging.examples.ModifyingImages.removebackground;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.masking.ImageMasking;
import com.aspose.imaging.masking.options.AutoMaskingGraphCutOptions;
import com.aspose.imaging.masking.options.SegmentationMethod;
import com.aspose.imaging.masking.result.MaskingResult;
import com.aspose.imaging.sources.FileCreateSource;

public class GraphCutAutoMasking
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("Png");

        String inputFile = dataDir + "input.png";

        MaskingResult results;
        try (RasterImage image = (RasterImage) Image.load(inputFile))
        {
            // To use Graph Cut with auto calculated strokes, AutoMaskingGraphCutOptions is used.
            AutoMaskingGraphCutOptions options = new AutoMaskingGraphCutOptions();
            // Indicating that a new calculation of the default strokes should be performed during the image decomposition.
            options.setCalculateDefaultStrokes(true);
            // Setting post-process feathering radius based on the image size.
            options.setFeatheringRadius((Math.max(image.getWidth(), image.getHeight()) / 500) + 1);
            options.setMethod(SegmentationMethod.GraphCut);
            options.setDecompose(false);
            options.setBackgroundReplacementColor(Color.getTransparent());
            final PngOptions pngOptions = new PngOptions();
            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
            pngOptions.setSource(new FileCreateSource("tempFile"));
            options.setExportOptions(pngOptions);

            results = new ImageMasking(image).decompose(options);
        }

        try (RasterImage resultImage = results.get_Item(1).getImage())
        {
            final PngOptions options = new PngOptions();
            options.setColorType(PngColorType.TruecolorWithAlpha);

            resultImage.save(outDir + "output.png", options);
        }

        results.close();

        Utils.deleteFile(outDir + "output.png");

        Logger.endExample();
    }
}
