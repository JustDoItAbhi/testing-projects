package inventory.inventory.controller;

import inventory.inventory.dtos.ProdcutResponseDto;
import inventory.inventory.dtos.ProductRequestDto;
import inventory.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProductControler {
    @Autowired
    private ProductService productService;
    @PostMapping("/")
    public ResponseEntity<ProdcutResponseDto> create(@RequestBody ProductRequestDto requestDto){
       ProdcutResponseDto responseDto=productService.create(requestDto);
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProdcutResponseDto>> getall(){
        return ResponseEntity.ok(productService.getAllPRD());
    }
}
