package com.aspose.imaging.examples.files;

import com.aspose.imaging.examples.Logger;

public class MeteredLicensing
{
    public static void main(String[] args)
    {
        Logger.startExample("MeteredLicensing");
        // Create an instance of OCR Metered class
        com.aspose.imaging.Metered metered = new com.aspose.imaging.Metered();

        // Access the setMeteredKey property and pass public and private keys as parameters
        metered.setMeteredKey("<valid pablic key>", "<valid private key>");

        // Get consumed qantity value before accessing API
        Logger.println("Consumption quantity" + com.aspose.imaging.Metered.getConsumptionQuantity());

        // DO PROCESSING
//        com.aspose.imaging.Image img = com.aspose.imaging.Image.load("C:\\in.psd");
//        img.save("C:\\Temp\\out.psd");
//
//        // Since upload data is running on another thread, so we need wait some time
//        java.lang.Thread.sleep(10000);

        // get metered data amount
        Logger.println("Consumption quantity" + com.aspose.imaging.Metered.getConsumptionQuantity());
        Logger.endExample();
    }
}
