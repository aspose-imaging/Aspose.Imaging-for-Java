package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.VectorImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imagefilters.complexutils.Complex;
import com.aspose.imaging.imagefilters.convolution.ConvolutionFilter;
import com.aspose.imaging.imagefilters.filteroptions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KernelFilters
{
    public static void main(String[] args)
    {
        Logger.startExample();

        final int Size = 5;
        final double Sigma = 1.5, Angle = 45;

        double[][] customKernel = getRandomKernel(Size, 7, new Random());
        Complex[][] customComplex = ConvolutionFilter.toComplex(customKernel);
        FilterOptionsBase[] kernelFilters = new FilterOptionsBase[]
                {
                        // convolution filters
                        new ConvolutionFilterOptions(ConvolutionFilter.getEmboss3x3()),
                        new ConvolutionFilterOptions(ConvolutionFilter.getEmboss5x5()),
                        new ConvolutionFilterOptions(ConvolutionFilter.getSharpen3x3()),
                        new ConvolutionFilterOptions(ConvolutionFilter.getSharpen5x5()),
                        new ConvolutionFilterOptions(ConvolutionFilter.getBlurBox(Size)),
                        new ConvolutionFilterOptions(ConvolutionFilter.getBlurMotion(Size, Angle)),
                        new ConvolutionFilterOptions(ConvolutionFilter.getGaussian(Size, Sigma)),
                        new ConvolutionFilterOptions(customKernel),
                        new GaussianBlurFilterOptions(Size, Sigma),
                        new SharpenFilterOptions(Size, Sigma),
                        new MedianFilterOptions(Size),
                        // deconvolution filters
                        new DeconvolutionFilterOptions(ConvolutionFilter.getGaussian(Size, Sigma)),
                        new DeconvolutionFilterOptions(customKernel),
                        new DeconvolutionFilterOptions(customComplex),
                        new GaussWienerFilterOptions(Size, Sigma),
                        new MotionWienerFilterOptions(Size, Sigma, Angle),
                };

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "Png/";
        String outDir = Utils.getOutDir("Png/");
        String[] inputPaths =
                {
                        "template.png"
                };

        List<String> outputs = new ArrayList<>();
        for (String inputPath : inputPaths)
        {
            for (int i = 0; i < kernelFilters.length; i++)
            {
                FilterOptionsBase options = kernelFilters[i];
                try (Image image = Image.load(dataDir + inputPath))
                {
                    String outputPath = String.format("%s%c%s-%d.png", outDir, File.separatorChar, inputPath, i);

                    if (image instanceof RasterImage)
                    {
                        filter((RasterImage) image, options, outputPath);
                    }
                    else if (image instanceof VectorImage)
                    {
                        String vectorAsPng = inputPath + ".png";
                        if (!new File(vectorAsPng).exists())
                        {
                            image.save(vectorAsPng);
                            outputs.add(vectorAsPng);
                        }

                        try (Image png = Image.load(vectorAsPng))
                        {
                            filter((RasterImage) png, options, outputPath);
                        }
                    }
                }
            }
        }

        outputs.forEach(p -> new File(p).delete());

        Logger.endExample();
    }

    static void filter(RasterImage raster, FilterOptionsBase options, String outputPath)
    {
        raster.filter(raster.getBounds(), options);
        raster.save(outputPath);
    }

    static double[][] getRandomKernel(int cols, int rows, Random random)
    {
        double[][] customKernel = new double[cols][rows];
        for (int y = 0; y < customKernel.length; y++)
        {
            for (int x = 0; x < customKernel[0].length; x++)
            {
                customKernel[y][x] = random.nextDouble();
            }
        }
        return customKernel;
    }

}
