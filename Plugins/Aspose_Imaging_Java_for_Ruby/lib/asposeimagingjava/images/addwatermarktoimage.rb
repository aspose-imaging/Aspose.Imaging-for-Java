module Asposeimagingjava
  module AddWatermarkToImage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "aspose.bmp")

        # Create and initialize an instance of Graphics
        graphics = Rjb::import('com.aspose.imaging.Graphics').new(image)

        # Creates an instance of Font
        font = Rjb::import('com.aspose.imaging.Font').new("Times New Roman", 16, Rjb::import('com.aspose.imaging.FontStyle').Bold)

        # Create an instance of SolidBrush and set its various properties.
        brush = Rjb::import('com.aspose.imaging.brushes.SolidBrush').new
        brush.setColor(Rjb::import('com.aspose.imaging.Color').getBlack())
        brush.setOpacity(100)

        # Draw a String using the SolidBrush object and Font, at specific Point.
        graphics.drawString("Aspose.Imaging for Ruby", font, brush, Rjb::import('com.aspose.imaging.PointF').new(image.getWidth()-100, image.getHeight()-100))

        # save the image with changes
        image.save(data_dir + "out.bmp")

        # Display Status.
        puts "Watermark added successfully!"      
    end
  end
end
