package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.SizeF;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.OdgRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForODG {
	public static void main(String... args) {

        Logger.startExample("SupportForODG");
        String dataDir = Utils.getSharedDataDir() + "ConvertingImages/";
        String[] files = new String[] {"example.odg", "example1.odg"};

        final OdgRasterizationOptions rasterizationOptions = new OdgRasterizationOptions();
        for (String file : files)
        {
            String fileName = dataDir + file;
            
            try(Image image = Image.load(fileName))
            {
                rasterizationOptions.setPageSize(new SizeF(image.getWidth(), image.getHeight()));
                String outFileName = Utils.getOutDir() + file.replace(".odg", ".png");
                image.save(outFileName,  new PngOptions()
                                {{
                                    setVectorRasterizationOptions(rasterizationOptions);
                                }});

                outFileName = Utils.getOutDir() + file.replace(".odg", ".pdf");

                image.save(outFileName, new PdfOptions()
                                {{
                                    setVectorRasterizationOptions(rasterizationOptions);
                                }});
            }
        }
        Logger.endExample();
    }
}
