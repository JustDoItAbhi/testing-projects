package inventory2.inventory2.inventory.service;


import inventory2.inventory2.inventory.dtos.ProdcutResponseDto;
import inventory2.inventory2.inventory.dtos.ProductRequestDto;

import java.util.List;

public interface ProductService {
    ProdcutResponseDto create(ProductRequestDto requestDto);
    List<ProdcutResponseDto>getAllPRD();
}
