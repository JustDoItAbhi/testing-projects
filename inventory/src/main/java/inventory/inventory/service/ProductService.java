package inventory.inventory.service;

import inventory.inventory.dtos.ProdcutResponseDto;
import inventory.inventory.dtos.ProductRequestDto;

import java.util.List;

public interface ProductService {
    ProdcutResponseDto create(ProductRequestDto requestDto);
    List<ProdcutResponseDto>getAllPRD();
}
