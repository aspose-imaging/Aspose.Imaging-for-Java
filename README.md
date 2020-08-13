# Java API for Image Processing

It is a [standalone Imaging API](https://products.aspose.com/imaging/java) consists of Java routines that enable your Java applications to draw as well as perform basic to advanced level processing of raster & vector images.

Aspose.Imaging for Java offers robust image compression and high processing speed through native byte access and a range of efficient algorithms. It not only manipulate, export and convert images but also lets you dynamically draw objects using pixel manipulation and Graphics Path.

Directory | Description
--------- | -----------
[Examples](https://github.com/aspose-imaging/Aspose.Imaging-for-Java/tree/master/Examples) | A collection of Java examples that help you learn the product features.
[Plugins](https://github.com/aspose-imaging/Aspose.Imaging-for-Java/tree/master/Plugins) | Plugins that will demonstrate one or more features of Aspose.Imaging for Java.

<p align="center">
  <a title="Download ZIP" href="https://github.com/asposeimaging/Aspose_Imaging_Java/archive/master.zip">
     <img src="https://raw.githubusercontent.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

## Imaging API Features

- Draw raster images with graphics.
- Draw vector images.
- Converting images to various formats.
- [Apply masking](https://docs.aspose.com/imaging/java/applying-masking-to-images/) as well as [Median & Wiener](https://docs.aspose.com/imaging/java/applying-median-and-wiener-filters/) filters.
- Crop, rotate & resize images via API.
- De-skew & transform images.
- Set image properties.

## Read & Write Image Formats

**Raster Formats:** JPEG2000, JPEG, BMP, TIFF, GIF, PNG, APNG\
**Metafiles:** EMF, EMZ, WMF, WMZ\
**Other:** SVG, SVGZ, DICOM

## Save Images As

**Fixed:** PDF\
**Photoshop:** PSD\
**Markup:** HTML5 Canvas

## Read Image Formats

**Various:** DjVu, DNG, ODG, CMX, CDR, DIB, OTG, FODG, EPS (raster preview only), WEBP

## Supported Operating Systems

Aspose.Imaging for Java can be virtually run in any OS where Java is installed (since JDK 1.6)

- Windows (since 7)
- Linux
- MacOS
- Any OS where Java is installed.

Aspose.Imaging works for both x86 and x64 versions of the above listed operating systems.

**Note:** In Linux OS, it is recommended to install the package with Microsoft compatible fonts (e.g. `sudo apt-get install ttf-mscorefonts-installer`).

## Get Started with Aspose.Imaging for Java

Aspose hosts all Java APIs at the [Aspose Repository](https://repository.aspose.com/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-imaging). You can easily use Aspose.BarCode for Java API directly in your Maven projects with simple configurations. For the detailed instructions please visit [Installing Aspose.Imaging for Java from Maven Repository](https://docs.aspose.com/imaging/java/installation/) documentation page.

## Crop EMF Image by Rectangle using Java

```java
MetafileImage metaImage = (MetafileImage) Image.load(dataDir + "Picture1.emf");

// Create an instance of Rectangle class with desired size
Rectangle rectangle = new Rectangle(10, 10, 100, 100);

// Perform the crop operation on object of Rectangle class
metaImage.crop(rectangle);

// Save the result in PNG format
metaImage.save(dataDir + "CropbyRectangle_out.png", new PngOptions());
```

[Home](https://www.aspose.com/) | [Product Page](https://products.aspose.com/imaging/java) | [Docs](https://docs.aspose.com/imaging/java/) | [Demos](https://products.aspose.app/imaging/family) | [API Reference](https://apireference.aspose.com/java/imaging) | [Examples](https://github.com/aspose-imaging/Aspose.Imaging-for-Java) | [Blog](https://blog.aspose.com/category/imaging/) | [Free Support](https://forum.aspose.com/c/imaging) | [Temporary License](https://purchase.aspose.com/temporary-license)
