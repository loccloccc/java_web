package com.example.artwork_management.service.impl;

import com.example.artwork_management.model.Artwork;
import com.example.artwork_management.repository.IArkworkRepository;
import com.example.artwork_management.service.IArtwork;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtworkServiceImpl implements IArtwork {
    private final IArkworkRepository iArkworkRepository;

    @Override
    public Page<Artwork> getArtworks(String search, Pageable pageable) {
        return iArkworkRepository.findByName(search, pageable);
    }
}
