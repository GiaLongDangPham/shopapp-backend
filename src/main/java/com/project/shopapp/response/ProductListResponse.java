package com.project.shopapp.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductListResponse {
    private List<ProductResponse> products;
    private int totalPages;
}
