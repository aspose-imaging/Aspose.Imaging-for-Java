package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.SizeF;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;

public class SupportOfDPISettingsInPdfOptions {
    
    public static void main(String... args) throws Exception {
        
        String dataDir = Utils.getSharedDataDir(SupportOfDPISettingsInPdfOptions.class) + "ModifyingImages/";
        String fileName = "SampleTiff1.tiff";
        String inputFileName = dataDir + fileName;
        String outFileName = inputFileName + ".pdf";
        try (Image image = Image.load(inputFileName))
        {
            PdfOptions pdfOptions = new PdfOptions();
            pdfOptions.setPageSize(new SizeF(612, 792));
            image.save(outFileName, pdfOptions);
        }
    }    
}