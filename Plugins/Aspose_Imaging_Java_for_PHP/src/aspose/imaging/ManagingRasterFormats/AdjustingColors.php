<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
class AdjustingColors{

    public static function run($dataDir=null){

        # Adjusting Brightness
        AdjustingColors::adjust_brightness($dataDir);

        # Adjusting Contrast
        AdjustingColors::adjust_contrast($dataDir);

        # Adjusting Contrast
        AdjustingColors::adjust_gamma($dataDir);
    }

    public static function adjust_brightness($dataDir=null){

        # Load an existing image
        $image=new Image();
        $image = $image->load($dataDir . "test.jpg");

        # Check if image is cached
        if (!$image->isCached()) {
        # Cache image if not already cached
        $image->cacheData();
        }

        # Adjust the brightness
        $image->adjustBrightness(70);

        # Save the image to disk
        $image->save($dataDir . "adjust_brightness.jpg");

        # Display Status.
        print "Adjust image brightness successfully!".PHP_EOL;
    }

    public static function adjust_contrast($dataDir=null){

        # Load an existing image
        $image=new Image();
        $image = $image->load($dataDir . "test.jpg");

        # Check if image is cached
        if (!$image->isCached()) {
        # Cache image if not already cached
        $image->cacheData();
        }

        # Adjust the contrast
        $image->adjustContrast(10);

        # Save the image to disk
        $image->save($dataDir . "adjust_contrast.jpg");

        # Display Status.
        print "Adjust image contrast successfully!".PHP_EOL;
        }

        public static function adjust_gamma($dataDir=null){

        # Load an existing image
        $image=new Image();
        $image = $image->load($dataDir . "test.jpg");

        # Check if image is cached
        if (!$image->isCached()) {
            # Cache image if not already cached
            $image->cacheData();
        }

        # Adjust the gamma
        $image->adjustGamma(2.2, 2.2, 2.2);

        # Save the image to disk
        $image->save($dataDir."adjust_gamma.jpg");

        # Display Status.
        print "Adjust image gamma successfully!".PHP_EOL;
    }
}
?>