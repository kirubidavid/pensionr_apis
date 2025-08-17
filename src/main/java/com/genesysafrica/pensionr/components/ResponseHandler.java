package com.genesysafrica.pensionr.components;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.PagedModel;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus responseCode, Object responseObj){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("responseCode", responseCode);
        response.put("timestamp", LocalDateTime.now());
        response.put("data", responseObj);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<PagedModel> generatePagedResponse(String message, HttpStatus responseCode, PagedModel responseObj){
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("responseCode", responseCode);
        response.put("timestamp", LocalDateTime.now());
        response.put("data", responseObj);
        return ResponseEntity.ok(responseObj);
    }


    public static ResponseEntity<byte[]> generatePdfResponse(String filename, byte[] responseObj){
        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename="+filename+".pdf")
                .body(responseObj);
    }


}
