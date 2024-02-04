package com.explorer.assignment.service;

import java.util.List;

import com.explorer.assignment.entity.Folder;

public interface FolderService {

	Folder createFolder(Folder folder);

	List<Folder> getFolders();

	Folder getFolderById(int id);

	Folder createSubFolder(Folder folder, int folder_id) throws Exception;

	void deleteFolderById(int id);

}
