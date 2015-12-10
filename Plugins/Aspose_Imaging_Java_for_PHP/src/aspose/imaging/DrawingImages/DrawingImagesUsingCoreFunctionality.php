<?php
namespace Aspose\Imaging\DrawingImages;

use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\sources\FileCreateSource as FileCreateSource;
use com\aspose\imaging\Image as Image;
use com\aspose\imaging\Color as Color;

class DrawingImagesUsingCoreFunctionality{

    public static function run($dataDir=null){

    # Create an instance of BmpOptions and set its various properties
    $create_options = new BmpOptions();
    $create_options->setBitsPerPixel(24);

    # Create an instance of FileCreateSource and assign it to Source property
    $fileCreateSource=new FileCreateSource();
    $create_options->setSource(new FileCreateSource($dataDir . "sample.bmp",false));

    # Create an instance of RasterImage
    $image=new Image();
    $raster_image = $image->create($create_options,500,500);

    # Get the pixels of the image by specifying the area as image boundary
    $pixels = $raster_image->loadPixels($raster_image->getBounds());

    $index = 0;
    while ($index < sizeof($pixels)) {
        # Set the indexed pixel color to yellow
        $color = new Color();
        $pixels[$index] = $color->getYellow();
        $index += 1;
    }
    $raster_image->savePixels($raster_image->getBounds(), $pixels);

    # save all changes
    $raster_image->save();

    print "Draw Images Using Core Functionality.".PHP_EOL;
    }
}
?>