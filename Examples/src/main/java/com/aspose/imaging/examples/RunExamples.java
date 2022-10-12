package com.aspose.imaging.examples;

import com.aspose.imaging.examples.CDR.SupportOfCDR;
import com.aspose.imaging.examples.CMX.CMXToPNGConversion;
import com.aspose.imaging.examples.ConvertingImages.*;
import com.aspose.imaging.examples.ConvertingImages.memorystrategy.OptimizationStrategyInDJVU;
import com.aspose.imaging.examples.ConvertingImages.memorystrategy.OptimizationStrategyInJPEG2000;
import com.aspose.imaging.examples.ConvertingImages.otg.DefaultFontUsageImprove;
import com.aspose.imaging.examples.ConvertingImages.otg.SupportOfFODG;
import com.aspose.imaging.examples.ConvertingImages.svg.SvgNativeResize;
import com.aspose.imaging.examples.EMF.CropEMFImage;
import com.aspose.imaging.examples.Html5Canvas.ExportToHtml5Canvas;
import com.aspose.imaging.examples.InterruptMonitor.InterruptMonitorSupport;
import com.aspose.imaging.examples.ManipulatingJPEGImages.*;
import com.aspose.imaging.examples.ManipulatingPNGImages.*;
import com.aspose.imaging.examples.ManipulatingTIFFImages.SupportExtractingPathsFromTiff;
import com.aspose.imaging.examples.ManipulatingTIFFImages.SupportOfGetOriginalOptions;
import com.aspose.imaging.examples.ManipulatingTIFFImages.SupportTiffDeflate;
import com.aspose.imaging.examples.ManipulatingTIFFImages.TiffOptionsConfiguration;
import com.aspose.imaging.examples.ModifyingImages.*;
import com.aspose.imaging.examples.ModifyingImages.apng.*;
import com.aspose.imaging.examples.ModifyingImages.bmp.BmpRLE4;
import com.aspose.imaging.examples.ModifyingImages.cdr.*;
import com.aspose.imaging.examples.ModifyingImages.cmx.CmxToPdfExample;
import com.aspose.imaging.examples.ModifyingImages.cmx.CmxToTiffExample;
import com.aspose.imaging.examples.ModifyingImages.dicom.DicomCompression;
import com.aspose.imaging.examples.ModifyingImages.dicom.DicomToPngExample;
import com.aspose.imaging.examples.ModifyingImages.dicom.ExportToDicom;
import com.aspose.imaging.examples.ModifyingImages.dicom.SupportStoringXmpTags;
import com.aspose.imaging.examples.ModifyingImages.dxf.ExportToDxf;
import com.aspose.imaging.examples.ModifyingImages.eps.ExportEps;
import com.aspose.imaging.examples.ModifyingImages.gif.CreateGifUsingAddPage;
import com.aspose.imaging.examples.ModifyingImages.gif.SupportGifFrameDurationAndNumberOfCycles;
import com.aspose.imaging.examples.ModifyingImages.gif.SupportOfFullFrameGif;
import com.aspose.imaging.examples.ModifyingImages.ico.ConvertIcoToTiff;
import com.aspose.imaging.examples.ModifyingImages.jpeg.JpegSavedQualityEstimation;
import com.aspose.imaging.examples.ModifyingImages.jpeg.ReadAllEXIFTags;
import com.aspose.imaging.examples.ModifyingImages.jpeg.ReadAndModifyJpegEXIFTags;
import com.aspose.imaging.examples.ModifyingImages.jpeg.ReadSpecificEXIFTagsInformation;
import com.aspose.imaging.examples.ModifyingImages.multipage.MultipageFromImages;
import com.aspose.imaging.examples.ModifyingImages.removebackground.GraphCutAutoMasking;
import com.aspose.imaging.examples.ModifyingImages.tga.ConvertToTGA;
import com.aspose.imaging.examples.ModifyingImages.tiff.CreateGraphicsPathFromPathTiffResourcesAndViceVersa;
import com.aspose.imaging.examples.ModifyingImages.tiff.ExportTiffBatchMode;
import com.aspose.imaging.examples.ModifyingImages.tiff.SetDPIInExportedPdf;
import com.aspose.imaging.examples.ModifyingImages.webp.*;
import com.aspose.imaging.examples.Photoshop.ExportImagestoPSDFormat;
import com.aspose.imaging.examples.SVG.SVGToBMPConversion;
import com.aspose.imaging.examples.SVG.UnifyExtractionOfRasterImagesEmbeddedInVectorFormats;
import com.aspose.imaging.examples.WebP.OpenWebPFile;
import com.aspose.imaging.examples.dicom.*;
import com.aspose.imaging.examples.djvu.*;
import com.aspose.imaging.examples.export.Bradleythreshold;
import com.aspose.imaging.examples.export.ExportImageToDifferentFormats;
import com.aspose.imaging.examples.export.ExportImageToPSD;
import com.aspose.imaging.examples.files.CreatingAnImageBySettingPath;
import com.aspose.imaging.examples.files.CreatingImageUsingStream;
import com.aspose.imaging.examples.files.ReadingPixelValues;
import com.aspose.imaging.examples.images.*;
import com.aspose.imaging.examples.memorystrategies.*;
import com.aspose.imaging.examples.metafile.CropbyShifts;
import com.aspose.imaging.examples.metafile.*;
import com.aspose.imaging.examples.wmf.ConvertWMFToSVG;
import com.aspose.imaging.examples.wmf.CropWMFFile;
import com.aspose.imaging.examples.wmf.CroppingWMFFileWhileConvertingtoPNG;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class RunExamples
{
 	public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException, IllegalAccessException
	{
		// If you have a license, please uncomment followed lines
//		License lic = new License();
//		lic.setLicense("fileOfYourLicense.lic");

		Logger.println("Open public class RunExamples.java. \nIn main() method uncomment the example that you want to run.");
		Logger.println("Output dir is ", Utils.getOutDir());
		Logger.println("=====================================================");

		// Uncomment the one you want to try out

		// =====================================================
		// =====================================================
		//            Drawing And Formatting Images
		// =====================================================
		// =====================================================

		GraphicsMeasureString.main(args);
		DrawingUsingGraphics.main(args);
		DrawingUsingGraphicsPath.main(args);
		DrawingRectangle.main(args);
		DrawingArc.main(args);
		DrawingEllipse.main(args);
		DrawingBezier.main(args);
		CombineImages.main(args);
		DrawingLines.main(args);
		CreatingAnImageBySettingPath.main(args);
		CreatingImageUsingStream.main(args);
		DrawImagesUsingCoreFunctionality.main(args);
		ImageTransparency.main(args);
		SpecifyTransparency.main(args);
		InterruptMonitorSupport.main(args);
		DrawRasterImageOnWMF.main(args);
		DrawRasterImageOnEMF.main(args);
		DrawRasterImageOnSVG.main(args);
		DrawVectorImageToRasterImage.main(args);

		//// =====================================================
		//// =====================================================
		////            Modifying And Converting Images
		//// =====================================================
		//// =====================================================

		Logger.println("Running modifying and converting images tests:");
		Support16BitChannel64BitPng.main(args);
		ConvertIcoToTiff.main(args);
		JpegSavedQualityEstimation.main(args);
		UnifyExtractionOfRasterImagesEmbeddedInVectorFormats.main(args);
		ApsToPsd.main(args);
		PixelPerfectTextAlignment.main(args);
		FileExtensionAwareSave.main(args);
		ImageScopedFonts.main(args);
		BmpRLE4.main(args);
		MultipageFromImages.main(args);
		CreateGifUsingAddPage.main(args);
		ExportEps.main(args);
		CreateGraphicsPathFromPathTiffResourcesAndViceVersa.main(args);
		ConvertTo1BitPng.main(args);
		ExportAPNGToGif.main(args);
		CreateAnimationFromMultipageImage.main(args);
		SupportExtractingPathsFromTiff.main(args);
		CreateAPNGAnimationFromSinglePageImage.main(args);
		CreateAPNGAnimationFromGraphics.main(args);
		SupportOfFullFrameGif.main(args);
		ExportToHtml5Canvas.main(args);
		SetDPIInExportedPdf.main(args);
		CompressedVectorFormats.main(args);
		ExportTiffBatchMode.main(args);
		ExportToDicom.main(args);
		CroppingWMFFileWhileConvertingtoPNG.main(args);
		ConvertingSVGToRasterImages.main(args);
		AddWatermarkToImage.main(args);
		AddFramesToTIFFImage.main(args);
		AdjustBrightnessDICOM.main(args);
		AdjustContrast.main(args);
		AdjustGamma.main(args);
		PNGToPDF.main(args);
		BMPToPDF.main(args);
		SupportForJPEG.main(args);
		ReadingPixelValues.main(args);
		RasterImageToPDF.main(args);
		SupportForEPSFormat.main(args);
		ConvertEMFToWMF.main(args);
		AlignHorizontalAndVeticalResolutionsOfImage.main(args);
		ApplyGaussWienerFilter.main(args);
		ApplyGaussWienerFilterForColoredImage.main(args);
		ApplyingMotionWienerFilter.main(args);
		ApplyMedianAndWienerFilters.main(args);
		BinarizationwithFixedThreshold.main(args);
		BinarizationWithOtsuThresholdOnDICOMImage.main(args);
		BluranImage.main(args);
		Bradleythreshold.main(args);
		ConvertingSVGToRasterImages.main(args);
		CompressingTIFFImagesWithAdobeDeflateCompression.main(args);
		CompressingTIFFImagesWithLZWAlgorithm.main(args);
		ConcatTIFFImages.main(args);
		ConcatenatingTIFFImagesfromStream.main(args);
		ConcatenateTiffImagesHavingSeveralFrames.main(args);
		ConvertGIFImageLayersToTIFF.main(args);
		CreatingTIFFImageWithCompression.main(args);
		CreateWMFMetaFileImage.main(args);
		ConvertWMFMetaFileToSVG.main(args);
		DitheringRasterImages.main(args);
		ExpandOrCropAnImage.main(args);
		ExtractTIFFFramesToBMPImageFormat.main(args);
		ExportImageToDifferentFormats.main(args);
		ExportImageToPSD.main(args);
		Grayscaling.main(args);
		ReadandWriteXMPDataToImages.main(args);
		ResizeImageWithResizeTypeEnumeration.main(args);
		ResizingWithResizeTypeEnumeration.main(args);
		RotatingImageOnSpecificAngle.main(args);
		SavingEachFrameInOtherRasterImageFormat.main(args);
		SavingRasterImageToTIFFWithCompression.main(args);
		SimpleResizeImageProportionally.main(args);
		SimpleResizing.main(args);
		SplittingTiffFrames.main(args);
		TiffDataRecovery.main(args);
		TiffOptionsConfiguration.main(args);
		ControllCacheReallocation.main(args);
		AddDiagonalWatermarkToImage.main(args);
		ColorConversionUsingICCProfiles.main(args);
		 ColorConversionUsingDefaultProfiles.main(args);
		AddSignatureToImage.main(args);
		ExportTextAsShape.main(args);
		CreateEMFMetaFileImage.main(args);
		ResizeWMFFile.main(args);
		ConvertWMFToWebp.main(args);
		ConvertWMFToPNG.main(args);
		ConvertWMFToPDF.main(args);
		GetLastModifiedDate.main(args);
		SupportTiffDeflate.main(args);
		ConvertImageWithGrayscale.main(args);
		ManualImageMasking.main(args);
		AutoImageMasking.main(args);
		SupportOfDIB.main(args);
		SupportOfTextRenderingHint.main(args);
		SupportOfSmoothingMode.main(args);
		CropWMFFile.main(args);
		CropEMFImage.main(args);
		SupportOfDPISettingsInPdfOptions.main(args);

		//// =====================================================
		//// =====================================================
		////                        Memory Strategies
		//// =====================================================
		//// =====================================================

		Logger.println("Running memory strategies tests:");

		OptimizationStrategyInDicom.main(args);
		OptimizationStrategyInWebP.main(args);
		OptimizationStrategyInRotate.main(args);
		OptimizationStrategyInFilters.main(args);
		OptimizationStrategyInDithering.main(args);
		OptimizationStrategyInResize.main(args);
		OptimizationStrategyInJPEG.main(args);
		OptimizationStrategyInDJVU.main(args);
		OptimizationStrategyInJPEG2000.main(args);

		DocumentConvertionProgress.main(args);

		//// =====================================================
		//// =====================================================
		////                        Deskew
		//// =====================================================
		//// =====================================================

		System.out.println("Running additional features tests:");
		GraphCutAutoMasking.main(args);
		Deskew.main(args);

		System.out.println("Running file formats tests:");

		// =====================================================
		// =====================================================
		//                        Gif
		// =====================================================
		// =====================================================

		SupportGifFrameDurationAndNumberOfCycles.main(args);

		// =====================================================
		// =====================================================
		//                        Apng
		// =====================================================
		// =====================================================

		GetOriginalOptions.main(args);

		// =====================================================
		// =====================================================
		//                        DXF
		// =====================================================
		// =====================================================

		ExportToDxf.main(args);

		// =====================================================
		// =====================================================
		//                        TGA
		// =====================================================
		// =====================================================

		ConvertToTGA.main(args);

		// =====================================================
		// =====================================================
		//                        TIFF
		// =====================================================
		// =====================================================
		SupportOfGetOriginalOptions.main(args);

		//// =====================================================
		//// =====================================================
		////                        DICOM
		//// =====================================================
		//// =====================================================
		SupportStoringXmpTags.main(args);
		DicomCompression.main(args);
		DicomToPngExample.main(args);
		AdjustBrightnessDICOM.main(args);
		AdjustContrastDICOM.main(args);
		AdjustGammaDICOM.main(args);
		ApplyFilterOnDICOMImage.main(args);
		BinarizationWithFixedThresholdOnDICOMImage.main(args);
		BinarizationWithOtsuThresholdOnDICOMImage.main(args);
		BinarizationWithBradleysAdaptiveThreshold.main(args);
		DICOMSimpleResizing.main(args);
		DitheringForDICOMImage.main(args);
		DICOMSOtherImageResizingOptions.main(args);
		FlipDICOMImage.main(args);
		GrayscalingOnDICOM.main(args);
		RotateDICOMImage.main(args);

		//// =====================================================
		//// =====================================================
		////                        JPEG
		//// =====================================================
		//// =====================================================

		AddThumbnailtoEXIFSegment.main(args);
		AddThumbnailtoJFIFSegment.main(args);
		AutoCorrectOrientationOfJPEGImages.main(args);
		CropByRectangleEMFImage.main(args);
		CropbyShifts.main(args);
		ReadAllEXIFTags.main(args);
		ReadAndModifyJpegEXIFTags.main(args);
		ReadJpegEXIFTags.main(args);
		ReadSpecificEXIFTagsInformation.main(args);
		RotatingAnImage.main(args);
		WritingAndModifyingEXIFData.main(args);
		ConvertTIFFToJPEG.main(args);

		//// =====================================================
		//// =====================================================
		////                    META FILES
		//// =====================================================
		//// =====================================================

		ConvertEMFtoPDF.main(args);
		CropByRectangleEMFImage.main(args);
		CropEMFImage.main(args);
		SupportForReplacingMissingFonts.main(args);
		SaveEMFtoFile.main(args);
		SaveEMFPlustoFile.main(args);
		SaveEmfGraphics.main(args);

		////SVG----------
		ConvOfOtherFormatsToSVG.main(args);
		SVGToEMFConversion.main(args);
		ConvertWMFToSVG.main(args);
		SVGToBMPConversion.main(args);
		SvgNativeResize.main(args);

		//// =====================================================
		//// =====================================================
		////                        PNG
		//// =====================================================
		//// =====================================================

		ApplyFilterMethod.main(args);
		ChangeBackgroundColor.main(args);
		CompressingFiles.main(args);
		SettingResolution.main(args);
		SpecifyBitDepth.main(args);
		SpecifyTransparency.main(args);
		SpecifyTransparencyUsingRasterImage.main(args);
		// ReadLargePNGFile.main(args); // required halfGigImage.png in Examples\src\main\resources\ManipulatingPNGImages\
		//// =====================================================
		//// =====================================================
		////                        PSD
		//// =====================================================
		//// =====================================================
		ExportImagestoPSDFormat.main(args);

		//// =====================================================
		//// =====================================================
		////                        WebPImage
		//// =====================================================
		//// =====================================================

		WebPToPdfExample.main(args);
		WebPToGifExample.main(args);
		ConvertGIFFImageFrame.main(args);
		CreatingWebPImage.main(args);
		ExportToWebP.main(args);
		ExportWebPToOtherImageFormats.main(args);
		ExtractFrameFromWebPImage.main(args);
		OpenWebPFile.main(args);

		//// =====================================================
		//// =====================================================
		////                           DjVu
		//// =====================================================
		//// =====================================================

		ConvertDjvuToTiff.main(args);
		ConvertRangeOfDjVuPagesToSeparateImages.main(args);
		ConvertRangeOfDjVuPagesToSeparateImages.main(args);
		ConvertSpecificPortionOfDjVuPage.main(args);
		ConvertDjVuToPDF.main(args);
		ParallelDJVUImagesProcessingUsingMultithreading.main(args);

		//// =====================================================
		//// =====================================================
		////                           Fodg
		//// =====================================================
		//// =====================================================

		SupportOfFODG.main(args);

		//// =====================================================
		//// =====================================================
		////                           CMX
		//// =====================================================
		//// =====================================================
		CmxToTiffExample.main(args);
		CmxToPdfExample.main(args);
		CMXToPNGConversion.main(args);

		//// =====================================================
		//// =====================================================
		////                           CDR
		//// =====================================================
		//// =====================================================
		PantoneGoeCoatedPalette.main(args);
		CdrToPdfExample.main(args);
		SupportOfCDR.main(args);
		CdrToPsdMultipageExample.main(args);
		CdrToPngExample.main(args);

		//// =====================================================
		//// =====================================================
		////                           OTG
		//// =====================================================
		//// =====================================================
		SupportOfOTG.main(args);
		DefaultFontUsageImprove.main(args);

		Logger.println("All examples have been finished!");
	}
}
