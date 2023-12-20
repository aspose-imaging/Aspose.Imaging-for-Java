package com.aspose.imaging.examples.ModifyingImages.removebackground;

import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.*;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;
import java.io.File;
public class RemoveBackgroundVectors
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "RemoveBackground/";
        String outDir = Utils.getOutDir("RemoveBackground");
        String[] fileNames = { "golfer.emf" };
        RemoveBackgroundSettings[] rbs = new RemoveBackgroundSettings[] {
                new RemoveBackgroundSettings()
                {{
                    setDetectionLevel(30);
                }},
                new RemoveBackgroundSettings()
                {{
                    setBounds(new RectangleF(0, 1000, 5000, 4000));
                }},
                new RemoveBackgroundSettings()
                {{
                    setDetectionLevel(10);
                }},
                new RemoveBackgroundSettings(),
                new RemoveBackgroundSettings(),
                new RemoveBackgroundSettings(),
                new RemoveBackgroundSettings()
                {{
                    setColor1(Color.getBlue());
                }},
                new RemoveBackgroundSettings()
        };

        for (int i = 0; i < fileNames.length; i++)
        {
            removeBackgroundExample(fileNames[i], rbs[i], dataDir, outDir);
        }

        Logger.endExample();
    }

    private static void removeBackgroundExample(String fileName, RemoveBackgroundSettings settings, String dataDir, String outFilePath)
    {
        String inputFilePath = dataDir + fileName;
        File outDir = new File(outFilePath);
        if (!outDir.exists())
        {
            outDir.mkdirs();
        }

        final String outputFile = outFilePath + File.separator + fileName + ".png";
        try (Image image = Image.load(inputFilePath))
        {
            VectorRasterizationOptions vectorOpt = new VectorRasterizationOptions();
            vectorOpt.setBackgroundColor(Color.getTransparent());
            vectorOpt.setPageSize(Size.to_SizeF(image.getSize()));
            PngOptions options = new PngOptions();
            options.setColorType(PngColorType.TruecolorWithAlpha);
            options.setVectorRasterizationOptions(vectorOpt);

            if (image instanceof VectorImage)
            {
                ((VectorImage)image).removeBackground(settings);
            }

            image.save(outputFile, options);
        }

        Utils.deleteFile(outputFile);
    }
}
