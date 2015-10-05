module Asposeimagingjava
  module DitheringImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Perform Floyd Steinberg dithering on the current image
        image.dither(Rjb::import('com.aspose.imaging.DitheringMethod').ThresholdDithering, 4)

        # Save the image to disk
        image.save(data_dir + "DitheringImage.jpg")

        # Display Status.
        puts "Dithering image successfully!"
    end
  end
end
