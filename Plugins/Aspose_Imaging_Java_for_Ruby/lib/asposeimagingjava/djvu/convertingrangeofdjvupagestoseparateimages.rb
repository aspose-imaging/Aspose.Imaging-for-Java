module Asposeimagingjava
  module ConvertingRangeOfDjVuPagesToSeparateImages
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.djvu")

        # Create an instance of BmpOptions
        export_options = Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new

        # Set BitsPerPixel for resultant images
        export_options.setBitsPerPixel(32)

        # Create an instance of IntRange and initialize it with range of pages to be exported
        range = [0, 1] #Export first 2 pages

        i = 0
        while i < 2
            # Save each page in separate file, as BMP do not support layering
            export_options.setMultiPageOptions(Rjb::import('com.aspose.imaging.imageoptions.DjvuMultiPageOptions').new(i))
            image.save(data_dir + "djvupages#{i}.bmp", export_options)
            i +=1
        end    

        # Display Status.
        puts "Converted range of DjVu pages to separate images successfully!"
    end
  end
end
