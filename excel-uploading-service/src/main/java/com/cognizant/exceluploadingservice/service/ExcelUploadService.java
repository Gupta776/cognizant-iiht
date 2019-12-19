package com.cognizant.exceluploadingservice.service;

import java.io.FileNotFoundException;

import com.cognizant.exceluploadingservice.dto.ExcelUploadDTO;


public interface ExcelUploadService {
	public void uploadFileService(String filePath) throws FileNotFoundException;
	public ExcelUploadDTO getSummary();
}
