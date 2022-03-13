package com.kmong.demo.models;

import javax.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "orderNew")
public class Order {
    @Id
    private String orderNo;
    private String productNo;
    private String userid;
    private int amount;
    private int unit;

}
