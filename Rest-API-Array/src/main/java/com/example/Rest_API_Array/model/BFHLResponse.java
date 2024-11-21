package com.example.Rest_API_Array.model;

import lombok.Data;

import java.util.List;


public class BFHLResponse {
    private boolean isSuccess;
    private String userId;
    private String email;
    private String rollNumber;
    private List<String> numbers;
    private List<String> alphabets;
    private List<String> highestLowercaseAlphabet;
    private boolean isPrimeFound;
    private boolean fileValid;
    private String fileMimeType;
    private int fileSizeKb;

    // Getters and Setters
    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getHighestLowercaseAlphabet() {
        return highestLowercaseAlphabet;
    }

    public void setHighestLowercaseAlphabet(List<String> highestLowercaseAlphabet) {
        this.highestLowercaseAlphabet = highestLowercaseAlphabet;
    }

    public boolean getIsPrimeFound() {
        return isPrimeFound;
    }

    public void setIsPrimeFound(boolean isPrimeFound) {
        this.isPrimeFound = isPrimeFound;
    }

    public boolean getFileValid() {
        return fileValid;
    }

    public void setFileValid(boolean fileValid) {
        this.fileValid = fileValid;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public int getFileSizeKb() {
        return fileSizeKb;
    }

    public void setFileSizeKb(int fileSizeKb) {
        this.fileSizeKb = fileSizeKb;
    }
}
