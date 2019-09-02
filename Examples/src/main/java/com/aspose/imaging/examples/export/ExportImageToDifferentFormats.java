package com.aspose.imaging.examples.export;

import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.imageoptions.TiffOptions;

public class ExportImageToDifferentFormats
{
    public static void main(String[] args)
    {
        // The path to the documents directory.
        String dataDir = Utils.getSharedDataDir() + "export/";
        //ExStart:ExportImageToDifferentFormats
        //Load an existing image (of type Gif) in an instance of Image class
        com.aspose.imaging.Image image = com.aspose.imaging.Image.load(dataDir + "sample.gif");

        try
        {
            //Export to BMP file format using the default options
            image.save(dataDir + "ExportImageToDifferentFormats_out.bmp", new com.aspose.imaging.imageoptions.BmpOptions());

            //Export to JPEG file format using the default options
            image.save(dataDir + "ExportImageToDifferentFormats_out.jpeg", new com.aspose.imaging.imageoptions.JpegOptions());

            //Export to PNG file format using the default options
            image.save(dataDir + "ExportImageToDifferentFormats_out.png", new com.aspose.imaging.imageoptions.PngOptions());

            //Export to TIFF file format using the default options
            image.save(dataDir + "ExportImageToDifferentFormats_out.tiff", new TiffOptions(TiffExpectedFormat.Default));

            // Display Status.
            System.out.println("Image exported to BMP, JPG, PNG and TIFF formats successfully!");
        }
        finally
        {
            image.close();
        }


        //ExEnd:ExportImageToDifferentFormats
    }
}




