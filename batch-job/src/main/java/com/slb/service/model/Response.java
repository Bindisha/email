package com.slb.service.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
