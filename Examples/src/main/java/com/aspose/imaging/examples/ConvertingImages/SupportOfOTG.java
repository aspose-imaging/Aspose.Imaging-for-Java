package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.SizeF;
import com.aspose.imaging.Size;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.OtgRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.ImageOptionsBase;

public class SupportOfOTG {

    public static void main(String... args) throws Exception {

        String dataDir = Utils.getSharedDataDir(SupportForODG.class) + "OTG/";
        String fileName = "VariousObjectsMultiPage.otg";
        String inputFileName = dataDir + fileName;
        ImageOptionsBase[] options = { new PngOptions(), new PdfOptions() };
        for (ImageOptionsBase item : options)
        {
            String fileExt = item instanceof PngOptions ? ".png" : ".pdf";
            try (Image image = Image.load(inputFileName))
            {
                OtgRasterizationOptions otgRasterizationOptions = new OtgRasterizationOptions();
                otgRasterizationOptions.setPageSize(Size.to_SizeF(image.getSize()));
                item.setVectorRasterizationOptions(otgRasterizationOptions);
                image.save(dataDir + "output" + fileExt, item);
            }
        }
    }
}
