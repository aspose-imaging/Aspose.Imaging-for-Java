module Asposeimagingjava
  module ConvertingDjVuToTiff
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.djvu")

        # Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        tiff_expected_format = Rjb::import('com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat')
        export_options = Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(tiff_expected_format.TiffDeflateBW)
        
        # Initialize an instance of DjvuMultiPageOptions 
        export_options.setMultiPageOptions(Rjb::import('com.aspose.imaging.imageoptions.DjvuMultiPageOptions').new)
        
        # Save the result in PDF format
        image.save(data_dir + "djvu.tiff", export_options)

        # Display Status.
        puts "Converted DjVu to Tiff successfully!"
    end
  end
end
