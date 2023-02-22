package com.gustavo.market.persistence.mapper;

import com.gustavo.market.domain.BuyDomain;
import com.gustavo.market.persistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BuyItemMapper.class})
public interface BuyDomainMapper {

    @Mappings({
             @Mapping(source = "idBuy", target = "buyId"),
             @Mapping(source = "idClient", target = "clientId"),
             @Mapping(source = "products", target = "items")

    })
    BuyDomain toBuyDomain(Buy buy);

    List<BuyDomain> toBuyDomainList(List<Buy> buys);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Buy toBuy(BuyDomain buyDomain);
}
