package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

public class CompressedVectorFormats
{
    public static void main(String... args)
    {
        Logger.startExample("CompressedVectorFormats");
        String dataDir = Utils.getSharedDataDir() + "svg/";
        try (Image image = Image.load(dataDir + "Sample.svg"))
        {
            VectorRasterizationOptions vectorRasterizationOptions = new SvgRasterizationOptions();
            vectorRasterizationOptions.setPageSize(Size.to_SizeF(image.getSize()));
            SvgOptions svgOptions = new SvgOptions();
            svgOptions.setVectorRasterizationOptions(vectorRasterizationOptions);
            svgOptions.setCompress(true);
            image.save(Utils.getOutDir() + "Sample.svgz", svgOptions);
        }
        Logger.endExample();
    }
}