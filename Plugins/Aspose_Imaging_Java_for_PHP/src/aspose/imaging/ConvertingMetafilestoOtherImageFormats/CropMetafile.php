<?php
namespace Aspose\Imaging\ConvertingMetafilestoOtherImageFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\Rectangle as Rectangle;
class CropMetafile{

    public static function run($dataDir=null){

        # Load an existing image in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir . "sample1.emf");

        # Create an instance of Rectangle class with desired size
        $rectangle = new Rectangle(10, 10, 100, 100);

        # Perform the crop operation on object of Rectangle class
        $image->crop($rectangle);

        # Save the result in PNG format
        $image->save($dataDir . "CropMetafile.png");

        # Display Status.
        print "Saved crop emf image to PNG successfully!".PHP_EOL;
    }

}
?>