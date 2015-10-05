module Asposeimagingjava
  module AddThumbnailToEXIFSegment
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of JpegImage to store the thumbnail
        thumbnail = Rjb::import('com.aspose.imaging.fileformats.jpeg.JpegImage').new(100, 100)

        # Create another instance of JpegImage as primary image
        image = Rjb::import('com.aspose.imaging.fileformats.jpeg.JpegImage').new(1000, 1000)

        # Set the ExifData value as new JpegExifData
        image.setExifData(Rjb::import('com.aspose.imaging.exif.JpegExifData').new)

        # Store the thumbnail in the Exif segment
        image.getExifData().set_Thumbnail(thumbnail)

        # Save the resultant image
        image.save(data_dir + "Thumbnail_EXIF.jpg")

        # Display Status.
        puts "Added thumbnail to EXIF segment successfully!"
    end
  end
end
