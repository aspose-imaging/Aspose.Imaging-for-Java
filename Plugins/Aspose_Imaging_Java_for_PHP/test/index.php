<?php

require_once("../../java/Java.inc");

require_once __DIR__ . '/../vendor/autoload.php'; // Autoload files using Composer autoload

use Aspose\Imaging\ConvertingMetafilestoOtherImageFormats\ConvertMetafileToOtherFormats;
use Aspose\Imaging\ConvertingMetafilestoOtherImageFormats\CropMetafile;

use Aspose\Imaging\DrawingImages\DrawingArc;
use Aspose\Imaging\DrawingImages\DrawingEllipse;
use Aspose\Imaging\DrawingImages\DrawingImagesUsingCoreFunctionality;
use Aspose\Imaging\DrawingImages\DrawingImagesUsingGraphics;
use Aspose\Imaging\DrawingImages\DrawingLines;
use Aspose\Imaging\DrawingImages\DrawingRectangle;

use Aspose\Imaging\ExportImage\ExportImageToDifferentFormats;

use Aspose\Imaging\ManagingDjVuFormat\ConvertingDjVuToPdf;
use Aspose\Imaging\ManagingDjVuFormat\ConvertingDjVuToTiff;
use Aspose\Imaging\ManagingDjVuFormat\ConvertingRangeOfDjVuPages;
use Aspose\Imaging\ManagingDjVuFormat\ConvertingRangeOfDjVuPagesToSeparateImages;
use Aspose\Imaging\ManagingDjVuFormat\ConvertingSpecificPortionOfDjvuPage;

use Aspose\Imaging\ManagingPhotoshopFormats\CreadPSD;
use Aspose\Imaging\ManagingPhotoshopFormats\ExportImageToPSD;

use Aspose\Imaging\ManagingRasterFormats\AdjustingColors;
use Aspose\Imaging\ManagingRasterFormats\ConvertingRasterImages;
use Aspose\Imaging\ManagingRasterFormats\CropImages;
use Aspose\Imaging\ManagingRasterFormats\DitheringImage;
use Aspose\Imaging\ManagingRasterFormats\ResizeImage;
use Aspose\Imaging\ManagingRasterFormats\RotateAndFlipImage;


//print "Running Aspose\\Imaging\\ConvertingMetafilestoOtherImageFormats\\ConvertMetafileToOtherFormats::run()" . PHP_EOL;
//ConvertMetafileToOtherFormats::run(__DIR__ . '/data/ConvertingMetafilestoOtherImageFormats/ConvertMetafileToOtherFormats/');
//
//print "Running Aspose\\Imaging\\ConvertingMetafilestoOtherImageFormats\\CropMetafile::run()" . PHP_EOL;
//CropMetafile::run(__DIR__ . '/data/ConvertingMetafilestoOtherImageFormats/CropMetafile/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingArc::run()" . PHP_EOL;
//DrawingArc::run(__DIR__ . '/data/DrawingImages/DrawingArc/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingEllipse::run()" . PHP_EOL;
//DrawingEllipse::run(__DIR__ . '/data/DrawingImages/DrawingEllipse/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingImagesUsingCoreFunctionality::run()" . PHP_EOL;
//DrawingImagesUsingCoreFunctionality::run(__DIR__ . '/data/DrawingImages/DrawingImagesUsingCoreFunctionality/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingImagesUsingGraphics::run()" . PHP_EOL;
//DrawingImagesUsingGraphics::run(__DIR__ . '/data/DrawingImages/DrawingImagesUsingGraphics/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingLines::run()" . PHP_EOL;
//DrawingLines::run(__DIR__ . '/data/DrawingImages/DrawingLines/');
//
//print "Running Aspose\\Imaging\\DrawingImages\\DrawingRectangle::run()" . PHP_EOL;
//DrawingRectangle::run(__DIR__ . '/data/DrawingImages/DrawingRectangle/');
//
//print "Running Aspose\\Imaging\\ExportImage\\ExportImageToDifferentFormats::run()" . PHP_EOL;
//ExportImageToDifferentFormats::run(__DIR__ . '/data/ExportImage/ExportImageToDifferentFormats/');
//
//print "Running Aspose\\Imaging\\ManagingDjVuFormat\\ConvertingDjVuToPdf::run()" . PHP_EOL;
//ConvertingDjVuToPdf::run(__DIR__ . '/data/ManagingDjVuFormat/ConvertingDjVuToPdf/');
//
//print "Running Aspose\\Imaging\\ManagingDjVuFormat\\ConvertingDjVuToTiff::run()" . PHP_EOL;
//ConvertingDjVuToTiff::run(__DIR__ . '/data/ManagingDjVuFormat/ConvertingDjVuToTiff/');
//
//print "Running Aspose\\Imaging\\ManagingDjVuFormat\\ConvertingRangeOfDjVuPages::run()" . PHP_EOL;
//ConvertingRangeOfDjVuPages::run(__DIR__ . '/data/ManagingDjVuFormat/ConvertingRangeOfDjVuPages/');
//
//print "Running Aspose\\Imaging\\ManagingDjVuFormat\\ConvertingRangeOfDjVuPagesToSeparateImages::run()" . PHP_EOL;
//ConvertingRangeOfDjVuPagesToSeparateImages::run(__DIR__ . '/data/ManagingDjVuFormat/ConvertingRangeOfDjVuPagesToSeparateImages/');
//
//print "Running Aspose\\Imaging\\ManagingDjVuFormat\\ConvertingSpecificPortionOfDjvuPage::run()" . PHP_EOL;
//ConvertingSpecificPortionOfDjvuPage::run(__DIR__ . '/data/ManagingDjVuFormat/ConvertingSpecificPortionOfDjvuPage/');
//
//print "Running Aspose\\Imaging\\ManagingPhotoshopFormats\\CreadPSD::run()" . PHP_EOL;
//CreadPSD::run(__DIR__ . '/data/ManagingPhotoshopFormats/CreadPSD/');
//
//print "Running Aspose\\Imaging\\ManagingPhotoshopFormats\\ExportImageToPSD::run()" . PHP_EOL;
//ExportImageToPSD::run(__DIR__ . '/data/ManagingPhotoshopFormats/ExportImageToPSD/');
//
//print "Running Aspose\\Imaging\\ManagingRasterFormats\\AdjustingColors::run()" . PHP_EOL;
//AdjustingColors::run(__DIR__ . '/data/ManagingRasterFormats/AdjustingColors/');
//
//print "Running Aspose\\Imaging\\ManagingRasterFormats\\ConvertingRasterImages::run()" . PHP_EOL;
//ConvertingRasterImages::run(__DIR__ . '/data/ManagingRasterFormats/ConvertingRasterImages/');
//
//print "Running Aspose\\Imaging\\ManagingRasterFormats\\CropImages::run()" . PHP_EOL;
//CropImages::run(__DIR__ . '/data/ManagingRasterFormats/CropImages/');
//
//print "Running Aspose\\Imaging\\ManagingRasterFormats\\DitheringImage::run()" . PHP_EOL;
//DitheringImage::run(__DIR__ . '/data/ManagingRasterFormats/DitheringImage/');

print "Running Aspose\\Imaging\\ManagingRasterFormats\\ResizeImage::run()" . PHP_EOL;
ResizeImage::run(__DIR__ . '/data/ManagingRasterFormats/ResizeImage/');

print "Running Aspose\\Imaging\\ManagingRasterFormats\\RotateAndFlipImage::run()" . PHP_EOL;
RotateAndFlipImage::run(__DIR__ . '/data/ManagingRasterFormats/RotateAndFlipImage/');
