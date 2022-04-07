package com.coderhouse.session.twelve.mapstruct;

public class PurchaseParser {

    Purchase convertResponseToDomain(PurchaseDto purchaseDto) {
        return new Purchase(
                purchaseDto.getId(),
                purchaseDto.getSeller(),
                purchaseDto.getClientId(),
                purchaseDto.getTotalAmount(),
                purchaseDto.getStatus(),
                purchaseDto.getPurchaseNumber()
        );
    }
}
