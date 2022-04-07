package com.coderhouse.session.twelve.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PurchaseParserMapStruct {

    @Mapping(source = "seller", target = "sellerId")
    Purchase convertResponseToDomain(PurchaseDto purchaseDto);

    /**
     * class Purchase {
     *     List<Product> products;
     *     Client client;
     *     Seller seller;
     * }
     *     Client convertResponseToDomain(ClientDto purchaseDto);
     *     Seller convertResponseToDomain(SellerDto purchaseDto);
     *     List<Product> convertResponseToDomain(List<ProductDto> purchaseDto);
     *     Product convertResponseToDomain(ProductDto purchaseDto);
     */
}
