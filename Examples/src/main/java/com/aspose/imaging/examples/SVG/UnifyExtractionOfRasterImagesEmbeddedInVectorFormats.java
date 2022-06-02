package com.aspose.imaging.examples.SVG;

import com.aspose.imaging.EmbeddedImage;
import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.VectorImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnifyExtractionOfRasterImagesEmbeddedInVectorFormats
{
    public static void main(String[] args)
    {
        Logger.startExample();
        String dataDir = Utils.getSharedDataDir() + "svg" + File.separator;
        String fileName = Path.combine(dataDir, "test2.svg");

        String outputFolder = Utils.getOutDir("svg");
        List<String> files = new ArrayList<>();

        try (Image image = Image.load(fileName))
        {
            EmbeddedImage[] images = ((VectorImage)image).getEmbeddedImages();
            int i = 0;
            for (EmbeddedImage im : images)
            {
                final Image imImage = im.getImage();
                String outFileName = String.format("svg_image%d%s", i++, getExtension(imImage.getFileFormat()));
                String outFilePath = Path.combine(outputFolder, outFileName);
                files.add(outFilePath);
                imImage.save(outFilePath);
                im.close();
            }
        }

        for (String file : files)
        {
            new File(file).delete();
        }

        Logger.endExample();
    }

    private static String getExtension(long format)
    {
        if (format == FileFormat.Jpeg)
        {
            return ".jpg";
        }
        else if (format == FileFormat.Png)
        {
            return ".png";
        }
        else if (format == FileFormat.Bmp)
        {
            return ".bmp";
        }
        return "." + FileFormat.toString(FileFormat.class, format);
    }
}
