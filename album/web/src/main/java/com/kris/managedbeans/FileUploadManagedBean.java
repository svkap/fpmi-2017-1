package com.kris.managedbeans;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Kris on 16.06.2017 г..
 */

@ManagedBean
@SessionScoped
public class FileUploadManagedBean {

	private UploadedFile file;
	private static final String BASE_FILE_PATH = "C:/Users/Kris/Downloads/apache-tomcat-9.0.0.M21/apache-tomcat-9.0.0.M21/webapps/pics/";

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent e) {
		// Get uploaded file from the FileUploadEvent
		this.file = e.getFile();
		try {
			String extension = file.getFileName().substring(file.getFileName().lastIndexOf("."));
			String name = UUID.randomUUID().toString();
			Files.copy(file.getInputstream(), Paths.get(BASE_FILE_PATH + name + "." + extension));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Print out the information of the file
		System.out.println(
				"Uploaded File Name Is :: " + file.getFileName() + " :: Uploaded File Size :: " + file.getSize());
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully"));
	}
}