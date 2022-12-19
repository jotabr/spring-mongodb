package br.com.jjd.sm.adapter.out.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
@CompoundIndex(name = "pro_sub_var", def = "{'produto': 1, 'subProduto': 1, 'variacao': 1}")
public class Config {
    private String produto;
    private String subProduto;
    private String variacao;
    private String type;
    private Integer days;
}
