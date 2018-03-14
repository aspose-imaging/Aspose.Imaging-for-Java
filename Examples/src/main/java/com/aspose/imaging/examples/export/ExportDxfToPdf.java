package com.aspose.imaging.examples.export;


import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.examples.djvu.ConvertSpecificPortionOfDjVuPage;
import com.aspose.cad.fileformats.cad.CadImage;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.TypeOfEntities;

public class ExportDxfToPdf {
    public static void main(String[] args) throws Exception {
        String dataDir = Utils.getSharedDataDir(ExportDxfToPdf.class) + "export/";
        //ExStart:ExportDxfToPdf 
        String inputPath = dataDir + "conic_pyramid.dxf";
        String outputPath = dataDir + "ExportDxfToPdf_out.pdf";

        Image image = Image.load(dataDir + "aspose-logo.dxf");

        CadRasterizationOptions rasterizationOptions = new CadRasterizationOptions();
        rasterizationOptions.setPageWidth(500);
        rasterizationOptions.setPageHeight(500);
        rasterizationOptions.setTypeOfEntities(TypeOfEntities.Entities3D);
        rasterizationOptions.setLayouts(new String[]{"Model"});

        PdfOptions pdfOptions = new PdfOptions();
        
        image.save(outputPath, pdfOptions);

        System.out.println("File saved " + outputPath);
    }
    //ExEnd:ExportDxfToPdf 
}




