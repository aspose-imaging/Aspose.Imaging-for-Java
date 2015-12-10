<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
class ConvertingRasterImages{

    public static function run($dataDir=null){

        # Binarization with Fixed Threshold
        ConvertingRasterImages::binarization_with_fixed_threshold($dataDir);

        # Binarization with Otsu Threshold
        ConvertingRasterImages::binarization_with_otsu_threshold($dataDir);

        # Transform image to its grayscale representation
        ConvertingRasterImages::transform_image_to_grayscale($dataDir);
    }

    public static function binarization_with_fixed_threshold($dataDir=null){

        $image=new Image();
        $image = $image->load($dataDir."test.jpg");


        # Check if image is cached
        if (!$image->isCached()) {
        # Cache image if not already cached
        $image->cacheData();
        }

        # Binarize image with predefined fixed threshold
        $image->binarizeFixed(100);

        # Save the image to disk
        $image->save($dataDir . "binarization_with_fixed_threshold.jpg");

        # Display Status.
        print "Binarization image with Fixed Threshold successfully!".PHP_EOL;
    }

    public static function binarization_with_otsu_threshold($dataDir=null)
    {

        # Load an existing image
        $image = new Image();
        $image = $image->load($dataDir."test.jpg");

        # Check if image is cached
        if (!$image->isCached()) {
        # Cache image if not already cached
        $image->cacheData();
        }

        # Binarize image with Otsu Thresholding
        $image->binarizeOtsu();

        # Save the image to disk
        $image->save($dataDir."binarization_with_otsu_threshold.jpg");

        # Display Status.
        print "Binarization image with Otsu Threshold successfully!".PHP_EOL;
    }

    public static function transform_image_to_grayscale($dataDir=null){

        # Load an existing image
        $image=new Image();
        $image = $image->load($dataDir."test.jpg");

        # Check if image is cached
        if (!$image->isCached()) {
        # Cache image if not already cached
        $image->cacheData();
        }

        # Transform image to its grayscale representation
        $image->grayscale();

        # Save the image to disk
        $image->save($dataDir."transform_image_to_grayscale.jpg");

        # Display Status.
        print "Transform image to its grayscale representation successfully!".PHP_EOL;
    }
}
?>