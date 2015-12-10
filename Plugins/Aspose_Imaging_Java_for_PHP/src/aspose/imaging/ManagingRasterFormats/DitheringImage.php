<?php
namespace Aspose\Imaging\ManagingRasterFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\DitheringMethod as DitheringMethod;
class DitheringImage{

    public static function run($dataDir=null){

        # Load an existing image
        $image=new Image();
        $image = $image->load($dataDir . "test.jpg");

        # Perform Floyd Steinberg dithering on the current image
        $ditheringMethod=new DitheringMethod();
        $image->dither($ditheringMethod->ThresholdDithering, 4);

        # Save the image to disk
        $image->save($dataDir . "DitheringImage.jpg");

        # Display Status.
        print "Dithering image successfully!".PHP_EOL;
    }

}
?>