package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.SvgOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

public class ConvertRasterFormatToSVG {
	public static void main(String... args) throws Exception {
	String dataDir = Utils.getSharedDataDir(ConvertRasterFormatToSVG.class) + "ConvertingImages/";
        
	//ExStart:ConvertRasterFormatToSVG	
	String[] paths = new String[]
		{
		"C:\\test\\butterfly.gif",
		"C:\\test\\33715-cmyk.jpeg",
		"C:\\test\\3.JPG",
		"C:\\test\\test.j2k",
		"C:\\test\\Rings.png",
		"C:\\test\\3layers_maximized_comp.psd",
		"C:\\test\\img4.TIF",
		"C:\\test\\Lossy5.webp"
		};

       for (String path : paths)
        {
	String destPath = path + ".svg";

	Image image = Image.load(path);
	try
	{
		SvgOptions svgOptions = new SvgOptions();
		SvgRasterizationOptions svgRasterizationOptions = new SvgRasterizationOptions();
		svgRasterizationOptions.setPageWidth(image.getWidth());
		svgRasterizationOptions.setPageHeight(image.getHeight());
		svgOptions.setVectorRasterizationOptions(svgRasterizationOptions);

		image.save(destPath, svgOptions);
	}
	finally
	{
		image.dispose();
	}
        }
	//ExEnd:ConvertRasterFormatToSVG
}
}
