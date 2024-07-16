package com.maxencew.bibliotech.application.service.api;

import org.bson.types.ObjectId;

public interface ImageService {

    ObjectId downloadAndStoreImage(String imageUrl);
    byte[] getImageById(ObjectId id);
}
