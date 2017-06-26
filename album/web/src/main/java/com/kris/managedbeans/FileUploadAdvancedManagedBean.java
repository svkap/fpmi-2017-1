package com.kris.managedbeans;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@ManagedBean
@SessionScoped
public class FileUploadAdvancedManagedBean {
  UploadedFile file;

  public UploadedFile getFile() {
    return file;
  }

  public void setFile(UploadedFile file) {
    this.file = file;
  }

  public void fileUploadListener(FileUploadEvent e) throws IOException {
    // Get uploaded file from the FileUploadEvent
    this.file = e.getFile();
    // Save the file
    Path folder = Paths.get("C:\\Users\\Kris\\Desktop\\albums");

    InputStream input = file.getInputstream();
    String filename = FilenameUtils.getName(file.getFileName());
    String basename = FilenameUtils.getBaseName(filename) + "_";
    String extension = "." + FilenameUtils.getExtension(filename);
    File file = File.createTempFile(basename, extension, folder.toFile());
    FileOutputStream output = new FileOutputStream(file);

    try {
      IOUtils.copy(input, output);
    } finally {
      IOUtils.closeQuietly(input);
      IOUtils.closeQuietly(output);
    }

    System.out.println("Uploaded file successfully saved in " + file);
  }
}
