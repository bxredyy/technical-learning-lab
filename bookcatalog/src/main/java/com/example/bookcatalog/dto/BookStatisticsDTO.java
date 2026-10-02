package com.example.bookcatalog.dto;

// Per-author aggregation of book statistics
public record BookStatisticsDTO(
        String authorName,
        long bookCount,
        double averagePageCount
) {
}