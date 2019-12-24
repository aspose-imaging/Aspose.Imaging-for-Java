package com.aspose.imaging.examples.ConvertingImages.memorystrategy;

import com.aspose.imaging.Image;
import com.aspose.imaging.LoadOptions;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.jpeg2000.Jpeg2000Codec;
import com.aspose.imaging.imageoptions.Jpeg2000Options;
import com.aspose.imaging.sources.FileCreateSource;

public class OptimizationStrategyInJPEG2000
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        String outDir = Utils.getOutDir();

        // Setting a memory limit of 10 megabytes for target loaded image
        // JP2 codec
        try (Image image = Image.load(Path.combine(dataDir, "inputFile.jp2"),new LoadOptions() {{ setBufferSizeHint(10); }}))
        {
            image.save(Path.combine(outDir, "outputFile.jp2"));
        }

        // J2K codec
        try (Image image = Image.load(Path.combine(dataDir, "inputFile.j2k"), new LoadOptions() {{ setBufferSizeHint(10); }}))
        {
            image.save(Path.combine(outDir, "outputFile.j2k"));
        }

        // Setting a memory limit of 10 megabytes for target created image
        // JP2 codec
        try(Jpeg2000Options createOptions = new Jpeg2000Options())
        {
            createOptions.setCodec(Jpeg2000Codec.Jp2);
            createOptions.setBufferSizeHint(10);
            createOptions.setSource(new FileCreateSource(Path.combine(outDir, "createdFile.jp2"), false));
            try (Image image = Image.create(createOptions, 1000, 1000))
            {
                image.save(); // save to same location
            }
        }

        // J2K codec
        try(Jpeg2000Options createOptions = new Jpeg2000Options())
        {
            createOptions.setCodec(Jpeg2000Codec.J2K);
            createOptions.setBufferSizeHint(10);
            createOptions.setSource(new FileCreateSource(Path.combine(outDir, "createdFile.j2k"), false));
            try (Image image = Image.create(createOptions, 1000, 1000))
            {
                image.save(); // save to same location
            }
        }
    }
}
