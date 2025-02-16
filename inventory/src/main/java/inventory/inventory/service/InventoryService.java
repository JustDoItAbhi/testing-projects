package inventory.inventory.service;

import inventory.inventory.dtos.DeleteInventoryResponseDto;
import inventory.inventory.exceptions.ProductNotFoundException;
import inventory.inventory.exceptions.UnAuthorizedAccessException;
import inventory.inventory.exceptions.UserNotFoundException;
import inventory.inventory.models.Inventory;

public interface InventoryService {
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException;
    public DeleteInventoryResponseDto deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException;
}
