package inventory.inventory.service;

import inventory.inventory.dtos.CreateOrUpdateResponseDto;
import inventory.inventory.dtos.DeleteInventoryResponseDto;
import inventory.inventory.dtos.ResponseStatus;
import inventory.inventory.exceptions.ProductNotFoundException;
import inventory.inventory.exceptions.UnAuthorizedAccessException;
import inventory.inventory.exceptions.UserNotFoundException;
import inventory.inventory.models.Inventory;
import inventory.inventory.models.Product;
import inventory.inventory.models.User;
import inventory.inventory.models.UserType;
import inventory.inventory.repository.InventoryRespository;
import inventory.inventory.repository.ProductRespoitory;
import inventory.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InventoryRespository inventoryRespository;
    @Autowired
    private ProductRespoitory productRespoitory;
    @Override
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException {
        User savedUser=userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("USER NOT FOUND "+ userId));


        Optional<Product>savedProduct=productRespoitory.findById(productId);
        if(!savedProduct.isPresent()) {
            throw new ProductNotFoundException("PRODUCT NOT FOUND " + productId);
        }
        Product product=savedProduct.get();
        Optional<Inventory> savedInvetroy=inventoryRespository.findById(productId);

        Inventory inventory;
        if(savedInvetroy.isPresent()){
           inventory=savedInvetroy.get();
           inventory.setProduct(product);
            inventory.setQuantity(quantity);
        }else{
         inventory=new Inventory();
            inventory.setQuantity(quantity);
            Product product1=productRespoitory.findById(productId).orElseThrow(
                    ()->new ProductNotFoundException("PRODUCT NOT FOUND"));
            inventory.setProduct(product);
        }
        inventoryRespository.save(inventory);
        CreateOrUpdateResponseDto responseDto=new CreateOrUpdateResponseDto();
        responseDto.setInventory(inventory);
        return inventory;
    }

    @Override
    public DeleteInventoryResponseDto deleteInventory(int userId, int productId) throws UserNotFoundException, UnAuthorizedAccessException {
    DeleteInventoryResponseDto responseDto=new DeleteInventoryResponseDto();
     User user=userRepository.findById(userId).orElseThrow(
             ()-> new UserNotFoundException("USER NOT FOUND "+userId));
     if(!user.getUserType().equals(UserType.ADMIN)){
         throw new UnAuthorizedAccessException("YOUR ARE NOT AUTHORISED ");
     }
    Optional<Inventory>savedprodcut=inventoryRespository.findById(productId);
     if(!savedprodcut.isPresent()){
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
         throw new RuntimeException("PRODUCT ID NOT FOUND "+ productId);
     }
            inventoryRespository.delete(savedprodcut.get());

        System.out.println("intventory deleted ");
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }
}
