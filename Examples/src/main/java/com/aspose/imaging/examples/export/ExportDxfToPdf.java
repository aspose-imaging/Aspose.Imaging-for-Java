package com.aspose.imaging.examples.export;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.cad.CadImage;
import com.aspose.imaging.imageoptions.CadRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.TypeOfEntities;

public class ExportDxfToPdf {
    public static void main(String[] args) throws Exception {
        String dataDir = Utils.getDataDir(ExportDxfToPdf.class);
        String inputPath = dataDir + "conic_pyramid.dxf";
        String outputPath = dataDir + "Output.pdf";

        CadImage cadImage = (CadImage) Image.load(dataDir + "conic_pyramid.dxf");

        CadRasterizationOptions rasterizationOptions = new CadRasterizationOptions();
        rasterizationOptions.setPageWidth(500);
        rasterizationOptions.setPageHeight(500);
        rasterizationOptions.setTypeOfEntities(TypeOfEntities.Entities3D);
        rasterizationOptions.setLayouts(new String[]{"Model"});

        PdfOptions pdfOptions = new PdfOptions();
        pdfOptions.setVectorRasterizationOptions(rasterizationOptions);
        cadImage.save(outputPath, pdfOptions);

        System.out.println("File saved " + outputPath);
    }
}




