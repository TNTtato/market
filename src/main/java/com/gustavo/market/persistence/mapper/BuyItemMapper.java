package com.gustavo.market.persistence.mapper;

import com.gustavo.market.domain.BuyItem;
import com.gustavo.market.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface BuyItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    BuyItem toBuyItem(BuyProduct buyProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true),
    })
    BuyProduct toBuyProduct(BuyItem buyItem);
}
