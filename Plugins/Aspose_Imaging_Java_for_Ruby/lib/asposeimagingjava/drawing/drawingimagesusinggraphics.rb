module Asposeimagingjava
  module DrawingImagesUsingGraphics
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of BmpOptions and set its various properties
        create_options = Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new
        create_options.setBitsPerPixel(24)

        # Create an instance of FileCreateSource and assign it to Source property
        create_options.setSource(Rjb::import('com.aspose.imaging.sources.FileCreateSource').new(data_dir + "DrawingImageUsingGraphics.bmp",false))

        # Create an instance of Image
        image = Rjb::import('com.aspose.imaging.Image').create(create_options,500,500)

        # Create and initialize an instance of Graphics
        graphics = Rjb::import('com.aspose.imaging.Graphics').new(image)

        # Clear the image surface with white color
        graphics.clear(Rjb::import('com.aspose.imaging.Color').getWhite())

        # Create and initialize a Pen object with blue color
        pen = Rjb::import('com.aspose.imaging.Pen').new(Rjb::import('com.aspose.imaging.Color').getBlue())

        # Draw Ellipse by defining the bounding rectangle of width 150 and height 100
        graphics.drawEllipse(pen, Rjb::import('com.aspose.imaging.Rectangle').new(10, 10, 150, 100))

        # save all changes
        image.save()

        puts "Created image using graphics."
    end
  end
end
