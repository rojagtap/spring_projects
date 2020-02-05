package com.example.uploadingfiles;

import com.example.uploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UploadingFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingFilesApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StorageService storageService){
		return args -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
