package inventory2.inventory2.inventory.dtos;
import inventory2.inventory2.inventory.models.Product;
import lombok.Data;

@Data
public class ProdcutResponseDto {
    private int id;
    private String name;
    private String description;
    private double price;
    public static ProdcutResponseDto from(Product product){
        ProdcutResponseDto responseDto=new ProdcutResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
      return responseDto;
    }
}
