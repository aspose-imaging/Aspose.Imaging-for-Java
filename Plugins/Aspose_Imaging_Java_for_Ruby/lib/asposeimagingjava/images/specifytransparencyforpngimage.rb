module Asposeimagingjava
  module SpecifyTransparencyForPngImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "sample.png")

        # Store the width & height in variables for later use
        width = image.getWidth()
        height = image.getHeight()

        # Load the pixels of RasterImage into the array of type Color
        pixels = image.loadPixels(Rjb::import('com.aspose.imaging.Rectangle').new(0, 0, width, height))

        # Create & initialize an instance of PngImage while specifying size and PngColorType
        png = Rjb::import('com.aspose.imaging.fileformats.png.PngImage').new(width, height, Rjb::import('com.aspose.imaging.fileformats.png.PngColorType').TruecolorWithAlpha)
        
        # Save the previously loaded pixels on to the new PngImage
        png.savePixels(Rjb::import('com.aspose.imaging.Rectangle').new(0, 0, width, height), pixels)

        # Set TransparentColor property to specify which color to be rendered as transparent
        png.setTransparentColor(Rjb::import('com.aspose.imaging.Color').getBlack())

        # Save the result on disc
        png.save(data_dir + "specify_transparency.png")

        # Display Status.
        puts "Specified transparency for PNG image successfully!"
    end
  end
end
