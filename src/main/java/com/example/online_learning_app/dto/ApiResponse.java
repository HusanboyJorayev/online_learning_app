package com.example.online_learning_app.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private boolean success;
    private int code;
    private String message;

    private List<ErrorResponse> errorResponses;
}
