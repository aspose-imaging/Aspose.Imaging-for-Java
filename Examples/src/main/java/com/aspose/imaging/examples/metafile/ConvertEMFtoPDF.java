package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PdfOptions;

public class ConvertEMFtoPDF {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertEMFtoPDF.class) + "metafile/";
                //ExStart:ConvertEMFtoPDF
                String[] filePaths = new String[] { dataDir + "FilledRectangleRotateMode_c.emf", dataDir + "image5.emf",
				dataDir + "LinearGradientBrushCircuitMode.emf", dataDir + "Pict.emf", dataDir + "Picture1.emf",
				dataDir + "test.emf", dataDir + "wrong-font-size.emf" };

		for (String filePath : filePaths) {
			String outPath = filePath + "ConvertEMFtoPDF_out" + ".pdf";

com.aspose.imaging.fileformats.emf.EmfImage image = (com.aspose.imaging.fileformats.emf.EmfImage) com.aspose.imaging.fileformats.emf.EmfImage.load(filePath);
			try {
				com.aspose.imaging.system.io.FileStream outputStream = new com.aspose.imaging.system.io.FileStream(
						outPath, com.aspose.imaging.system.io.FileMode.Create);
				try {
					if (!image.getHeader().getEmfHeader().getValid()) {
						throw new com.aspose.imaging.coreexceptions.ImageLoadException(
								"The file" + outPath + " is not valid");
					}

					com.aspose.imaging.imageoptions.EmfRasterizationOptions emfRasterization = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();

					emfRasterization.setPageWidth(image.getWidth());
					emfRasterization.setPageHeight(image.getHeight());
					emfRasterization.setBackgroundColor(com.aspose.imaging.Color.getWhiteSmoke());

					PdfOptions pdfOptions = new PdfOptions();
					pdfOptions.setVectorRasterizationOptions(emfRasterization);

					image.save(outputStream.toOutputStream(), pdfOptions);
				} finally {
					outputStream.close();
					outputStream.dispose();
				}
			} finally {
				image.dispose();
			}
		}
                //ExEnd:ConvertEMFtoPDF
        }

}
