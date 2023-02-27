![GitHub all releases](https://img.shields.io/github/downloads/aspose-imaging/Aspose.imaging-for-Java/total) ![GitHub](https://img.shields.io/github/license/aspose-imaging/Aspose.imaging-for-java)

# Java API for Image Processing

[Imaging API](https://products.aspose.com/imaging/java) is a library offering advanced image processing features. Developers can create, edit or convert images in their own application. Also Aspose. Imaging library supports drawing and work with graphic primitives. Image export and conversion (including uniform multi-page image processing) is the one of API core features along with image transformations (resize, crop, flip&rotate, binarization, grayscale, adjust), advanced image manipulation features (filtering, dithering, masking, deskewing) and memory optimization strategies.

Directory | Description
--------- | -----------
[Examples](https://github.com/aspose-imaging/Aspose.Imaging-for-Java/tree/master/Examples) | A collection of Java examples that help you learn the product features.
[Plugins](https://github.com/aspose-imaging/Aspose.Imaging-for-Java/tree/master/Plugins) | Plugins that will demonstrate one or more features of Aspose.Imaging for Java.

<p align="center">
  <a title="Download ZIP" href="https://github.com/asposeimaging/Aspose_Imaging_Java/archive/master.zip">
     <img src="https://raw.githubusercontent.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](Examples)  | A collection of Java examples that help you learn the product features.
[Plugins](Plugins)  | Plugins related to Aspose.Imaging for Java product.


## Imaging API Features

- [Draw raster images with graphics](https://docs.aspose.com/imaging/java/drawing-images-using-graphics/).
- [Draw vector images](https://docs.aspose.com/imaging/java/drawing-vector-images/).
- [Convert images to various formats](https://docs.aspose.com/imaging/java/converting-images/).
- [Apply masking](https://docs.aspose.com/imaging/java/applying-masking-to-images/) as well as [Median & Wiener](https://docs.aspose.com/imaging/java/applying-median-and-wiener-filters/) filters.
- [Crop, rotate & resize images via API](https://docs.aspose.com/imaging/java/crop-rotate-and-resize-images/).
- [De-skew & transform images](https://docs.aspose.com/imaging/java/deskew-image/).
- [Set image properties](https://docs.aspose.com/imaging/java/setting-properties-on-images/).
- [Work with multipage image formats](https://docs.aspose.com/imaging/java/working-with-multipage-image-formats/).

## Load & Save Image Formats

**Raster Formats:** JPEG2000, JPEG, BMP, TIFF, GIF, PNG, DICOM, TGA, ICO\
**Metafiles:** EMF, WMF\
**Compressed metafiles:** EMZ, WMZ\
**Other:** WebP, Svg, Svgz (compressed Svg)\
**Animation:** Apng

## Save Images As
**Fixed-layout:** PDF\
**Photoshop:** PSD\
**Web:** Html5 Canvas\
**AutoCAD:** Dxf

## Load Images

**Various:** DjVu, DNG, ODG, EPS, CMX, CDR, DIB, OTG, FODG


## Platform Independence

Aspose.Imaging for Java can be virtually run in any OS where Java is installed (since JDK 1.6)

- Windows (since 7)
- Linux
- MacOS
- Any OS where Java is installed.

Aspose.Imaging works for both x86 and x64 versions of the above listed operating systems.

**Note:** In Linux OS, it is recommended to install the package with Microsoft compatible fonts (e.g. `sudo apt-get install ttf-mscorefonts-installer`).

## Get Started with Aspose.Imaging for Java

Aspose hosts all Java APIs at the [Aspose Repository](https://repository.aspose.com/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-imaging). You can easily use Aspose.BarCode for Java API directly in your Maven projects with simple configurations. For the detailed instructions please visit [Installing Aspose.Imaging for Java from Maven Repository](https://docs.aspose.com/imaging/java/installation/) documentation page.

## Resize a JPG Image

``` java
try (Image image = Image.load(dir + "template.jpg"))
{
    image.resize(300, 300);
    image.save(dir + "output.jpg");
}
```

## Create & Manipulate PNG via API

``` java
// image width and height
int width = 500;
int height = 300;

// where created image to store
String path = "createdImage.png";
// create options
try (PngOptions options = new PngOptions())
{
	options.setSource(new FileCreateSource(path, false));
	try (PngImage image = (PngImage)Image.create(options, width, height))
	{          
		// create and initialize an instance of Graphics class 
		// and Clear Graphics surface
		Graphics graphic = new Graphics(image);
		graphic.clear(Color.getGreen());
		// draw line on image
		graphic.drawLine(new Pen(Color.getBlue()), 9, 9, 90, 90);        

		// resize image
		int newWidth = 400;
		image.resizeWidthProportionally(newWidth, ResizeType.LanczosResample);  

		// crop the image to specified area
		com.aspose.imaging.Rectangle area = new com.aspose.imaging.Rectangle(10,10,200,200);    
		image.crop(area);
	   
		image.save();
	}
}
```

[Home](https://www.aspose.com/) | [Product Page](https://products.aspose.com/imaging/java) | [Docs](https://docs.aspose.com/imaging/java/) | [Demos](https://products.aspose.app/imaging/family) | [API Reference](https://apireference.aspose.com/imaging/java) | [Examples](https://github.com/aspose-imaging/Aspose.Imaging-for-Java) | [Blog](https://blog.aspose.com/category/imaging/) | [Search](https://search.aspose.com/) | [Free Support](https://forum.aspose.com/c/imaging) | [Temporary License](https://purchase.aspose.com/temporary-license)
