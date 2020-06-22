package com.aspose.imaging.examples.InterruptMonitor;

import com.aspose.imaging.Image;
import com.aspose.imaging.ImageOptionsBase;
import com.aspose.imaging.coreexceptions.OperationInterruptedException;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.multithreading.InterruptMonitor;

import java.io.File;
import java.util.Date;


public class InterruptMonitorSupport
{

    public static void main(String... args) throws InterruptedException
    {
        Logger.startExample("InterruptMonitorSupport");

        String dataDir = Utils.getSharedDataDir() + "InterruptMonitor/";
        ImageOptionsBase saveOptions = new PngOptions();

        InterruptMonitor monitor = new InterruptMonitor();
        SaveImageWorker worker = new SaveImageWorker(dataDir + "big.jpg", Utils.getOutDir() + "big_out.png", saveOptions, monitor);

        Thread thread = new Thread(worker);

        try
        {
            thread.start();

            // The timeout should be less than the time required for full image conversion (without interruption).
            Thread.sleep(3000);

            // Interrupt the process
            Logger.printf("Interrupting the save thread #%d at %s", thread.getId(), new Date());
            monitor.interrupt();

            // Wait for interruption...
            thread.join();
        }
        finally
        {
            // If the file to be deleted does not exist, no exception is thrown.
            File f = new File(Utils.getOutDir() + "big_out.png");
            if (!f.delete())
                f.deleteOnExit();
        }
        Logger.endExample();
    }

    /**
     * Initiates image conversion and waits for its interruption.
     */
    private static class SaveImageWorker implements Runnable
    {
        /**
         * The path to the input image.
         */
        private final String inputPath;

        /**
         * The path to the output image.
         */
        private final String outputPath;

        /**
         * The interrupt monitor.
         */
        private final InterruptMonitor monitor;

        /**
         * The save options.
         */
        private final ImageOptionsBase saveOptions;

        /**
         * Initializes a new instance of the SaveImageWorker class.
         *
         * @param inputPath   The path to the input image.
         * @param outputPath  The path to the output image.
         * @param saveOptions The save options.
         * @param monitor     The interrupt monitor.
         */
        public SaveImageWorker(String inputPath, String outputPath, ImageOptionsBase saveOptions, InterruptMonitor monitor)
        {
            this.inputPath = inputPath;
            this.outputPath = outputPath;
            this.saveOptions = saveOptions;
            this.monitor = monitor;
        }

        /**
         * Tries to convert image from one format to another. Handles interruption.
         */
        public void run()
        {
            Image image = Image.load(this.inputPath);
            try
            {
                InterruptMonitor.setThreadLocalInstance(this.monitor);

                try
                {
                    image.save(this.outputPath, this.saveOptions);
                }
                catch (OperationInterruptedException e)
                {
                    Logger.printf("The save thread #%d finishes at %s", Thread.currentThread().getId(), new Date());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    InterruptMonitor.setThreadLocalInstance(null);
                }
            }
            finally
            {
                image.dispose();
            }
            //ExEnd:InterruptMonitorSupport

        }
    }
}