package com.aspose.imaging.examples.wmf;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.examples.Utils;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.fileformats.svg.SvgResourceKeeperCallback;
import com.aspose.imaging.imageloadoptions.MetafileLoadOptions;
import com.aspose.imaging.imageoptions.EmfRasterizationOptions;
import com.aspose.imaging.imageoptions.PdfOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.WmfOptions;
public class ConvertingWMFtoPDF {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertingWMFtoPNG.class) + "wmf/";
                //ExStart:ConvertingWMFtoPDF
                String inputFileName = dataDir + "sample.wmf";
		String outFileName = dataDir + "ConvertingWMFtoPDF_out.pdf";

		// Load an existing WMF image
		//com.aspose.imaging.Image image = com.aspose.imaging.Image.load(inputFileName);
                  Image image = Image.load(dataDir);
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
                //ExEnd:ConvertingWMFtoPDF
        }
}
