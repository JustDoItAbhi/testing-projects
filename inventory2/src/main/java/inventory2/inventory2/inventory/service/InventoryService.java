package inventory2.inventory2.inventory.service;


import inventory2.inventory2.inventory.dtos.DeleteInventoryResponseDto;
import inventory2.inventory2.inventory.exceptions.ProductNotFoundException;
import inventory2.inventory2.inventory.exceptions.UnAuthorizedAccessException;
import inventory2.inventory2.inventory.exceptions.UserNotFoundException;
import inventory2.inventory2.inventory.models.Inventory;

public interface InventoryService {
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException;
    public void deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException;
}
