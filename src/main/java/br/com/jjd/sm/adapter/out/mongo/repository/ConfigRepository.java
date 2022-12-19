package br.com.jjd.sm.adapter.out.mongo.repository;

import br.com.jjd.sm.adapter.out.mongo.model.Config;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConfigRepository extends MongoRepository<Config, String> {
    @Aggregation( pipeline = {
            "{ '$match': { $or: [ { produto:'?0', subProduto: '?1',variacao: '?2' }, { produto:'?0', subProduto: '?1',variacao: '0' }, { produto:'?0', subProduto: '0',variacao: '0' } ] } }",
            "{ '$sort' : { produto: -1, subProduto: -1,variacao: -1 } }",
            "{ '$limit': 1 }"
    })
    Optional<Config> findItemByProdutoSubProdutoAndVariacao(String produto, String subProduto, String variacao);
}
