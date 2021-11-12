package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.*;
import com.aspose.imaging.customfonthandler.CustomFontData;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class ImageScopedFonts
{
    public static void main(String[] args)
    {
        Logger.startExample();
        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "metafile/";

        String[] files = new String[] { "missing-font.emf", "missing-font.odg", "missing-font.wmf", "missing-font.svg" };

        for (String file : files)
        {
            String outputPath = Path.combine(dataDir, file + ".png");
            customFontSourceTest(dataDir, dataDir, file, Path.combine(dataDir, "Fonts"));
            Utils.deleteFile(outputPath);
        }

        Logger.endExample();
    }

    public static void customFontSourceTest(String inputPath, String outputPath, String fileName, String fontPath)
    {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.addCustomFontSource(ImageScopedFonts::getFontSource, fontPath);
        try (Image img = Image.load(Path.combine(inputPath, fileName), loadOptions))
        {
            VectorRasterizationOptions vectorRasterizationOptions =
                    (VectorRasterizationOptions)img.getDefaultOptions(new Object[] { Color.getWhite(), img.getWidth(), img.getHeight() });
            vectorRasterizationOptions.setTextRenderingHint(TextRenderingHint.SingleBitPerPixel);
            vectorRasterizationOptions.setSmoothingMode(SmoothingMode.None);

            img.save(Path.combine(outputPath, fileName + ".png"), new PngOptions()
            {{
                setVectorRasterizationOptions(vectorRasterizationOptions);
            }});
        }
    }

    // The custom fonts' provider example.
    public static CustomFontData[] getFontSource(Object ... args)
    {
        String fontsPath = "";
        if (args.length > 0)
        {
            fontsPath = args[0].toString();
        }

        List<CustomFontData> customFontData = new LinkedList<>();
        final File[] files = new File(fontsPath).listFiles();
        if (files != null)
        {
            for (File font : files)
            {
                try
                {
                    customFontData.add(new CustomFontData(Path.getFileNameWithoutExtension(font.getName()), Files.readAllBytes(font.toPath())));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return customFontData.toArray(new CustomFontData[0]);
    }
}
