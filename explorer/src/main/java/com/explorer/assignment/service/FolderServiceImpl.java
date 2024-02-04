package com.explorer.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explorer.assignment.entity.Folder;
import com.explorer.assignment.repository.FolderRepository;

@Service
public class FolderServiceImpl implements FolderService {

	@Autowired
	private FolderRepository repository;

	public Folder createFolder(Folder folder) {
		return repository.save(folder);
	}

	@Override
	public List<Folder> getFolders() {

		return repository.findByParentFolderIsNull();
	}

	@Override
	public Folder getFolderById(int id) {
		return repository.findById(id).orElse(null);

	}

	@Override
	public Folder createSubFolder(Folder folder, int folder_id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Folder> rootfolder = repository.findById(folder_id);
		if (!rootfolder.isPresent()) {
			throw new Exception("root folder does not exist");
		}
		folder.setParentFolder(rootfolder.get());
		folder = repository.save(folder);

		return folder;
	}

	@Override
	public void deleteFolderById(int id) {
		repository.deleteById(id); // delete al the dependent rows also

	};

}
