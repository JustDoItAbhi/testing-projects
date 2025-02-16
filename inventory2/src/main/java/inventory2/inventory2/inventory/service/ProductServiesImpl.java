package inventory2.inventory2.inventory.service;


import inventory2.inventory2.inventory.dtos.ProdcutResponseDto;
import inventory2.inventory2.inventory.dtos.ProductRequestDto;

import inventory2.inventory2.inventory.models.Product;
import inventory2.inventory2.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiesImpl implements ProductService {
@Autowired
    private ProductRepository productRespoitory;

    @Override
    public ProdcutResponseDto create(ProductRequestDto requestDto) {
        Product product=new Product();
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        productRespoitory.save(product);
        return ProdcutResponseDto.from(product);
    }
    @Override
    public List<ProdcutResponseDto> getAllPRD() {
        List<Product>products=productRespoitory.findAll();
        List<ProdcutResponseDto>prodcutResponseDtos=new ArrayList<>();
        for(Product product:products){
            prodcutResponseDtos.add(ProdcutResponseDto.from(product));
        }
        return prodcutResponseDtos;
    }
}
