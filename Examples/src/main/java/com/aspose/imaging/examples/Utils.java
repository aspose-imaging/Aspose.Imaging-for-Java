package com.aspose.imaging.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public final class Utils {

	public static String getSharedDataDir() {
		File dir = new File(System.getProperty("user.dir"));
		dir = new File(dir, "src/main/resources");

		return dir.toString() + File.separator;
	}

	public static String getOutDir(String ... subdirs)
	{
		final String ex = "Can not create directory: ";

		if (outDir == null)
		{
			outDir = System.getProperty("java.io.tmpdir") + File.separator + "Aspose.Imaging.Examples.Java" + File.separator;
			File f = new File(outDir);
			if (!f.exists())
			{
				if (!f.mkdirs())
					throw new AssertionError(ex + outDir);
			}
		}

		if (subdirs.length > 0)
		{
			StringBuilder sb = new StringBuilder(outDir);
			for (String subdir : subdirs)
			{
				sb.append(File.separator).append(subdir);
			}
			String s = sb.toString();

			File f = new File(s);
			if (!f.exists() && !f.mkdirs())
			{
				throw new AssertionError(ex + s);
			}

			return s;
		}

		return outDir;
	}

	public static void deleteFile(String fileName)
	{
		File f = new File(fileName);
		if (f.exists())
			if (!f.delete())
				f.deleteOnExit();
	}

	public static void deleteAllOutputFiles()
	{
		if (outDir == null)
			return;

		File f = new File(outDir);
		if (!f.exists())
			return;

		try
		{
			Files.walkFileTree(FileSystems.getDefault().getPath(outDir), new RemoveFileVisitor());
		}
		catch (IOException ignored)
		{
			// hide it
		}
	}

	private static String outDir;

	private Utils() {
		// Do nothings
	}
}

class RemoveFileVisitor extends SimpleFileVisitor<java.nio.file.Path>
{
	public RemoveFileVisitor()
	{
		super();
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
	{
		Files.delete(file);
		return super.visitFile(file, attrs);
	}
}