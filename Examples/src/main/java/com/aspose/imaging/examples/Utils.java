package com.aspose.imaging.examples;

import java.io.File;

public final class Utils {

	public static String getSharedDataDir() {
		File dir = new File(System.getProperty("user.dir"));
		dir = new File(dir, "src/main/resources");

		return dir.toString() + File.separator;
	}

	public static String getOutDir()
	{
		if (outDir == null)
		{
			outDir = System.getProperty("java.io.tmpdir") + File.separator + "Aspose.Imaging.Examples.Java" + File.separator;
			File f = new File(outDir);
			if (!f.exists())
			{
				f.mkdirs();
			}
		}

		return outDir;
	}

	private static String outDir;

	private Utils() {
		// Do nothings
	}
}