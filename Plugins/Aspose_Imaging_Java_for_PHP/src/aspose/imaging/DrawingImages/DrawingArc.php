<?php
namespace Aspose\Imaging\DrawingImages;

use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\sources\StreamSource as StreamSource;
use com\aspose\imaging\Image as Image;
use com\aspose\imaging\Color as Color;
use com\aspose\imaging\Pen as Pen;
use com\aspose\imaging\Graphics as Graphics;

use java\io\ByteArrayInputStream as ByteArrayInputStream;
class DrawingArc{

    public static function run($dataDir=null){

        # Create an instance of BmpOptions and set its various properties
        $create_options = new BmpOptions();
        $create_options->setBitsPerPixel(32);

        # Define the source property for the instance of BmpOptions
        $ary=array();
        $create_options->setSource(new StreamSource(new ByteArrayInputStream($ary)));

        # Create an instance of Image
        $image=new Image();
        $image = $image->create($create_options,100,100);

        # Create an instance of Color
        $color = new Color();

        # Create an instance of Pen
        $pen = new Pen();

        # Create and initialize an instance of Graphics class
        $graphic = new Graphics($image);

        # Clear the image surface with Yellow color
        $graphic->clear($color->getYellow());

        # Draw arc to screen.
        $graphic->drawArc(new Pen($color->getBlack()), 0, 0, 100, 200, 45, 270);

        # Save all changes.
        $image->save($dataDir . "DrawArcExample.bmp");
        print "Arc have been drawn in image successfully!".PHP_EOL;
    }
}
?>