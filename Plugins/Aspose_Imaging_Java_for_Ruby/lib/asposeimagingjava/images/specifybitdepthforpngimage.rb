module Asposeimagingjava
  module SpecifyBitdepthForPngImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "sample.png")

        # Create an instance of PngOptions
        options = Rjb::import('com.aspose.imaging.imageoptions.PngOptions').new
        
        # Set the desired ColorType
        options.setColorType(Rjb::import('com.aspose.imaging.fileformats.png.PngColorType').Grayscale)
                      
        # Set the BitDepth according to the specified ColorType
        options.setBitDepth(1)

        # Save the result on disc
        image.save(data_dir + "specify_bitdepth.png", options)

        # Display Status.
        puts "Specified bit depth for PNG image successfully!"
    end
  end
end
