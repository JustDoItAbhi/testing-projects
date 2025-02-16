package inventory2.inventory2.inventory.service;

import inventory2.inventory2.inventory.exceptions.ProductNotFoundException;
import inventory2.inventory2.inventory.exceptions.UnAuthorizedAccessException;
import inventory2.inventory2.inventory.exceptions.UserNotFoundException;
import inventory2.inventory2.inventory.models.Inventory;
import inventory2.inventory2.inventory.models.Product;
import inventory2.inventory2.inventory.models.User;
import inventory2.inventory2.inventory.models.UserType;
import inventory2.inventory2.inventory.repository.InventoryRepository;
import inventory2.inventory2.inventory.repository.ProductRepository;
import inventory2.inventory2.inventory.repository.UserRepository;
import inventory2.inventory2.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private UserRepository userRepository;

    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException {
        Optional<User>savedUser=userRepository.findById(userId);
        if(savedUser.isEmpty()){
            throw new UserNotFoundException("USER NOT FOUND "+ userId);
        }
        Optional<Product>savedProduct=productRepository.findById(productId);
        if(savedProduct.isEmpty()){
            throw new ProductNotFoundException("PRODUCT NOT FOUND "+ productId);
        }
        Product product=savedProduct.get();
        Optional<Inventory>savedInvetroy=inventoryRepository.findById(productId);
        Inventory inventory;
        if(savedInvetroy.isPresent()){
            inventory=savedInvetroy.get();
            inventory.setQuantity(quantity);
        }else{
            inventory=new Inventory();
            inventory.setQuantity(quantity);
            inventory.setProduct(product);
        }
        inventoryRepository.save(inventory);

        return inventory;

    }
    public void deleteInventory(int userId, int productId)throws UserNotFoundException,UnAuthorizedAccessException {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new UserNotFoundException("USER NOT FOUND "+ userId));

        if(!user.getUserType().equals(UserType.ADMIN)){
            throw new UnAuthorizedAccessException("USER IS NOT ADMIN ");
        }
        Optional<Inventory>savedInventory=inventoryRepository.findById(productId);
        if(!savedInventory.isPresent()){
            throw new IllegalArgumentException("PRODCUT ID NOT FOUND ");

        }
        inventoryRepository.delete(savedInventory.get());
    }

}