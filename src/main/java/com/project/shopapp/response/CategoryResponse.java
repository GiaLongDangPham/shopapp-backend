package com.project.shopapp.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.model.Category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private List<String> errors;

    @JsonProperty("category")
    private Category category;
}
