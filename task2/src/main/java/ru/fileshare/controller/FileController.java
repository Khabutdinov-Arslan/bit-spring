package ru.fileshare.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.fileshare.service.FileService;

@RestController
@RequestMapping()
public class FileController {
    private final FileService service;

    public FileController(FileService service) { this.service = service; }

    @PostMapping(value = "/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public void saveFile(@RequestParam String filename,  @RequestPart(name = "file") MultipartFile content) {
        //System.out.println(new String(content));
        service.saveFile(filename, content);
    }

    @GetMapping("/getFile")
    public byte[] getFile(@RequestParam String filename) {
        try{
            return service.getFile(filename).getBytes();
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
