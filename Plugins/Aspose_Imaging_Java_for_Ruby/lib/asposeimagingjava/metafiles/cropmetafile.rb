module Asposeimagingjava
  module CropMetafile
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "sample.emf")

        # Create an instance of Rectangle class with desired size
        rectangle = Rjb::import('com.aspose.imaging.Rectangle').new(10, 10, 100, 100)

        # Perform the crop operation on object of Rectangle class
        image.crop(rectangle)

        # Save the result in PNG format
        image.save(data_dir + "CropMetafile.png")

        # Display Status.
        puts "Saved crop emf image to PNG successfully!"
    end
  end
end
