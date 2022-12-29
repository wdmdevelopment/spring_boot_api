package com.example.demo.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileModel;
import com.example.demo.model.FileResponse;
import com.example.demo.repository.FileRepsitory;
import com.example.demo.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileRepsitory fileRepo;

		//For Uploading a file
	public FileResponse store(MultipartFile file) throws IOException {

		String fileName = file.getOriginalFilename();
		
		FileModel filemodel = new FileModel(UUID.randomUUID().toString(), fileName, file.getContentType(),
				file.toString());
		System.out.println(((Object)filemodel).getClass().getSimpleName());
		
		System.out.println(UUID.randomUUID().toString());
		System.out.println(fileName);
		System.out.println(file.getBytes());
		
		
		
		
		
		
		fileRepo.save(filemodel);

		return mapToFileResponse(filemodel);

	}

	// For get the file
	public FileModel getFileById(String id) {

		java.util.Optional<FileModel> fileOptional = fileRepo.findById(id);

		if (fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}

	public List<FileResponse> getFileList() {
		return fileRepo.findAll().stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	public FileResponse mapToFileResponse(FileModel filemodel) {
		return new FileResponse(filemodel.getId(), filemodel.getType(), filemodel.getName());
	}
}
