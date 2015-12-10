<?php
namespace Aspose\Imaging\ManagingDjVuFormat;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\PdfOptions as PdfOptions;
use com\aspose\imaging\fileformats\pdf\PdfDocumentInfo as PdfDocumentInfo;
use com\aspose\imaging\imageoptions\DjvuMultiPageOptions as DjvuMultiPageOptions;

class ConvertingDjVuToPdf{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir."demo.djvu");

        # Create an instance of PdfOptions
        $export_options = new PdfOptions();

        # Initialize the metadata for Pdf document
        $export_options->setPdfDocumentInfo(new PdfDocumentInfo());

        # Create an instance of IntRange and initialize it with the range of DjVu pages to be exported
        #range = Rjb::import('com.aspose.imaging.IntRange').new(0, 5) # Export first 5 pages
        $range = array(0,1,2,3,4);

        # Initialize an instance of DjvuMultiPageOptions with range of DjVu pages to be exported
        $export_options->setMultiPageOptions(new DjvuMultiPageOptions($range));

        # Save the result in PDF format
        $image->save($dataDir."djvu.pdf", $export_options);

        # Display Status.
        print "Converted DjVu to PDF successfully!".PHP_EOL;

    }

}
?>