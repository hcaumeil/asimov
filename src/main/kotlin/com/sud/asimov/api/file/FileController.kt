package com.sud.asimov;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    lateinit var repository : FileRepository;

    @GetMapping("/{file_name}")
    fun downloadImage(@PathVariable file_name: String) : ResponseEntity<ByteArray>? {
          var file : File? = null;
          var files  = repository.findAll();

          for (f in files) {
            if (f.name == file_name) file = f;
          }

        
          if (file == null) {
              return null  
          } else {
             return ResponseEntity
                .ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(file.content);
        }
    }

    @GetMapping()
    fun get() : List<String> {
          var files  = repository.findAll().map( { it.name });

          return files;
    }

    @PostMapping()
    fun uploadImage(@RequestParam file : MultipartFile) : File? {
        var name = file.getOriginalFilename();

        if (name == null) {
            return null;
        }

        var f : File = File(name!!,file.getBytes());

        return repository.save(f)
    }
}
