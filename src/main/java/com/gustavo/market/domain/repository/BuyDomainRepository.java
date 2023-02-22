package com.gustavo.market.domain.repository;

import com.gustavo.market.domain.BuyDomain;

import java.util.List;
import java.util.Optional;

public interface BuyDomainRepository {
    List<BuyDomain> getAll();
    Optional<List<BuyDomain>> getByClient(String clientId);
    BuyDomain save(BuyDomain buyDomain);
}
