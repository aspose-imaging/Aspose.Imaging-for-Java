module Asposeimagingjava
  module RotateAndFlipImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        image.rotateFlip(Rjb::import('com.aspose.imaging.RotateFlipType').Rotate270FlipNone)

        # Save the image to disk
        image.save(data_dir + "RotateFlip.jpg")

        # Display Status.
        puts "RotateFlip image successfully!"
    end
  end
end
