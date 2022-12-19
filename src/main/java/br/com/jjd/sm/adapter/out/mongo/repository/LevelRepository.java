package br.com.jjd.sm.adapter.out.mongo.repository;

import br.com.jjd.sm.adapter.out.mongo.model.Level;
import br.com.jjd.sm.adapter.out.mongo.model.LevelId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LevelRepository extends MongoRepository<Level, LevelId> {
    //@Query(value = "{ $or: [ { _id: { produto:'?0', subProduto: '?1',variacao: '?2' } }, { _id: { produto:'?0', subProduto: '?1',variacao: '0' } }, { _id: { produto:'?0', subProduto: '0',variacao: '0' } }] } ).limit(1).sort({'_id':-1})")
    @Aggregation( pipeline = {
            "{ '$match': { $or: [ { _id: { produto:'?0', subProduto: '?1',variacao: '?2' } }, { _id: { produto:'?0', subProduto: '?1',variacao: '0' } }, { _id: { produto:'?0', subProduto: '0',variacao: '0' } } ] } }",
            "{ '$sort' : {'_id': -1} }",
            "{ '$limit': 1 }"
    })
    Optional<Level> findItemByProdutoSubProdutoAndVariacao(String produto, String subProduto, String variacao);
}
