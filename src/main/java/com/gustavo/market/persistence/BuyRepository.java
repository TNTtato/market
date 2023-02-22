package com.gustavo.market.persistence;

import com.gustavo.market.domain.BuyDomain;
import com.gustavo.market.domain.repository.BuyDomainRepository;
import com.gustavo.market.persistence.crud.BuyCrudRepository;
import com.gustavo.market.persistence.entity.Buy;
import com.gustavo.market.persistence.mapper.BuyDomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements BuyDomainRepository {

    private BuyCrudRepository buyCrudRepository;
    private BuyDomainMapper buyDomainMapper;

    @Autowired
    public BuyRepository(BuyCrudRepository buyCrudRepository, BuyDomainMapper buyDomainMapper) {
        this.buyCrudRepository = buyCrudRepository;
        this.buyDomainMapper = buyDomainMapper;
    }

    @Override
    public List<BuyDomain> getAll() {
        return buyDomainMapper.toBuyDomainList(buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<BuyDomain>> getByClient(String clientId) {
        return buyCrudRepository.findByIdClient(clientId)
                .map(buys -> buyDomainMapper.toBuyDomainList(buys));
    }

    @Override
    public BuyDomain save(BuyDomain buyDomain) {
        Buy buy = buyDomainMapper.toBuy(buyDomain);
        buy.getProducts().forEach(product -> product.setBuy(buy));
        return buyDomainMapper.toBuyDomain(buyCrudRepository.save(buy));
    }
}
