package br.com.jjd.sm.adapter.out.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@AllArgsConstructor
@Data
public class LevelId {
    private String produto;
    private String subProduto;
    private String variacao;
}
