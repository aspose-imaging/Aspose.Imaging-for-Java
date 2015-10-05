module Asposeimagingjava
  module ConvertingRangeOfDjVuPages
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.djvu")

        # Create an instance of TiffOptions & use preset options for Black n While with Deflate compression
        tiff_expected_format = Rjb::import('com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat')
        export_options = Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(tiff_expected_format.TiffDeflateBW)

        # Create an instance of IntRange and initialize it with range of pages to be exported
        range = [0, 1] #Export first 2 pages
        
        # Initialize an instance of DjvuMultiPageOptions 
        export_options.setMultiPageOptions(Rjb::import('com.aspose.imaging.imageoptions.DjvuMultiPageOptions').new(range))
        
        # Save the result in PDF format
        image.save(data_dir + "PagesRange.tiff", export_options)

        # Display Status.
        puts "Converted range of DjVu pages successfully!"
    end
  end
end
