module Asposeimagingjava
  module ReadAndModifyJpegEXIFTags
    def initialize()
        # Reading EXIF Data Using ExifData Class
        read_jpeg_exif_tags_using_exifdata_class()

        # Writing & Modifying EXIF Data Using ExifData Class
        modify_jpeg_exif_tags_using_exifdata_class()

        # Reading EXIF Data Using JpegExifData Class
        read_jpeg_exif_tags_using_jpegexifdata_class()
    end

    def read_jpeg_exif_tags_using_exifdata_class()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Initialize an object of ExifData and fill it will image's EXIF information
        exif = image.getExifData()

        # Check if image has any EXIF entries defined
        if exif != nil
            # Display a few EXIF entries
            puts "Exif WhiteBalance: " + exif.get_WhiteBalance().to_s
            puts "Exif PixelXDimension: " + exif.get_PixelXDimension().to_s
            puts "Exif PixelYDimension: " + exif.get_PixelYDimension().to_s
            puts "Exif ISOSpeed: " + exif.get_ISOSpeed().to_s
            puts "Exif BodySerialNumber: " + exif.get_BodySerialNumber().to_s
            puts "Exif CameraOwnerName: " + exif.get_CameraOwnerName().to_s
            puts "Exif ColorSpace: " + exif.get_ColorSpace().to_s
            puts "Exif Contrast: " + exif.get_Contrast().to_s
            puts "Exif CustomRendered: " + exif.get_CustomRendered().to_s
            puts "Exif DateTimeDigitized: " + exif.get_DateTimeDigitized().to_s
            puts "Exif DateTimeOriginal: " + exif.get_DateTimeOriginal().to_s
            puts "Exif ExposureMode: " + exif.get_ExposureMode().to_s
            puts "Exif ExposureProgram: " + exif.get_ExposureProgram().to_s
            puts "Exif Flash: " + exif.get_Flash().to_s
            puts "Exif FocalLengthIn35MmFilm: " + exif.get_FocalLengthIn35MmFilm().to_s
            puts "Exif FocalPlaneResolutionUnit: " + exif.get_FocalPlaneResolutionUnit().to_s
            puts "Exif GainControl: " + exif.get_GainControl().to_s
            puts "Exif ImageUniqueID: " + exif.get_ImageUniqueID().to_s
            puts "Exif Sharpness: " + exif.get_Sharpness().to_s
            puts "Exif MeteringMode: " + exif.get_MeteringMode().to_s
        end
    end

    def modify_jpeg_exif_tags_using_exifdata_class()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Initialize an object of ExifData and fill it will image's EXIF information
        exif = image.getExifData()

        # Set Lens Make information
        exif.set_LensMake("Sony")

        # Set WhiteBalance information
        exif.set_WhiteBalance(Rjb::import('com.aspose.imaging.exif.enums.ExifWhiteBalance').Auto)

        # Set that Flash was fires
        exif.set_Flash(Rjb::import('com.aspose.imaging.exif.enums.ExifFlash').Fired)

        # Save the changes to the original image
        image.save(data_dir + "ModifyExifTags.jpg")

        # Display result
        puts "Modified JPEG exif tags using ExifData class."
    end

    def read_jpeg_exif_tags_using_jpegexifdata_class()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "test.jpg")

        # Initialize an object of ExifData and fill it will image's EXIF information
        exif = image.getExifData()

        # Display a few EXIF entries
        puts "EXIF CameraOwnerName: " + exif.get_CameraOwnerName().to_s
        puts "EXIF ApertureValue: " + exif.get_ApertureValue().to_s
        puts "EXIF Orientation: " + exif.get_Orientation().to_s
        puts "EXIF FocalLength: " + exif.get_FocalLength().to_s
        puts "EXIF Compression: " + exif.get_Compression().to_s
    end
  end
end
