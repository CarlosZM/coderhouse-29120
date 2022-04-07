package com.coderhouse.session.twelve.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
//@Data es lo mismo que los de arriba
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseLombok {

    private String id;

    private String sellerId;

    private String clientId;

    private String totalAmount;

    private String status;

    private String purchaseNumber;

    private LocalDateTime createdAt;
}
