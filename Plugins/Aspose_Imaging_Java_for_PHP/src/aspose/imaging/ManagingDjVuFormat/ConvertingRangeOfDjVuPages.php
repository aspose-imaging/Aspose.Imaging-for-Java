<?php
namespace Aspose\Imaging\ManagingDjVuFormat;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\fileformats\tiff\enums\TiffExpectedFormat as TiffExpectedFormat;
use com\aspose\imaging\imageoptions\TiffOptions as TiffOptions;
use com\aspose\imaging\imageoptions\DjvuMultiPageOptions as DjvuMultiPageOptions;
class ConvertingRangeOfDjVuPages{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir."demo.djvu");

        # Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        $tiff_expected_format = new TiffExpectedFormat();
        $export_options = new TiffOptions($tiff_expected_format->TiffDeflateBW);

        # Create an instance of IntRange and initialize it with range of pages to be exported
        $range = [0,1]; #Export first 2 pages

        # Initialize an instance of DjvuMultiPageOptions
        $export_options->setMultiPageOptions(new DjvuMultiPageOptions($range));

        # Save the result in PDF format
        $image->save($dataDir."PagesRange.tiff", $export_options);

        # Display Status.
        print "Converted range of DjVu pages successfully!".PHP_EOL;
    }

}
?>