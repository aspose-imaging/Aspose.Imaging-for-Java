package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageloadoptions.MetafileLoadOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ExportTextasShape
{
    public static void main(String... args)
    {
		//ExStart:ExportTextasShape
		String dataDir = Utils.getSharedDataDir() + "metafile/";
        Image image = Image.load(dataDir + "picture1.emf", new MetafileLoadOptions(true));
        try
        {
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());
            image.save(dataDir + "ExportTextasShape_out.svg", new SvgOptions()
            {
                {
                    setVectorRasterizationOptions(emfRasterizationOptions);
                    setTextAsShapes(true);
                }
            });
            image.save(dataDir + "ExportTextasShape_text_out.svg", new SvgOptions()
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

        //ExEnd:ExportTextasShape

    }
}  
