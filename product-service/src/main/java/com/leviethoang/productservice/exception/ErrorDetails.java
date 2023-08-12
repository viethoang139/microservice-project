package com.leviethoang.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String errorName;
    private String errorStatus;
    private LocalDateTime timeStamp;
    private String path;
}
