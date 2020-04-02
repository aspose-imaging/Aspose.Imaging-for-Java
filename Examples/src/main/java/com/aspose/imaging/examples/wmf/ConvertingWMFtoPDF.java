package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;

public class ConvertingWMFtoPDF
{
    public static void main(String... args)
    {
		Logger.startExample("ConvertingWMFtoPDF");
		String dataDir = Utils.getSharedDataDir() + "wmf/";
        String inputFileName = dataDir + "sample.wmf";
        String outFileName = Utils.getOutDir() + "ConvertingWMFtoPDF_out.pdf";

        // Load an existing WMF image
		try (Image image = Image.load(inputFileName))
		{
			final EmfRasterizationOptions emfRasterizationOptions = new EmfRasterizationOptions();
			emfRasterizationOptions.setBackgroundColor(Color.getWhiteSmoke());
			emfRasterizationOptions.setPageWidth(image.getWidth());
			emfRasterizationOptions.setPageHeight(image.getHeight());

			// Create an instance of PdfOptions class and provide rasterization
			// option
			PdfOptions pdfOptions = new PdfOptions();
			pdfOptions.setVectorRasterizationOptions(emfRasterizationOptions);

			// Call the save method, provide output path and PdfOptions to convert
			// the WMF file to PDF and save the output
			image.save(outFileName, pdfOptions);
		}
		//ExEnd:ConvertingWMFtoPDF
    }
}
