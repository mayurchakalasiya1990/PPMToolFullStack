package com.org.PPMtool.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProjectIDExceptionResponse {

    private String projectIdExceptionResp;

    public ProjectIDExceptionResponse(String projectIdExceptionResp) {
        this.projectIdExceptionResp = projectIdExceptionResp;
    }
}
