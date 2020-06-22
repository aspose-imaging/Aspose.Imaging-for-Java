## Aspose.Imaging for Java

This package contains Java example code for [Aspose.Imaging for Java](https://products.aspose.com/imaging/java).

<p align="center">
  <a title="Download ZIP" href="https://github.com/asposeimaging/Aspose_Imaging_Java/archive/master.zip">
     <img src="http://i.imgur.com/hwNhrGZ.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](Examples)  |  Examples for Aspose.Imaging for Java
[Plugins](Plugins)  |  Third-party integration plugins for Aspose.Imaging for Java

# Java API for Image Processing

It is a [standalone Imaging API](https://products.aspose.com/imaging/java) consists of Java routines that enable your Java applications to draw as well as perform basic to advanced level processing of raster & vector images.

Aspose.Imaging for Java offers robust image compression and high processing speed through native byte access and a range of efficient algorithms. It not only manipulate, export and convert images but also lets you dynamically draw objects using pixel manipulation and Graphics Path.

## Imaging API Features

- Draw raster images with graphics.
- Draw vector images.
- Converting images to various formats.
- [Apply masking](https://docs.aspose.com/display/imagingjava/Applying+Masking+to+Images) as well as [Median & Wiener](https://docs.aspose.com/display/imagingjava/Applying+Median+and+Wiener+Filters) filters.
- Crop, rotate & resize images via API.
- De-skew & transform images.
- Set image properties.

## Compact Framework Off Notice

Please note, since 20.6 release of Aspose.Imaging support of .NET Compact Framework has been removed.

For the detailed notes, please visit [Aspose.Imaging for Java 20.6 - Release notes](https://docs.aspose.com/display/imagingjava/Aspose.Imaging+for+Java+20.6+-+Release+notes).

## Read & Write Image Formats

**Raster Formats:** JPEG2000, JPEG, BMP, TIFF, GIF, PNG
**Metafiles:** EMF, WMF
**Other:** WEBP, SVG

## Save Images As

**Fixed:** PDF
**Photoshop:** PSD

## Read Image Formats

**Various:** DICOM, DjVu, DNG, ODG, CMX, CDR, DIB, OTG, FODG, EPS (raster preview only)

## Platform Independence

Aspose.Imaging for Java can be used to develop applications on any Java platform (except Android) starting from JRE 1.6.

## Getting Started with Aspose.Imaging for Java

Are you ready to give Aspose.Imaging for Java a try? 
Simply get it from [Aspose.Imaging for Java page](https://downloads.aspose.com/imaging/java) or integrate it to your maven project such way:
``` xml
<dependencies>
	<dependency>
		<groupId>com.aspose</groupId>
		<artifactId>aspose-imaging</artifactId>
		<version>20.6</version>
		<classifier>jdk16</classifier>
		<type>jar</type>
	</dependency>
</dependencies>

<repositories>
	<repository>
		<id>aspose-maven-repository</id>
		 <url>https://repository.aspose.com/repo/</url>
	</repository>
	<repository>
		<id>com.springsource.repository.bundles.external</id>
		<name>SpringSource Enterprise Bundle Repository - External Bundle Releases</name>
		<url>http://repository.springsource.com/maven/bundles/external</url>
	</repository>
</repositories>
```

## Resize a JPG Image via java Code

Execute below code snippet to see how Aspose.Imaging performs in your environment or check the [GitHub Repository](https://github.com/aspose-imaging/Aspose.Imaging-for-Java) for other common usage scenarios. 

``` java
try (Image image = Image.load(dir + "template.jpg"))
{
    image.resize(300, 300);
    image.save(dir + "output.jpg");
}
```

## Recover a Broken TIFF

You can programmatically recover a damaged TIFF file with the help of Aspose.Imaging for Java API as demonstrated below.

``` java
// create an instance of LoadOptions and set LoadOptions properties
LoadOptions loadOptions = new LoadOptions();
loadOptions.setDataRecoveryMode(DataRecoveryMode.ConsistentRecover);
loadOptions.setDataBackgroundColor(Color.getRed());

// create an instance of Image and load a damaged image by passing the instance of LoadOptions
try (Image image = Image.load(dir + "template.tiff", loadOptions))
{
    // do processing
}
```

[Product Page](https://products.aspose.com/imaging/java) | [Docs](https://docs.aspose.com/display/imagingjava/Home) | [Demos](https://products.aspose.app/imaging/family) | [API Reference](https://apireference.aspose.com/imaging/java) | [Examples](https://github.com/aspose-imaging/Aspose.Imaging-for-Java) | [Blog](https://blog.aspose.com/category/imaging/) | [Free Support](https://forum.aspose.com/c/imaging) | [Temporary License](https://purchase.aspose.com/temporary-license)
