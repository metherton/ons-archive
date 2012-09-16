package com.ethertons.common;

import java.io.File;
import java.io.IOException;

import com.ethertons.persistence.PersonDao;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHandler {

    private PersonDao personDao;

    @Autowired
    public FileHandler(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(String fileName,  MultipartFile gedcomfile) {
        try {
            File file=new File(fileName);
            FileUtils.writeByteArrayToFile(file, gedcomfile.getBytes());
        } catch(IOException e){
            throw new GedcomUploadException("Unabletosavegedcomfile",e);
        }
    }

    private class GedcomUploadException extends RuntimeException {
        public GedcomUploadException(String unabletosavegedcomfile, IOException e) {
        }
    }
}
