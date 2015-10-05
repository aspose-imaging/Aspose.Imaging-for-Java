module Asposeimagingjava
  module ConvertingDjVuToPdf
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Load an existing image (of type bmp) in an instance of Image class
        image = Rjb::import('com.aspose.imaging.Image').load(data_dir + "demo.djvu")

        # Create an instance of PdfOptions
        export_options = Rjb::import('com.aspose.imaging.imageoptions.PdfOptions').new
        
        # Initialize the metadata for Pdf document
        export_options.setPdfDocumentInfo(Rjb::import('com.aspose.imaging.fileformats.pdf.PdfDocumentInfo').new)
        
        # Create an instance of IntRange and initialize it with the range of DjVu pages to be exported
        #range = Rjb::import('com.aspose.imaging.IntRange').new(0, 5) # Export first 5 pages
        range = Array[0,1,2,3,4]
        
        # Initialize an instance of DjvuMultiPageOptions with range of DjVu pages to be exported 
        export_options.setMultiPageOptions(Rjb::import('com.aspose.imaging.imageoptions.DjvuMultiPageOptions').new(range))
        
        # Save the result in PDF format
        image.save(data_dir + "djvu.pdf", export_options)

        # Display Status.
        puts "Converted DjVu to PDF successfully!"
    end
  end
end
