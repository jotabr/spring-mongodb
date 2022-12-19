package br.com.jjd.sm.adapter.out.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document
public class Level {
    @Id
    private LevelId id;
    private String type;
    private Integer days;
}
