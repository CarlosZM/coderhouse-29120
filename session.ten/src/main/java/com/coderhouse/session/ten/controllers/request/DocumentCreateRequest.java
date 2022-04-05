package com.coderhouse.session.ten.controllers.request;

public class DocumentCreateRequest {

    private String jwt;

    private String documentId;

    public DocumentCreateRequest(String jwt, String documentId) {
        this.jwt = jwt;
        this.documentId = documentId;
    }

    public DocumentCreateRequest() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}
