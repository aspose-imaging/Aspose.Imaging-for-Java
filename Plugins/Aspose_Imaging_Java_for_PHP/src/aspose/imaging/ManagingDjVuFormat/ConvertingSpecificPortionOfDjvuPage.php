<?php
namespace Aspose\Imaging\ManagingDjVuFormat;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\PngOptions as PngOptions;
use com\aspose\imaging\fileformats\png\PngColorType as PngColorType;
use com\aspose\imaging\Rectangle as Rectangle;
use com\aspose\imaging\imageoptions\DjvuMultiPageOptions as DjvuMultiPageOptions;
class ConvertingSpecificPortionOfDjvuPage{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir."demo.djvu");

        # Create an instance of PngOptions
        $export_options = new PngOptions();

        # Set ColorType to Grayscale
        $pngColorType=new PngColorType();
        $export_options->setColorType($pngColorType->Grayscale);

        # Create an instance of Rectangle and specify the portion on DjVu page
        $export_area = new Rectangle(20, 20, 500, 500);

        # Specify the DjVu page index
        $export_page_index = 2;

        # Initialize an instance of DjvuMultiPageOptions
        # while passing index of DjVu page index and instance of Rectangle covering the area to be exported
        $export_options->setMultiPageOptions(new DjvuMultiPageOptions($export_page_index, $export_area));

        # Save the result in PDF format
        $image->save($dataDir."SpecificPagePortion.png", $export_options);

        # Display Status.
        print "Converted specific page portion DjVu page to image successfully!".PHP_EOL;
    }

}
?>