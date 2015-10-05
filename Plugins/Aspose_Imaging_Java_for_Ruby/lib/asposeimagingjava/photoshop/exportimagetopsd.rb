module Asposeimagingjava
  module ExportImageToPSD
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "aspose.bmp")

        # Create an instance of PsdSaveOptions class
        save_options = Rjb::import('com.aspose.imaging.imageoptions.PsdOptions').new

        # Set the CompressionMethod as Raw
        # Note: Other supported CompressionMethod is CompressionMethod.Rle [No Compression]
        save_options.setCompressionMethod(Rjb::import('com.aspose.imaging.fileformats.psd.CompressionMethod').Raw)

        # Set the ColorMode to GrayScale//Note: Other supported ColorModes are ColorModes.Bitmap and ColorModes.RGB
        save_options.setColorMode(Rjb::import('com.aspose.imaging.fileformats.psd.ColorModes').RGB)

        # Save the image to disk location with supplied PsdOptions settings
        image.save(data_dir + "output.psd", save_options)

        # Display Status.
        puts "Image exported to PSD successfully!"
    end
  end
end
