package com.real.springfmk.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_archives")
public class ArchiveEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="archive_id")
	private Long archiveId;
	@Column(name="archive_name")
	private String archiveName;
	@Column(name = "original_name")
	private String originalName;
	@Column(name="archive_path")
	private String archivePath;
	@Column(name="archive_type")
	private String archiveType;
	
	public ArchiveEntity() {
		super();
	}

	
	public ArchiveEntity(Long archiveId, String archiveName, String originalName, String archivePath,
			String archiveType) {
		super();
		this.archiveId = archiveId;
		this.archiveName = archiveName;
		this.originalName = originalName;
		this.archivePath = archivePath;
		this.archiveType = archiveType;
	}


	public Long getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}
	public String getArchivePath() {
		return archivePath;
	}
	public void setArchivePath(String archivePath) {
		this.archivePath = archivePath;
	}
	public String getArchiveType() {
		return archiveType;
	}
	public void setArchiveType(String archiveType) {
		this.archiveType = archiveType;
	}


	public String getOriginalName() {
		return originalName;
	}


	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	

	
	
}
