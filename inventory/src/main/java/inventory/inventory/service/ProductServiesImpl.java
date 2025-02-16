package inventory.inventory.service;

import inventory.inventory.dtos.ProdcutResponseDto;
import inventory.inventory.dtos.ProductRequestDto;
import inventory.inventory.models.Product;
import inventory.inventory.repository.ProductRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiesImpl implements ProductService {
@Autowired
    private ProductRespoitory productRespoitory;

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
