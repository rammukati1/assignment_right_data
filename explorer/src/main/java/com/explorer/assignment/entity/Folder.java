package com.explorer.assignment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "folder")
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "type")
	private String type;
//
//	@Column(nullable = false, name = "parent_id")
//	private int parent_folder_id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Folder parentFolder;

	@JsonManagedReference
	@OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Folder> children;

	public Folder(Long id, String name, String type, Folder parentFolder, List<Folder> children) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.parentFolder = parentFolder;
		this.children = children;
	}

}
