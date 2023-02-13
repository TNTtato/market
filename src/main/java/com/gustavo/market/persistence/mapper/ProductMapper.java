package com.gustavo.market.persistence.mapper;

import com.gustavo.market.domain.ProductDomain;
import com.gustavo.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "sellPrice", target = "price"),
            @Mapping(source = "inStock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    ProductDomain toProductDomain(Product product);
    List<ProductDomain> toProductsDomain(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDomain productDomain);
}
