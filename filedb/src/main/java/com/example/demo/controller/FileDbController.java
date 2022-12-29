package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileModel;
import com.example.demo.model.FileResponse;
import com.example.demo.service.FileService;


@RestController
@RequestMapping("/file")
public class FileDbController {
	
	@Autowired
	private FileService fileDbService;
	
	@PostMapping
	public FileResponse uploadFile(@RequestParam MultipartFile  file) throws IOException {
		return fileDbService.store(file);
	}
	
	@GetMapping("/{id}")
	public FileModel getFile(@PathVariable("id") String id) {
		
		return fileDbService.getFileById(id);
		
	}
	
	@GetMapping("/list")
	public List<FileResponse> getFileList(){
		return fileDbService.getFileList();
	}

}
