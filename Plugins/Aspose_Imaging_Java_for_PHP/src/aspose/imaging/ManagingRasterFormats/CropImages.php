<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\Rectangle as Rectangle;
class CropImages{

    public static function run($dataDir=null){

        # Cropping by Shifts
        CropImages::crop_by_shifts($dataDir);

        # Cropping by Rectangle
        CropImages::crop_by_rectangle($dataDir);
    }

    public static function crop_by_shifts($dataDir=null){

    # Load an existing image (of type bmp) in an instance of Image class
    $image=new Image();
    $image = $image->load($dataDir."test.jpg");

    # Before cropping, the image should be cached for better performance
    if (!$image->isCached()) {
    $image->cacheData();
    }

    # Define shift values for all four sides
    $left_shift = 10;
    $right_shift = 10;
    $top_shift = 10;
    $bottom_shift = 10;

    # Based on the shift values, apply the cropping on image
    # Crop method will shift the image bounds toward the center of image
    $image->crop($left_shift, $right_shift, $top_shift, $bottom_shift);

    # Save the image to disk
    $image->save($dataDir . "CropByShifts.jpg");

    # Display Status.
    print "Cropped image by shifts successfully!".PHP_EOL;
    }

    public static function crop_by_rectangle($dataDir=null){

    # Load an existing image (of type bmp) in an instance of Image class
    $image=new Image();
    $image = $image->load($dataDir . "test.jpg");

    # Before cropping, the image should be cached for better performance
    if (!$image->isCached()) {
    $image->cacheData();
    }

    # Create an instance of Rectangle class with desired size
    $rectangle = new Rectangle(10, 10, 100, 100);

    # Perform the crop operation on object of Rectangle class
    $image->crop($rectangle);

    # Save the image to disk
    $image->save($dataDir . "crop_by_rectangle.jpg");

    # Display Status.
    print "Cropped image by rectangle successfully!".PHP_EOL;

    }

}
?>