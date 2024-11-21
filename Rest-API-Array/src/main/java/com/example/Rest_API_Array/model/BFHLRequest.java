package com.example.Rest_API_Array.model;

import lombok.Data;

import java.util.List;

@Data
public class BFHLRequest {
    private List<String> data;
    private String fileB64;
}
