package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;

public class SupportForODG {
	public static void main(String... args) throws Exception {
	String dataDir = Utils.getSharedDataDir(SupportForODG.class) + "ConvertingImages/";
        
	String[] files = new String[] {"example.odg", "example1.odg"};
        String folder = "C:\\Temp\\";
        final MetafileRasterizationOptions rasterizationOptions = new MetafileRasterizationOptions();
     for (String file : files)
       {
	String fileName = folder + file;
	Image image = Image.load(fileName);
	try
	{
		rasterizationOptions.setPageSize(new SizeF(image.getWidth(), image.getHeight()));
		String outFileName = fileName.replace(".odg", ".png");
		image.save(outFileName,
				new PngOptions()
		{{
			setVectorRasterizationOptions(rasterizationOptions);
		}});

		outFileName = fileName.replace(".odg", ".pdf");

		image.save(outFileName,
				new PdfOptions()
		{{
			setVectorRasterizationOptions(rasterizationOptions);
		}});
	}
	finally
	{
		image.dispose();
	}
}
	//ExEnd:SupportForODG
}
}
