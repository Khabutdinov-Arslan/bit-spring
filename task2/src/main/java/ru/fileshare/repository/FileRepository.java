package ru.fileshare.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Repository
public class FileRepository {
    public void saveFile(String file_name, byte[] file) {
        try {
            Files.write(Path.of(file_name), file);
        } catch (IOException ignored) {
        }
    }

    public byte[] getFile(String file_name) {
        try {
            return Files.readAllBytes(Path.of(file_name));
        } catch (IOException e){
            return new byte[0];
        }
    }
}
