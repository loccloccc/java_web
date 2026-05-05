package com.example.artwork_management.service;

import com.example.artwork_management.model.Artwork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArtwork {
    Page<Artwork> getArtworks(String search,Pageable pageable);
}
