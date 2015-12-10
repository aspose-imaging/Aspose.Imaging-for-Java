<?php
namespace Aspose\Imaging\ManagingDjVuFormat;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\TiffOptions as TiffOptions;
use com\aspose\imaging\fileformats\tiff\enums\TiffExpectedFormat as TiffExpectedFormat;
use com\aspose\imaging\imageoptions\DjvuMultiPageOptions as DjvuMultiPageOptions;

class ConvertingDjVuToTiff{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir . "Sample.djvu");

        # Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        $tiff_expected_format = new TiffExpectedFormat();
        $export_options = new TiffOptions($tiff_expected_format->TiffDeflateBW);

        # Initialize an instance of DjvuMultiPageOptions
        $export_options->setMultiPageOptions(new DjvuMultiPageOptions());

        # Save the result in PDF format
        $image->save($dataDir."djvu.tiff", $export_options);

        # Display Status.
        print "Converted DjVu to Tiff successfully!".PHP_EOL;
    }
}
?>