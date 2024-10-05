package com.store.service;

import com.store.model.ProductDtoModel;
import com.store.model.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class ImageService implements ImageServiceIf {

    private static final String UPLOAD_DIR = "public/images";
    private final Logger log = LoggerFactory.getLogger(ImageService.class);

    @Override
    public void saveImageFile(ProductDtoModel productDtoModel, ProductModel product) {
        MultipartFile image = productDtoModel.getImageFile();
        String storageFileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, uploadPath.resolve(storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
            product.setImageFileName(storageFileName);
        } catch (IOException ex) {
            log.error("File upload failed: {}", ex.getMessage());
        }
    }

    @Override
    public void updateImageFile(ProductModel product, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            deleteImageFile(product.getImageFileName());
            saveNewImage(product, imageFile);
        }
    }

    @Override
    public void deleteImageFile(String imageName) {
        Path imagePath = Paths.get(UPLOAD_DIR + "/" + imageName);
        try {
            Files.deleteIfExists(imagePath);
        } catch (IOException ex) {
            log.error("Error deleting image file: {}", ex.getMessage());
        }
    }


    private void saveNewImage(ProductModel product, MultipartFile imageFile) {
        String storageFileName = System.currentTimeMillis() + "-" + imageFile.getOriginalFilename();
        try (InputStream inputStream = imageFile.getInputStream()) {
            Files.copy(inputStream, Paths.get(UPLOAD_DIR + "/" + storageFileName), StandardCopyOption.REPLACE_EXISTING);
            product.setImageFileName(storageFileName);
        } catch (IOException ex) {
            log.error("Error saving new image: {}", ex.getMessage());
        }
    }
}
