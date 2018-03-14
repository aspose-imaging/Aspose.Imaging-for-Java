package com.aspose.imaging.examples.export;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.fileformats.psd.PsdImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class ExportPsdLayersToImages {
    public static void main(String[] args) throws Exception {
        String dataDir = Utils.getSharedDataDir(ExportPsdLayersToImages.class) + "export/";
        //ExStart:ExportPsdLayersToImages
        String inputPath = dataDir + "conic_pyramid.dxf";

        Image image = Image.load(dataDir + "sample.psd");
        PsdImage psdImage = (PsdImage) image;
        PngOptions pngOptions = new PngOptions();
        pngOptions.setColorType(PngColorType.TruecolorWithAlpha);

        for (int i = 0; i < psdImage.getLayers().length; i++) {
            psdImage.getLayers()[i].save(dataDir + "ExportPsdLayersToImages_out" + i + ".png", pngOptions);
        }
    
        //ExEnd:ExportPsdLayersToImages
    }
}
