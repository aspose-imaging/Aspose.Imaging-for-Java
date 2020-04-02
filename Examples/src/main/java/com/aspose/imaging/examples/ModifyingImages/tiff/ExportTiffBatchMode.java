package com.aspose.imaging.examples.ModifyingImages.tiff;

import com.aspose.imaging.Image;
import com.aspose.imaging.PageExportingAction;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Path;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.tiff.TiffImage;

public class ExportTiffBatchMode
{
    public static void main(String[] args)
    {
        Logger.startExample("ExportTiffBatchMode");
        String dataDir = Utils.getSharedDataDir() + "Tiff/";;
        String fileName = "10MB_Tif.tif";
        String inputFileName = Path.combine(dataDir, fileName);
        String outputFileNameTif = Path.combine(Utils.getOutDir(), "ExportTiffBatchMode_output.tif");

        //The possibility of batch conversion before saving (exporting) Tiff images is implemented.
        try (TiffImage tiffImage = (TiffImage) Image.load(inputFileName))
        {
            // Set batch operation for pages
            tiffImage.setPageExportingAction(new PageExportingAction()
            {
                @Override
                public void invoke(int pageIndex, Image page)
                {
                    // Fires garbage collection to avoid unnecessary garbage storage from previous pages
                    System.gc();

                    ((RasterImage)page).rotate(90);
                }
            });

            tiffImage.save(outputFileNameTif); /* or export through tiffImage.Save("rotated.tif", new TiffOptions(TIFF_EXPECTED_FORMAT))*/

            /* Attention! In batch mode all pages will be released in this line!
             If you want to further perform operations on the original image, you should reload it from the source to another instance. */
        }

        Logger.endExample();
    }
}
