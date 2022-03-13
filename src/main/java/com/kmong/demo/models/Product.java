package com.kmong.demo.models;
import javax.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "product")
public class Product {
    
    @Id
    private Long productNo;
    private String productName;
    private int unitPrice;
    
}
