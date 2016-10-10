package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.examples.Utils;

public class ConvertingWMFtoPDF {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertingWMFtoPNG.class) + "wmf/";
		String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "ConvertingWMFtoPDF_out.pdf";

		// Load an existing WMF image
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(inputFileName);

		// Create an instance of EmfRasterizationOptions class and set different
		// properties
		com.aspose.imaging.imageoptions.EmfRasterizationOptions emfRasterizationOptions = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();
		emfRasterizationOptions.setBackgroundColor(com.aspose.imaging.Color.getWhiteSmoke());
		emfRasterizationOptions.setPageWidth(image.getWidth());
		emfRasterizationOptions.setPageHeight(image.getHeight());

		// Create an instance of PdfOptions class and provide rasterization
		// option
		com.aspose.imaging.imageoptions.PdfOptions pdfOptions = new com.aspose.imaging.imageoptions.PdfOptions();
		pdfOptions.setVectorRasterizationOptions(emfRasterizationOptions);

		// Call the save method, provide output path and PdfOptions to convert
		// the WMF file to PDF and save the output
		image.save(outFileName, pdfOptions);
	}
}
