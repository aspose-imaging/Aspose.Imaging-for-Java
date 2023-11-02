package com.aspose.imaging.examples.ModifyingImages.eps;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.eps.EpsImage;
import com.aspose.imaging.fileformats.eps.EpsPreviewFormat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ExportEps
{
    public static void main(String[] args) throws IOException
    {
        Logger.startExample("ExportEps");

        // The path to the documents' directory.
        String dataDir = Utils.getSharedDataDir() + "/eps/";
        final String outDir = Utils.getOutDir("eps");

        byte[] tiffPreviewBytes = null;
        try (EpsImage image = (EpsImage) Image.load(dataDir + "Sample.eps"))
        {
            Image tiffPreview = image.getPreviewImage(EpsPreviewFormat.TIFF);
            if (tiffPreview != null)
            {
                try (ByteArrayOutputStream tiffPreviewStream = new ByteArrayOutputStream())
                {
                    tiffPreview.save(tiffPreviewStream);
                    tiffPreviewBytes = tiffPreviewStream.toByteArray();
                }
            }
        }

        // do something with tiffPreviewBytes

        Logger.endExample();
    }

    private static void deleteFile(String name)
    {
        File f = new File(name);
        if (!f.delete())
            f.deleteOnExit();
    }
}
