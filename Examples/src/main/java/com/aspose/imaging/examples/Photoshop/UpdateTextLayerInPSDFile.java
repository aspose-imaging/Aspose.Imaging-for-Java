package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.License;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;

public class UpdateTextLayerInPSDFile
{
    public static void main(String... args)
    {
        Logger.startExample("UpdateTextLayerInPSDFile");
        License lic = new License();
        lic.setLicense("full_path_to_licence_file");
		String dataDir = Utils.getSharedDataDir() + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
		String outputFile = Utils.getOutDir() + "UpdateTextLayerInPSDFile.psd";
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName);
        try
        {
            com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;
            com.aspose.imaging.fileformats.psd.layers.TextLayer textLayer2 = (com.aspose.imaging.fileformats.psd.layers.TextLayer) psdImage
                    .getLayers()[2];

            textLayer2.updateText("test update", new com.aspose.imaging.Point(100, 100), 72.0f,
                    com.aspose.imaging.Color.getPurple());

            com.aspose.imaging.imageoptions.PsdOptions psdOpt = new com.aspose.imaging.imageoptions.PsdOptions();
            psdOpt.setCompressionMethod(com.aspose.imaging.fileformats.psd.CompressionMethod.RLE);
            psdImage.save(outputFile);
        }
        finally
        {
            image.dispose();
        }
        Logger.endExample();
    }

}
