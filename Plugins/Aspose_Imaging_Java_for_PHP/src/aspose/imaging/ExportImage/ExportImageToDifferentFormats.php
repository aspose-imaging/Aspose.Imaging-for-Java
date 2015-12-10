<?php
namespace Aspose\Imaging\ExportImage;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\imageoptions\JpegOptions as JpegOptions;
use com\aspose\imaging\imageoptions\PngOptions as PngOptions;
use com\aspose\imaging\imageoptions\TiffOptions as TiffOptions;
use com\aspose\imaging\fileformats\tiff\enums\TiffExpectedFormat as TiffExpectedFormat;

class ExportImageToDifferentFormats{

    public static function run($dataDir=null)
    {
        # Load an existing image (of type Gif) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir . "sample.gif");

        # Export to BMP file format using the default options
        $bmpOptions=new BmpOptions();
        $image->save($dataDir . "output.bmp",new BmpOptions());

        # Export to JPEG file format using the default options
        $image->save($dataDir . "output.jpg", new JpegOptions());

        # Export to PNG file format using the default options
        $image->save($dataDir . "output.png", new PngOptions());

        # Export to TIFF file format using the default options
        $tiffExpectedFormat=new TiffExpectedFormat();
        $image->save($dataDir . "output.tiff", new TiffOptions($tiffExpectedFormat->Default));

        print "Saved images.".PHP_EOL;
        }
    }
?>