package com.aspose.imaging.examples.metafile;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;

public class ConvertEmftoRasterimages {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ConvertEmftoRasterimages.class) + "metafile/";
		//ExStart:ConvertEmftoRasterimages
		String filePath = dataDir + "Picture1.emf";
                // Create EmfRasterizationOption class instance and set properties
		com.aspose.imaging.imageoptions.EmfRasterizationOptions emfRasterizationOptions = new com.aspose.imaging.imageoptions.EmfRasterizationOptions();

		emfRasterizationOptions.setBackgroundColor(com.aspose.imaging.Color.getPapayaWhip());
		emfRasterizationOptions.setPageWidth(300);
		emfRasterizationOptions.setPageHeight(300);

		// Load an existing EMF file as iamge and convert it to EmfImage class
		// object
		com.aspose.imaging.fileformats.emf.EmfImage image = (com.aspose.imaging.fileformats.emf.EmfImage) com.aspose.imaging.Image
				.load(filePath);

		// Convert EMF to BMP
		com.aspose.imaging.imageoptions.BmpOptions objBMPo = new com.aspose.imaging.imageoptions.BmpOptions();
		objBMPo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.bmp", objBMPo);

		// Convert EMF to GIF
		com.aspose.imaging.imageoptions.GifOptions objGIFo = new com.aspose.imaging.imageoptions.GifOptions();
		objGIFo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.gif", objGIFo);

		// Convert EMF to JPEG
		com.aspose.imaging.imageoptions.JpegOptions objJPEGo = new com.aspose.imaging.imageoptions.JpegOptions();
		objJPEGo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.jpeg", objJPEGo);

		// Convert EMF to J2K
		com.aspose.imaging.imageoptions.Jpeg2000Options objJpeg2o = new com.aspose.imaging.imageoptions.Jpeg2000Options();
		objJpeg2o.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.j2k", objJpeg2o);

		// Convert EMF to PNG
		com.aspose.imaging.imageoptions.PngOptions objPNGo = new com.aspose.imaging.imageoptions.PngOptions();
		objPNGo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.png", objPNGo);

		// Convert EMF to PSD
		com.aspose.imaging.imageoptions.PsdOptions objPSDo = new com.aspose.imaging.imageoptions.PsdOptions();
		objPSDo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.psd", objPSDo);

		// Convert EMF to TIFF
		com.aspose.imaging.imageoptions.TiffOptions objTIFFo = new com.aspose.imaging.imageoptions.TiffOptions(
				TiffExpectedFormat.TiffLzwRgb);
		objTIFFo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.tiff", objTIFFo);

		// Convert EMF to WebP
		com.aspose.imaging.imageoptions.WebPOptions objWebPo = new com.aspose.imaging.imageoptions.WebPOptions();
		objWebPo.setVectorRasterizationOptions(emfRasterizationOptions);

		image.save(filePath + "_out.webp", objWebPo);
        //ExEnd:ConvertEmftoRasterimages
        	}

}
