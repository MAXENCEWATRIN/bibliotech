package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.domain.ports.spi.ImagePersistencePort;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@AllArgsConstructor
@Component
public class ImagePersistenceAdapter implements ImagePersistencePort {

    private GridFSBucket gridFSBucket;

    @Override
    public ObjectId saveImage(byte[] imageBytes, String filename, String contentType) {
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        GridFSUploadOptions options = new GridFSUploadOptions()
                .chunkSizeBytes(358400)
                .metadata(new org.bson.Document("type", "image")
                        .append("content_type", contentType));

        return gridFSBucket.uploadFromStream(filename, inputStream, options);
    }

    @Override
    public GridFSFile findImageById(ObjectId id) {
        return gridFSBucket.find(new org.bson.Document("_id", id)).first();
    }

    @Override
    public byte[] getImageData(GridFSFile file) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gridFSBucket.downloadToStream(file.getObjectId(), outputStream);
        return outputStream.toByteArray();
    }
}
