package com.maxencew.bibliotech.domain.ports.spi;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;

public interface ImagePersistencePort {
    ObjectId saveImage(byte[] imageBytes, String filename, String contentType);
    GridFSFile findImageById(ObjectId id);
    byte[] getImageData(GridFSFile file);
}
