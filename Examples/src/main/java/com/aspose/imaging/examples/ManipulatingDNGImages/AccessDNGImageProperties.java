package com.aspose.imaging.examples.ManipulatingDNGImages;

import java.io.File;
import java.io.FilenameFilter;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.ResizeType;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.dng.DngImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.sources.FileCreateSource;

public class AccessDNGImageProperties 
{
	public static void main(String[] args) throws Exception 
        {
		//ExStart:ExportDNGImageToJPEGFormat 

        //Declare variables to store file path for input image.
        String sourceFiles = "Path_to_source_folder\\Source\\HDR - 3c.dng";
        
        // Create an instance of Image class and load an exiting DNG file.
        // Convert the image to DngImage object.
        com.aspose.imaging.fileformats.dng.DngImage objimage = (com.aspose.imaging.fileformats.dng.DngImage)
                                                                com.aspose.imaging.Image.load(sourceFiles);
        
        System.out.println("Camera model:" + objimage.getImgData().getImageDataParameters().getModel());
	System.out.println("Camera manufacturer:" + objimage.getImgData().getImageDataParameters().getCameraManufacturer());
	System.out.println("Software:" + objimage.getImgData().getImageDataParameters().getSoftware());
	System.out.println("Colors count:" + objimage.getImgData().getImageDataParameters().getColorsCount());
	System.out.println("Artist:" + objimage.getImgData().getImageOtherParameters().getArtist());
	System.out.println("Aperture:" + objimage.getImgData().getImageOtherParameters().getAperture());
	System.out.println("Focal length:" + objimage.getImgData().getImageOtherParameters().getFocalLength());
	System.out.println("Iso speed:" + objimage.getImgData().getImageOtherParameters().getIsoSpeed());


		//ExEnd:ExportDNGImageToJPEGFormat 
	}

}
