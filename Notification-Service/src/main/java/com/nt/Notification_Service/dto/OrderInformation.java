package com.nt.Notification_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderInformation {

    private String orderId;
    private  String email;
    private String phoneNo;
    private String price;
}
