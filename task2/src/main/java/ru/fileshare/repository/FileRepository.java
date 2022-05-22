package ru.fileshare.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FileRepository {
    private final Map<String, MultipartFile> fileStorage = new ConcurrentHashMap<>();

    public void saveFile(String fileName, MultipartFile file) {
        fileStorage.put(fileName, file);
    }

    public MultipartFile getFile(String fileName) {
        return fileStorage.get(fileName);
    }
}
