package inventory.inventory.controller;

import inventory.inventory.dtos.*;
import inventory.inventory.dtos.ResponseStatus;
import inventory.inventory.exceptions.ProductNotFoundException;
import inventory.inventory.exceptions.UnAuthorizedAccessException;
import inventory.inventory.exceptions.UserNotFoundException;
import inventory.inventory.models.Inventory;
import inventory.inventory.service.InventoryService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inv")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

@PostMapping("/")
    public CreateOrUpdateResponseDto createOrUpdateInventory(@RequestBody CreateOrUpdateRequestDto requestDto) throws UserNotFoundException,
            UnAuthorizedAccessException,
            ProductNotFoundException {
        CreateOrUpdateResponseDto responseDto=new CreateOrUpdateResponseDto();
        try {
            Inventory inventory = inventoryService.createOrUpdateInventory(
                    requestDto.getUserId(),
                    requestDto.getProductId(),
                    requestDto.getQuantity());

            responseDto.setInventory(inventory);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (UserNotFoundException | UnAuthorizedAccessException | ProductNotFoundException e) {
            // Log the exception
            System.err.println("Error during inventory update: " + e.getMessage());

            // Set the response status to FAILURE
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
    @SneakyThrows
    @DeleteMapping("/")
    public DeleteInventoryResponseDto deleteInventory(@RequestBody DeleteInventoryRequestDto requestDto) {
    DeleteInventoryResponseDto requestDto1=new DeleteInventoryResponseDto();
             inventoryService.deleteInventory(requestDto.getUserId(),
                  requestDto.getProductId());
        requestDto1.setResponseStatus(ResponseStatus.SUCCESS);

            return requestDto1;
    }
}
