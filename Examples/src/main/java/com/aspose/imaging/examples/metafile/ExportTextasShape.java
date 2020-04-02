package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ExportTextasShape
{
    public static void main(String... args)
    {
        Logger.startExample("ExportTextasShape");
		String dataDir = Utils.getSharedDataDir() + "metafile/";
		String outDir = Utils.getOutDir();
        Image image = Image.load(dataDir + "picture1.emf");
        try
        {
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());
            image.save(outDir + "ExportTextasShape_out.svg", new SvgOptions()
            {
                {
                    setVectorRasterizationOptions(emfRasterizationOptions);
                    setTextAsShapes(true);
                }
            });
            image.save(outDir + "ExportTextasShape_text_out.svg", new SvgOptions()
            {
                {
                    setVectorRasterizationOptions(emfRasterizationOptions);
                    setTextAsShapes(false);
                }
            });
        }
        finally
        {
            image.dispose();
        }

        Logger.endExample();
    }
}  
