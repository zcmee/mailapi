package com.github.zcmee.mailapi.components;

import com.github.zcmee.mailapi.api.Converter;
import com.github.zcmee.mailapi.exceptions.ConverterException;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Component
public class MultipartFileConverter implements Converter<MultipartFile, File> {

    @Override
    public File convert(MultipartFile input) {

        try {
            String fileName = FilenameUtils.getName(input.getOriginalFilename());
            String fileExtension = FilenameUtils.getExtension(input.getOriginalFilename());
            File tempFile = File.createTempFile(fileName, fileExtension);
            tempFile.deleteOnExit();
            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                IOUtils.copy(input.getInputStream(), out);
                return tempFile;
            }
        } catch(Exception ex) {
            throw new ConverterException(ex);
        }
    }

}
