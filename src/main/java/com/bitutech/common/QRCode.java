package com.bitutech.common;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCode {
	
	public static String createQR(String data, String empcode
            ,String filePath)throws WriterException, IOException
		{
		
		filePath = filePath+empcode+".png";

		BitMatrix matrix = 
				new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		
		MatrixToImageWriter.writeToPath(matrix, "PNG", path);
		
		return FileSystems.getDefault().getPath(filePath).toString();
}

}
