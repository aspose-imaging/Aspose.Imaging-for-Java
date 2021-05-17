package com.aspose.imaging.examples.ModifyingImages.dxf;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.DxfOptions;

public class ExportToDxf
{
    public static void main(String[] args)
    {
        Logger.startExample();

        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "/eps/";
        final String outDir = Utils.getOutDir("dxf");

        try (Image image = Image.load(dataDir + "Pooh group.eps"))
        {
            DxfOptions options = new DxfOptions();
            options.setTextAsLines(true);
            options.setConvertTextBeziers(true);
            options.setBezierPointCount((byte)20);
            image.save(outDir + "output.dxf", options);
        }

        Utils.deleteFile(outDir + "output.dxf");

        Logger.endExample();
    }
}
