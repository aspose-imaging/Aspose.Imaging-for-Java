module Asposeimagingjava
  module ConvertMetafileToOtherFormats
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load a Metafile in an instance of EmfMetafileImage class
        metafile = Rjb::import('com.aspose.imaging.fileformats.metafile.EmfMetafileImage').new(data_dir + "sample.emf")

        # Save EMF to BMP using BmpOptions object
        metafile.save(data_dir + "EmfToBmp.bmp", Rjb::import('com.aspose.imaging.imageoptions.BmpOptions').new)

        # Save EMF to JPG using JpegOptions object
        metafile.save(data_dir + "EmfToJpg.jpg", Rjb::import('com.aspose.imaging.imageoptions.JpegOptions').new)

        # Save EMF to PNG using PngOptions object
        metafile.save(data_dir + "EmfToPng.png", Rjb::import('com.aspose.imaging.imageoptions.PngOptions').new)

        # Save EMF to GIF using GifOptions object
        metafile.save(data_dir + "EmfToGif.gif", Rjb::import('com.aspose.imaging.imageoptions.GifOptions').new)

        # Save EMF to TIFF using TiffOptions object with default settings 
        metafile.save(data_dir + "EmfToTiff.tiff", Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(Rjb::import('com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat').Default))

        # Display Status.
        puts "Converted EMF to BMP, JPEG, PNG, GIF and TIFF formats successfully!"
    end
  end
end
