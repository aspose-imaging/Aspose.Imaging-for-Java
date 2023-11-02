package com.aspose.imaging.examples.EPS;

import com.aspose.imaging.FileFormat;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.eps.EpsImage;

import java.util.ArrayList;
import java.util.List;

public class SupportForEPS
{
    public static void main(String... args)
    {
        Logger.startExample("SupportForEPS");

        String dataDir = Utils.getSharedDataDir() + "Eps/";
        String outDir = Utils.getOutDir("Eps");
        List<String> epsPreviewFiles = new ArrayList<>();
        try (EpsImage image = (EpsImage) Image.load(dataDir + "Sample.eps"))
        {
            for (Image preview : image.getPreviewImages())
            {
                String previewPath = outDir + "output." + FileFormat.toString(FileFormat.class, preview.getFileFormat()).toLowerCase();
                preview.save(previewPath);
                epsPreviewFiles.add(previewPath);
            }
        }
        // do something with the preview files

        // finally delete them
        for (String file : epsPreviewFiles)
        {
            Utils.deleteFile(file);
        }

        Logger.endExample();
    }
}