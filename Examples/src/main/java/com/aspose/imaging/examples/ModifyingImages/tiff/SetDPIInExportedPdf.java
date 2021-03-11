package com.aspose.imaging.examples.ModifyingImages.tiff;

import com.aspose.imaging.Image;
import com.aspose.imaging.ResolutionSetting;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.imageoptions.PdfOptions;

public class SetDPIInExportedPdf
{
    public static void main(String[] args)
    {
        Logger.startExample();

        String filePath = Utils.getSharedDataDir() + "/Tiff/";
        String outDir = Utils.getOutDir("Tiff");
        try (TiffImage image = (TiffImage) Image.load(filePath + "AFREY-Original.tif"))
        {
            PdfOptions pdfOptions = new PdfOptions();
            pdfOptions.setResolutionSettings(new ResolutionSetting(
                    image.getHorizontalResolution(),
                    image.getVerticalResolution()));

            image.save(outDir + "/result.pdf", pdfOptions);
        }

        Utils.deleteFile(outDir + "/result.pdf");

        Logger.endExample();
    }
}
