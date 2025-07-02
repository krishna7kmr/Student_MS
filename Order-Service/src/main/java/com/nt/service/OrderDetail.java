package com.nt.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    private String orderId;
    private String email;
    private String UserId;
    private String userPhone;
    private boolean orderPaymentStatus= false;
    private String bookId;
}
