<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\ResizeType as ResizeType;
class ResizeImage{

    public static function run($dataDir=null){

        # Simple Resizing
        ResizeImage::simple_image_resizing($dataDir);

        # Resizing with ResizeType Enumeration
        ResizeImage::resizing_with_resizetype_enumeration($dataDir);
    }

    public static function simple_image_resizing($dataDir=null){

    # Load an existing image
    $image=new Image();
    $image = $image->load($dataDir . "test.jpg");

    # Cache data if not cached previously
    if (!$image->isCached()) {
    $image->cacheData();
    }

    # Specify only width
    $new_width = $image->getWidth()/2;
    $image->resizeWidthProportionally($new_width);

    # Specify only height
    $new_height = $image->getHeight()/2;
    $image->resizeHeightProportionally($new_height);

    # Save the image to disk
    $image->save($dataDir . "simple_image_resizing.jpg");

    # Display Status.
    print "Resized image successfully!".PHP_EOL;
    }

    public static function resizing_with_resizetype_enumeration($dataDir=null){

    # Load an existing image
    $image=new Image();
    $image = $image->load($dataDir . "test.jpg");

    # Cache data if not cached previously
    if (!$image->isCached()) {
    $image->cacheData();
    }

    # Specify only width
    $new_width = $image->getWidth()/2;
    $resizeType=new ResizeType();
    $image->resizeWidthProportionally($new_width, $resizeType->LanczosResample);

    # Specify only height
    $new_height = $image->getHeight()/2;
    $image->resizeHeightProportionally($new_height, $resizeType->NearestNeighbourResample);

    # Save the image to disk
    $image->save($dataDir . "resizing_with_resizetype_enumeration.jpg");

    # Display Status.
    print "Resized image successfully!".PHP_EOL;
    }
}
?>