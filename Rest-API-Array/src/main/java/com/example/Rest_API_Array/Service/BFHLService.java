package com.example.Rest_API_Array.Service;

import com.example.Rest_API_Array.model.BFHLRequest;
import com.example.Rest_API_Array.model.BFHLResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.util.*;

@Service
public class BFHLService {

    public BFHLResponse processRequest(BFHLRequest request) {
        // Initialize the response object
        BFHLResponse response = new BFHLResponse();
        response.setUserId("archi_jain_21092000");
        response.setEmail("archi.jain@svvv.edu.in");
        response.setRollNumber("12345");

        // Initialize collections
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<Character> lowercaseAlphabets = new ArrayList<>();
        boolean isPrimeFound = false;

        // Process the input data
        for (String item : request.getData()) {
            if (isNumeric(item)) {
                numbers.add(item);
                if (isPrime(Integer.parseInt(item))) {
                    isPrimeFound = true;
                }
            } else if (isAlphabet(item)) {
                alphabets.add(item);
                if (Character.isLowerCase(item.charAt(0))) {
                    lowercaseAlphabets.add(item.charAt(0));
                }
            }
        }

        // Set the highest lowercase alphabet
        if (!lowercaseAlphabets.isEmpty()) {
            char highestLowercase = Collections.max(lowercaseAlphabets);
            response.setHighestLowercaseAlphabet(List.of(String.valueOf(highestLowercase)));
        } else {
            response.setHighestLowercaseAlphabet(Collections.emptyList());
        }

        // Populate response fields
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setIsPrimeFound(isPrimeFound);

        // Handle file if provided
        handleFile(request.getFileB64(), response);

        // Mark the operation as successful
        response.setIsSuccess(true);

        return response;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private boolean isAlphabet(String str) {
        return str.matches("[a-zA-Z]");
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private void handleFile(String fileB64, BFHLResponse response) {
        if (fileB64 != null && !fileB64.isEmpty()) {
            try {
                byte[] decodedBytes = Base64.getDecoder().decode(fileB64);
                String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(decodedBytes));
                response.setFileValid(true);
                response.setFileMimeType(mimeType != null ? mimeType : "unknown");
                response.setFileSizeKb(decodedBytes.length / 1024);
            } catch (Exception e) {
                response.setFileValid(false);
                response.setFileMimeType(null);
                response.setFileSizeKb(0);
            }
        } else {
            response.setFileValid(false);
            response.setFileMimeType(null);
            response.setFileSizeKb(0);
        }
    }
}
