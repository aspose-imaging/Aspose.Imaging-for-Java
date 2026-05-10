package com.aspose.imaging.examples.ModifyingImages.hdr;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.core.photo.hdr.HdrImageOptions;
import com.aspose.imaging.fileformats.core.photo.hdr.HdrProcessor;
import com.aspose.imaging.fileformats.png.PngImage;

public class SupportOfHdrImages
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "jpeg/";
        String outDir = Utils.getOutDir("jpeg");

        String[] sourceFiles = new String[] { "DSC_6918.jpg", "DSC_6919.jpg" };
        RasterImage[] images = new RasterImage[sourceFiles.length];
        int i = 0;
        for (String sourceFile : sourceFiles)
        {
            String sourcePath = Path.combine(dataDir, sourceFile);
            images[i] = (RasterImage)Image.load(sourcePath);
            i++;
        }

        int[] pixels = HdrProcessor.process(images, new HdrImageOptions()
        {{
            setSampleCount(2);
            setSmoothFactor(15);
            setAlignImages(false);
        }});

        String resultPath = Path.combine(outDir, "hdr.jpg");
        try (PngImage image = new PngImage(images[0].getWidth(), images[0].getHeight()))
        {
            image.saveArgb32Pixels(image.getBounds(), pixels);
            image.save(resultPath);
        }

        for (Image image : images)
        {
            image.close();
        }

        Utils.deleteFile(resultPath);

        Logger.endExample();
    }
}
