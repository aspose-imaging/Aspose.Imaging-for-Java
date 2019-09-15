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
		return outDir;
	}

	private static String outDir = System.getProperty("java.io.tmpdir") + File.separator;

	private Utils() {
		// Do nothings
	}
}