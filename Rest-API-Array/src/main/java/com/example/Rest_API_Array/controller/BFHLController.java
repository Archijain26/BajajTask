package com.example.Rest_API_Array.controller;

import com.example.Rest_API_Array.Service.BFHLService;
import com.example.Rest_API_Array.model.BFHLRequest;
import com.example.Rest_API_Array.model.BFHLResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {

    private final BFHLService bfhlService;

    public BFHLController(BFHLService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BFHLResponse> handlePostRequest(@RequestBody BFHLRequest request) {
        BFHLResponse response = bfhlService.processRequest(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> handleGetRequest() {
        return ResponseEntity.ok(Map.of("operation_code", 1));
    }
}
