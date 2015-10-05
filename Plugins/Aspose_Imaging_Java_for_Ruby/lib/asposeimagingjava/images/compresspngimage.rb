module Asposeimagingjava
  module CompressPngImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "sample.png")

        # Create an instance of PngOptions
        options = Rjb::import('com.aspose.imaging.imageoptions.PngOptions').new
        
        # Set CompressionLevel
        options.setCompressionLevel(1)

        # Save the result on disc
        image.save(data_dir + "compress.png", options)

        # Display Status.
        puts "Compressed PNG image successfully!"
    end
  end
end
