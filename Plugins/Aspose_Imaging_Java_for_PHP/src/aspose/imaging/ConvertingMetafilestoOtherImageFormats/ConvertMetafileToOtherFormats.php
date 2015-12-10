<?php
namespace Aspose\Imaging\ConvertingMetafilestoOtherImageFormats;

use com\aspose\imaging\fileformats\metafile\EmfMetafileImage as EmfMetafileImage;
use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\imageoptions\JpegOptions as JpegOptions;
use com\aspose\imaging\imageoptions\PngOptions as PngOptions;
use com\aspose\imaging\imageoptions\GifOptions as GifOptions;
use com\aspose\imaging\imageoptions\TiffOptions as TiffOptions;
use com\aspose\imaging\fileformats\tiff\enums\TiffExpectedFormat as TiffExpectedFormat;

class ConvertMetafileToOtherFormats{

    public static function run($dataDir=null){

        # Load a Metafile in an instance of EmfMetafileImage class
        $metafile = new EmfMetafileImage($dataDir . "sample1.emf");

        # Save EMF to BMP using BmpOptions object
        $metafile->save($dataDir . "EmfToBmp.bmp", new BmpOptions());

        # Save EMF to JPG using JpegOptions object
        $metafile->save($dataDir . "EmfToJpg.jpg", new JpegOptions());

        # Save EMF to PNG using PngOptions object
        $metafile->save($dataDir . "EmfToPng.png", new PngOptions());

        # Save EMF to GIF using GifOptions object
        $metafile->save($dataDir . "EmfToGif.gif", new GifOptions());

        # Save EMF to TIFF using TiffOptions object with default settings
        $tiffExpectedFormat=new TiffExpectedFormat();
        $metafile->save($dataDir . "EmfToTiff.tiff", new TiffOptions($tiffExpectedFormat->Default));

        # Display Status.
        print "Converted EMF to BMP, JPEG, PNG, GIF and TIFF formats successfully!".PHP_EOL;
    }

}

?>