package com.explorer.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.explorer.assignment.entity.Folder;
@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer> {
    Folder findByName(String name);

	List<Folder> findByParentFolderIsNull();


}

