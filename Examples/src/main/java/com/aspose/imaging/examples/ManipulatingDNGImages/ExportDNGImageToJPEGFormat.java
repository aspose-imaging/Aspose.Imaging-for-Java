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

public class ExportDNGImageToJPEGFormat 
{
	public static void main(String[] args) throws Exception 
        {
		//ExStart:ExportDNGImageToJPEGFormat 

        //Declare variables to store file paths for input and output images.
        String sourceFiles = "Path_to_source_folder\\Source\\HDR - 3c.dng";
        String destPath = "Path_to_results_folder\\Results\\result.jpg";

        // Create an instance of Image class and load an exiting DNG file.
        // Convert the image to DngImage object.
        com.aspose.imaging.fileformats.dng.DngImage objimage = (com.aspose.imaging.fileformats.dng.DngImage)
                                                                com.aspose.imaging.Image.load(sourceFiles);
        // Create an instance of JpegOptions class.
        // convert and save to disk in Jpeg file format.
        objimage.save(destPath, new com.aspose.imaging.imageoptions.JpegOptions());


		//ExEnd:ExportDNGImageToJPEGFormat 
	}

}
