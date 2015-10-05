module Asposeimagingjava
  module ConvertingSpecificPortionOfDjvuPage
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.djvu")

        # Create an instance of PngOptions
        export_options = Rjb::import('com.aspose.imaging.imageoptions.PngOptions').new

        # Set ColorType to Grayscale
        export_options.setColorType(Rjb::import('com.aspose.imaging.fileformats.png.PngColorType').Grayscale)

        # Create an instance of Rectangle and specify the portion on DjVu page
        export_area = Rjb::import('com.aspose.imaging.Rectangle').new(20, 20, 500, 500)
        
        # Specify the DjVu page index
        export_page_index = 2

        # Initialize an instance of DjvuMultiPageOptions
        # while passing index of DjVu page index and instance of Rectangle covering the area to be exported
        export_options.setMultiPageOptions(Rjb::import('com.aspose.imaging.imageoptions.DjvuMultiPageOptions').new(export_page_index, export_area))
        
        # Save the result in PDF format
        image.save(data_dir + "SpecificPagePortion.png", export_options)

        # Display Status.
        puts "Converted specific page portion DjVu page to image successfully!"
    end
  end
end
