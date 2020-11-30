package com.aspose.imaging.examples.Html5Canvas;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.Html5CanvasOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class ExportToHtml5Canvas
{
    public static void main(String... args)
    {
        Logger.startExample("ExportToHtml5Canvas");
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "svg/";
        try (Image image = Image.load(dataDir + "Sample.svg"))
        {
            VectorRasterizationOptions vectorRasterizationOptions = new SvgRasterizationOptions();
            vectorRasterizationOptions.setPageSize(Size.to_SizeF(image.getSize()));
            Html5CanvasOptions htmlOptions = new Html5CanvasOptions();
            htmlOptions.setVectorRasterizationOptions(vectorRasterizationOptions);
            image.save(Utils.getOutDir() + "Sample.html", htmlOptions);
        }
        Logger.endExample();
    }
}
