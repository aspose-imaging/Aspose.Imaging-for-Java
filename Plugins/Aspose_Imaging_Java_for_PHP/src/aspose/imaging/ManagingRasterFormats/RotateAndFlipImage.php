<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\RotateFlipType as RotateFlipType;
class RotateAndFlipImage{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir . "test.jpg");

        $rotateFlipType=new RotateFlipType();
        $image->rotateFlip($rotateFlipType->Rotate270FlipNone);

        # Save the image to disk
        $image->save($dataDir . "RotateFlip.jpg");

        # Display Status.
        print "RotateFlip image successfully!".PHP_EOL;
    }
}
?>