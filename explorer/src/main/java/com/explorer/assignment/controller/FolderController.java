package com.explorer.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.explorer.assignment.entity.Folder;
import com.explorer.assignment.service.FolderService;

@RestController
public class FolderController {

	@Autowired
	private FolderService service;

	@PostMapping("/addFolder/{folder_id}")
	public ResponseEntity<Folder> createFolder(@RequestBody Folder folder, @PathVariable int folder_id)
			throws Exception {
		System.out.println("if*******" + folder_id);
		Folder createdFolder = service.createSubFolder(folder, folder_id);
		return new ResponseEntity<>(createdFolder, HttpStatus.CREATED);
	}

	@PostMapping("/addFolder")
	public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) throws Exception {
		Folder createdFolder = service.createFolder(folder);
		return new ResponseEntity<>(createdFolder, HttpStatus.CREATED);

	}

	@GetMapping("/folder")
	public List<Folder> findAllProducts() {
		return service.getFolders();
	}

	@GetMapping("/folderById/{id}")
	public Folder findFolderById(@PathVariable int id) {
		System.out.println("folder by id");
		return service.getFolderById(id);
	}

	@DeleteMapping("/folderById/{id}")
	public Folder deleteFolderById(@PathVariable int id) {
		System.out.println("folder by id");
		service.deleteFolderById(id);
//		return new ResponseEntity<>("deleted", HttpStatus.OK);
		return null;

	}
}