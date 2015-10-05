module Asposeimagingjava
  module CreadPSD
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of PsdOptions and set it's properties
        create_options = Rjb::import('com.aspose.imaging.imageoptions.PsdOptions').new
        
        # Set source
        create_options.setSource(Rjb::import('com.aspose.imaging.sources.FileCreateSource').new(data_dir + "CreatePSD.psd", false))
        
        # Set ColorMode to Indexed
        create_options.setColorMode(Rjb::import('com.aspose.imaging.fileformats.psd.ColorModes').Indexed)
        
        # Set PSD file version
        create_options.setVersion(5)
        
        color = Rjb::import('com.aspose.imaging.Color')

        # Create a new color patelle having RGB colors
        palette = [color.getRed(), color.getGreen(), color.getBlue()]
        
        # Set Palette property to newly created palette
        create_options.setPalette(Rjb::import('com.aspose.imaging.fileformats.psd.PsdColorPalette').new(palette))
        
        # Set compression method
        create_options.setCompressionMethod(Rjb::import('com.aspose.imaging.fileformats.psd.CompressionMethod').RLE)
                    
        # Create a new PSD with PsdOptions created previously
        psd = Rjb::import('com.aspose.imaging.fileformats.psd.PsdImage').create(create_options, 500, 500)
        
        # Draw some graphics over the newly created PSD
        graphics = Rjb::import('com.aspose.imaging.Graphics').new(psd)
        graphics.clear(color.getWhite())
        graphics.drawEllipse(Rjb::import('com.aspose.imaging.Pen').new(color.getRed(), 6), Rjb::import('com.aspose.imaging.Rectangle').new(0, 0, 400, 400))
        psd.save()

        # Display Status.
        puts "Created PSD successfully!"
    end
  end
end
