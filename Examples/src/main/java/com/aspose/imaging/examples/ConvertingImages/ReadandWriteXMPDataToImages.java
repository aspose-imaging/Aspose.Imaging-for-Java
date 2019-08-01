package com.aspose.imaging.examples.ConvertingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffFrame;
import com.aspose.imaging.fileformats.tiff.TiffImage;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.aspose.imaging.system.io.MemoryStream;
import com.aspose.imaging.xmp.XmpHeaderPi;
import com.aspose.imaging.xmp.XmpMeta;
import com.aspose.imaging.xmp.XmpPackage;
import com.aspose.imaging.xmp.XmpPacketWrapper;
import com.aspose.imaging.xmp.XmpTrailerPi;
import com.aspose.imaging.xmp.schemas.dublincore.DublinCorePackage;
import com.aspose.imaging.xmp.schemas.photoshop.ColorMode;
import com.aspose.imaging.xmp.schemas.photoshop.PhotoshopPackage;
import static java.lang.System.in;
import static javax.management.Query.in;


public class ReadandWriteXMPDataToImages {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(ReadandWriteXMPDataToImages.class) + "ConvertingImages/";
        //ExStart:ReadandWriteXMPDataToImages
		// Specify the size of image by defining a Rectangle
		Rectangle rect = new Rectangle(0, 0, 100, 200);

		TiffOptions tiffOptions = new TiffOptions(TiffExpectedFormat.TiffJpegRgb);
		tiffOptions.setPhotometric(TiffPhotometrics.MinIsBlack);

		// create the brand new image just for sample purposes
		TiffImage image = new TiffImage(new TiffFrame(tiffOptions, rect.getWidth(), rect.getHeight()));
        // create an instance of XMP-Header
        XmpHeaderPi xmpHeader = new XmpHeaderPi();
               xmpHeader.setGuid(dataDir);
        // create an instance of Xmp-TrailerPi
        XmpTrailerPi xmpTrailer = new XmpTrailerPi(true);

        // create an instance of XMPmeta class to set different attributes
        XmpMeta xmpMeta = new XmpMeta();
        xmpMeta.addAttribute("Author", "Mr Smith");
        xmpMeta.addAttribute("Description", "The fake metadata value");

        // create an instance of XmpPacketWrapper that contains all metadata
        XmpPacketWrapper xmpData = new XmpPacketWrapper(xmpHeader, xmpTrailer, xmpMeta);

        // create an instacne of Photoshop package and set photoshop attributes
        PhotoshopPackage photoshopPackage = new PhotoshopPackage();
        photoshopPackage.setCity("London");
        photoshopPackage.setCountry("England");
        photoshopPackage.setColorMode(ColorMode.Rgb);

        // add photoshop package into XMP metadata
        xmpData.addPackage(photoshopPackage);

        // create an instacne of DublinCore package and set dublinCore attributes
        DublinCorePackage dublinCorePackage = new DublinCorePackage();
        dublinCorePackage.setAuthor("Charles Bukowski");
        dublinCorePackage.setTitle("Confessions of a Man Insane Enough to Live With the Beasts");
        dublinCorePackage.addValue("dc:movie", "Barfly");

        // add dublinCore Package into XMP metadata
        xmpData.addPackage(dublinCorePackage);

        MemoryStream ms = new MemoryStream();
        // update XMP metadata into image
        image.setXmpData(xmpData);

        // Save image on the disk or in memory stream
        image.save();

        //ExEnd:ReadandWriteXMPDataToImages
    }
}
