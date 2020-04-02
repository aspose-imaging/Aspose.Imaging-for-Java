package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.SvgOptions;

public class ExportTextAsShape
{
    public static void main(String... args)
    {
        Logger.startExample("ExportTextAsShape");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "ModifyingImages/";
        try (Image image = Image.load(dataDir + "Picture1.emf"))
        {
            final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
            emfRasterizationOptions.setBackgroundColor(Color.getWhite());
            emfRasterizationOptions.setPageWidth(image.getWidth());
            emfRasterizationOptions.setPageHeight(image.getHeight());
            image.save(Utils.getOutDir() + "TextAsShapes_out.svg", new SvgOptions()
            {{
                setVectorRasterizationOptions(emfRasterizationOptions);
                setTextAsShapes(true);
            }});

            image.save(Utils.getOutDir() + "TextAsShapesFalse_out.svg", new SvgOptions()
            {{
                setVectorRasterizationOptions(emfRasterizationOptions);
                setTextAsShapes(false);
            }});
        }
        Logger.endExample();
    }
}
