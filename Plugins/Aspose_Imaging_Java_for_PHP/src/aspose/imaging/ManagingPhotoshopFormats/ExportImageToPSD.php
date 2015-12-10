<?php
namespace Aspose\Imaging\ManagingPhotoshopFormats;

use com\aspose\imaging\Image as Image;
use com\aspose\imaging\imageoptions\PsdOptions as PsdOptions;
use com\aspose\imaging\fileformats\psd\CompressionMethod as CompressionMethod;
use com\aspose\imaging\fileformats\psd\ColorModes as ColorModes;
class ExportImageToPSD{

    public static function run($dataDir=null){

        # Load an existing image (of type bmp) in an instance of Image class
        $image=new Image();
        $image = $image->load($dataDir."aspose.bmp");

        # Create an instance of PsdSaveOptions class
        $save_options = new PsdOptions();

        # Set the CompressionMethod as Raw
        # Note: Other supported CompressionMethod is CompressionMethod.Rle [No Compression]
        $compressionMethod=new CompressionMethod();
        $save_options->setCompressionMethod($compressionMethod->Raw);

        # Set the ColorMode to GrayScale//Note: Other supported ColorModes are ColorModes.Bitmap and ColorModes.RGB
        $colorModes=new ColorModes();
        $save_options->setColorMode($colorModes->RGB);

        # Save the image to disk location with supplied PsdOptions settings
        $image->save($dataDir."output.psd", $save_options);

        # Display Status.
        print "Image exported to PSD successfully!".PHP_EOL;
    }

}

?>