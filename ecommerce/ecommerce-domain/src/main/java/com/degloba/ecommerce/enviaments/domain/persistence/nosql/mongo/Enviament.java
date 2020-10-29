package com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Enviament {

    @Id
    private String enviamentId;
    private String comandaId;
    private String estatEnviament;
}
