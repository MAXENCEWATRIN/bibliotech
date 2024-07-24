package com.maxencew.bibliotech.domain.adapter;

import com.maxencew.bibliotech.application.exception.BusinessException;
import com.maxencew.bibliotech.application.service.api.ImageService;
import com.maxencew.bibliotech.infrastructure.configuration.AppConfig;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@AllArgsConstructor
@Slf4j
public class ImageDownloaderService implements ImageService {

    private GridFSBucket gridFSBucket;
    private AppConfig appConfig;

    public ObjectId downloadAndStoreImage(String imageUrl) {
        try {
            ResponseEntity<byte[]> response = appConfig.restTemplate().getForEntity(imageUrl, byte[].class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                byte[] imageBytes = response.getBody();
                InputStream inputStream = new ByteArrayInputStream(imageBytes);

                GridFSUploadOptions options = new GridFSUploadOptions()
                        .chunkSizeBytes(358400)
                        .metadata(new org.bson.Document("type", "image")
                                .append("content_type", "image/jpeg"));

                return gridFSBucket.uploadFromStream("cover_image", inputStream, options);
            } else {
                throw new BusinessException("Failed to download image from URL: " + imageUrl);
            }
        } catch (Exception e) {
            throw new BusinessException("Error while downloading or storing the image", e);
        }
    }

    public byte[] getImageById(ObjectId id) {
        try {
            GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(id);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = downloadStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error while trying to retrieve image by id %s", e.getMessage()));
        }
    }

    @Override
    public void deleteImageById(ObjectId id) {
        try {
            gridFSBucket.delete(id);
            LOGGER.info("Image with id {} successfully deleted", id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting image ", e);
        }
    }
}