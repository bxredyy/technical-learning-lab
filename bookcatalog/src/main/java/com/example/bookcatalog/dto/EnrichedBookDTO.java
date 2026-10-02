package com.example.bookcatalog.dto;

import java.time.LocalDateTime;

// Holds enriched book data including external metadata
public record EnrichedBookDTO(
        Long id,
        String title,
        String author,
        String isbn,
        int pageCount,
        String genre,
        LocalDateTime enrichedAt
) {
}