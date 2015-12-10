<?php
namespace Aspose\Imaging\ManagingPhotoshopFormats;

use com\aspose\imaging\imageoptions\PsdOptions as PsdOptions;
use com\aspose\imaging\sources\FileCreateSource as FileCreateSource;
use com\aspose\imaging\fileformats\psd\ColorModes as ColorModes;
use com\aspose\imaging\Color as Color;
use com\aspose\imaging\fileformats\psd\PsdColorPalette as PsdColorPalette;
use com\aspose\imaging\fileformats\psd\CompressionMethod as CompressionMethod;
use com\aspose\imaging\fileformats\psd\PsdImage as PsdImage;
use com\aspose\imaging\Graphics as Graphics;
use com\aspose\imaging\Pen as Pen;
use com\aspose\imaging\Rectangle as Rectangle;

class CreadPSD{

    public static function run($dataDir=null){

        # Create an instance of PsdOptions and set it's properties
        $create_options = new PsdOptions();

        # Set source
        $create_options->setSource(new FileCreateSource($dataDir . "CreatePSD.psd", false));

        # Set ColorMode to Indexed
        $colorModes=new ColorModes();
        $create_options->setColorMode($colorModes->Indexed);

        # Set PSD file version
        $create_options->setVersion(5);

        $color = new Color();

        # Create a new color patelle having RGB colors
        $palette = [$color->getRed(), $color->getGreen(), $color->getBlue()];

        # Set Palette property to newly created palette
        $create_options->setPalette(new PsdColorPalette($palette));

        # Set compression method
        $compressionMethod=new CompressionMethod();
        $create_options->setCompressionMethod($compressionMethod->RLE);

        # Create a new PSD with PsdOptions created previously
        $psdImage=new PsdImage();
        $psd = $psdImage->create($create_options, 500, 500);

        # Draw some graphics over the newly created PSD
        $graphics = new Graphics($psd);
        $graphics->clear($color->getWhite());
        $graphics->drawEllipse(new Pen($color->getRed(), 6), new Rectangle(0, 0, 400, 400));
        $psd->save();

        # Display Status.
        print "Created PSD successfully!".PHP_EOL;
    }

}
?>