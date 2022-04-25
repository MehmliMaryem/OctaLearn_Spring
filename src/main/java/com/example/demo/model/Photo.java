package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String id;
	private String fileName;
	private String mimeType;
	private String data;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Photo(String id, String fileName, String mimeType, String data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.data = data;
	}
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
