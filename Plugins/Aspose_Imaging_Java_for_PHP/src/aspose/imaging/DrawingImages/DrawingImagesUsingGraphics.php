<?php
namespace Aspose\Imaging\DrawingImages;

use com\aspose\imaging\imageoptions\BmpOptions as BmpOptions;
use com\aspose\imaging\sources\FileCreateSource as FileCreateSource;
use com\aspose\imaging\Image as Image;
use com\aspose\imaging\Graphics as Graphics;
use com\aspose\imaging\Color as Color;
use com\aspose\imaging\Pen as Pen;
use com\aspose\imaging\Rectangle as Rectangle;

class DrawingImagesUsingGraphics{

    public static function run($dataDir=null){


        # Create an instance of BmpOptions and set its various properties
        $create_options = new BmpOptions();
        $create_options->setBitsPerPixel(24);

        # Create an instance of FileCreateSource and assign it to Source property
        $create_options->setSource(new FileCreateSource($dataDir . "DrawingImageUsingGraphics.bmp",false));

        # Create an instance of Image
        $image=new Image();
        $image = $image->create($create_options,500,500);

        # Create and initialize an instance of Graphics
        $graphics = new Graphics($image);

        # Clear the image surface with white color
        $color=new Color();
        $graphics->clear($color->getWhite());

        # Create and initialize a Pen object with blue color
        $pen = new Pen($color->getBlue());

        # Draw Ellipse by defining the bounding rectangle of width 150 and height 100
        $graphics->drawEllipse($pen, new Rectangle(10, 10, 150, 100));

        # save all changes
        $image->save();
        print "Created image using graphics.".PHP_EOL;
    }
}