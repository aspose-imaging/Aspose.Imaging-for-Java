<?php
namespace Aspose\Imaging\ManagingDjVuFormat;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\imageoptions\DjvuMultiPageOptions as DjvuMultiPageOptions;

class ConvertingRangeOfDjVuPagesToSeparateImages{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir."demo.djvu");

        # Create an instance of BmpOptions
        $export_options = new BmpOptions();

        # Set BitsPerPixel for resultant images
        $export_options->setBitsPerPixel(32);

        # Create an instance of IntRange and initialize it with range of pages to be exported
        $range = [0, 1]; #Export first 2 pages

        $i = 0;
        while ($i < 2) {
        # Save each page in separate file, as BMP do not support layering
        $export_options->setMultiPageOptions(new DjvuMultiPageOptions($i));
        $image->save($dataDir."djvupages#{i}.bmp", $export_options);
        $i+= 1;
        }

        # Display Status.
        print "Converted range of DjVu pages to separate images successfully!".PHP_EOL;
    }

}
?>