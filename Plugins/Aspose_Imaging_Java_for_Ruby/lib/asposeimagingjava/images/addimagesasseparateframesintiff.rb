module Asposeimagingjava
  module AddImagesAsSeparateFramesInTiff
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Create an instance of TiffOptions with CCITTFAX3 compression
        tiff_expected_format = Rjb::import('com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat')
        output_settings = Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(tiff_expected_format.TiffCcittFax3)
        
        # Set source for the result
        output_settings.setSource(Rjb::import('com.aspose.imaging.sources.FileCreateSource').new(data_dir + "output.tiff", false))
            
        # Declare Height and Width for the new TiffImage
        new_width = 500
        new_height = 500

        # Create an instance of TiffImage using the object of TiffOptions and dimension
        tiff_image = Rjb::import('com.aspose.imaging.Image').create(output_settings, new_width, new_height)
            
        # Initialize a variable to keep track of frames in the TiffImage
        index = 0
        
        # Read all JPG files from any specified directory and iterate over the list
        folder = Rjb::import('java.io.File').new(data_dir + "samples/")

        files = folder.listFiles()
        files.each do |fileEntry|
            # Load the image into an instance of RasterImage
            image = Rjb::import('com.aspose.imaging.Image').load(fileEntry.getAbsolutePath())
            
            # Resize the image according to TiffImage dimensions
            image.resize(new_width, new_height, Rjb::import('com.aspose.imaging.ResizeType').NearestNeighbourResample)
            
            # Get the active frame of TiffImage
            frame = tiff_image.getActiveFrame()
            
            # Save the RasterImage data onto TiffFrame
            frame.savePixels(frame.getBounds(), image.loadPixels(image.getBounds()))
            
            # Check if TiffImage already has a frame
            if index > 0
                # Create a new TiffFrame according to the TiffOptions settings
                frame = Rjb::import('com.aspose.imaging.fileformats.tiff.TiffFrame').new(Rjb::import('com.aspose.imaging.imageoptions.TiffOptions').new(output_settings), new_width, new_height)
                
                # Add the newly created frame to the TiffImage
                tiff_image.addFrame(frame)
            end
            index +=1
        end

        # Save the changes to TiffImage
        tiff_image.save()

        puts "Added Different Images as Separate Frames in a Multi-Page TIFF"
    end
  end
end
