module Asposeimagingjava
  module ExportImageToDifferentFormats
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type Gif) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "sample.gif")

        # Export to BMP file format using the default options
        image.save(data_dir + "output.bmp" , Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new)

        # Export to JPEG file format using the default options
        image.save(data_dir + "output.jpg", Rjb::import('com.aspose.imaging.imageoptions.JpegOptions').new)

        # Export to PNG file format using the default options
        image.save(data_dir + "output.png", Rjb::import('com.aspose.imaging.imageoptions.PngOptions').new)

        # Export to TIFF file format using the default options
        image.save(data_dir + "output.tiff", Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(Rjb::import('com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat').Default))

        puts "Saved images."
    end
  end
end
