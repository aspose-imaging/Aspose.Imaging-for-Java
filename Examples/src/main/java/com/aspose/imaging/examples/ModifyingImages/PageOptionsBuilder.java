package com.aspose.imaging.examples.ModifyingImages;

import com.aspose.imaging.Image;
import com.aspose.imaging.Size;
import com.aspose.imaging.VectorMultipageImage;
import com.aspose.imaging.imageoptions.VectorRasterizationOptions;

import java.util.LinkedList;
import java.util.List;

public final class PageOptionsBuilder
{
    private PageOptionsBuilder()
    {
        // Utilty class
    }

    public static <TOptions extends VectorRasterizationOptions> VectorRasterizationOptions[]
        createPageOptions(Class<TOptions> type, VectorMultipageImage image)
    {
        List<VectorRasterizationOptions> list = new LinkedList<>();
        // Create page rasterization options for each page in the image
        for (Image page : image.getPages())
        {
            try
            {
                list.add(createPageOptions(type, page.getSize()));
            }
            catch (InstantiationException | IllegalAccessException e)
            {
                throw new Error(e);
            }
        }
        return list.toArray(new VectorRasterizationOptions[0]);
    }

    private static <TOptions extends VectorRasterizationOptions> VectorRasterizationOptions
    createPageOptions(Class<TOptions> type, Size pageSize) throws IllegalAccessException, InstantiationException
    {
        // Create the instance of rasterization options
        TOptions options = type.newInstance();
        // Set the page size
        options.setPageSize(Size.to_SizeF(pageSize));
        return options;
    }
}
