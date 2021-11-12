package com.degloba.ecommerce.enviaments.domain.entitats;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enviament {

    @Id
    private String enviamentId;
    private String comandaId;
    private String estat;
}
