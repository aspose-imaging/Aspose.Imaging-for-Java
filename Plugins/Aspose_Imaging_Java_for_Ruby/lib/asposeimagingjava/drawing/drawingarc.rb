module Asposeimagingjava
  module DrawingArc
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of BmpOptions and set its various properties
        create_options = Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new
        create_options.setBitsPerPixel(32)

        # Define the source property for the instance of BmpOptions
        create_options.setSource(Rjb::import('com.aspose.imaging.sources.StreamSource').new(Rjb::import('java.io.ByteArrayInputStream').new(Array.new)))

        # Create an instance of Image
        image = Rjb::import('com.aspose.imaging.Image').create(create_options,100,100)

        # Create an instance of Color
        color = Rjb::import('com.aspose.imaging.Color')

        # Create an instance of Pen
        pen = Rjb::import('com.aspose.imaging.Pen')

        # Create and initialize an instance of Graphics class
        graphic = Rjb::import('com.aspose.imaging.Graphics').new(image)

        # Clear the image surface with Yellow color
        graphic.clear(color.getYellow())

        # Draw arc to screen.
        graphic.drawArc(pen.new(color.getBlack()), 0, 0, 100, 200, 45, 270)

        # Save all changes.
        image.save(data_dir + "DrawArcExample.bmp")

        puts "Arc have been drawn in image successfully!"
    end
  end
end
