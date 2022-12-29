package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileModel;
import com.example.demo.model.FileResponse;

@Service
public interface FileService {
		
	public FileResponse store(MultipartFile file) throws IOException;
	public FileModel getFileById(String id);
	public List<FileResponse> getFileList();
	public FileResponse mapToFileResponse(FileModel filemodel);

}
