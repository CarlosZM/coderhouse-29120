package com.coderhouse.session.ten.domain;

public class Person {

    private String firstName;

    private String lasstName;

    private DocumentType documentType;

    private String documentId;

    private String region;

    private String district;

    public Person(String firstName, String lasstName, DocumentType documentType, String documentId, String region, String district) {
        this.firstName = firstName;
        this.lasstName = lasstName;
        this.documentType = documentType;
        this.documentId = documentId;
        this.region = region;
        this.district = district;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasstName() {
        return lasstName;
    }

    public void setLasstName(String lasstName) {
        this.lasstName = lasstName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
