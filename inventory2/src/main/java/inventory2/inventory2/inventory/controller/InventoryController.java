package inventory2.inventory2.inventory.controller;


import inventory2.inventory2.inventory.dtos.CreateOrUpdateRequestDto;
import inventory2.inventory2.inventory.dtos.CreateOrUpdateResponseDto;
import inventory2.inventory2.inventory.dtos.DeleteInventoryRequestDto;
import inventory2.inventory2.inventory.dtos.DeleteInventoryResponseDto;
import inventory2.inventory2.inventory.dtos.ResponseStatus;
import inventory2.inventory2.inventory.exceptions.ProductNotFoundException;
import inventory2.inventory2.inventory.exceptions.UnAuthorizedAccessException;
import inventory2.inventory2.inventory.exceptions.UserNotFoundException;
import inventory2.inventory2.inventory.models.Inventory;
import inventory2.inventory2.inventory.service.InventoryService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    // public InventoryController(InventoryService inventoryService) {
    //     this.inventoryService = inventoryService;
    // }
    @PostMapping("/createOrUpdate")
    public CreateOrUpdateResponseDto createOrUpdateInventory(@RequestBody CreateOrUpdateRequestDto requestDto) throws ProductNotFoundException,
            UserNotFoundException,
            UnAuthorizedAccessException{
        CreateOrUpdateResponseDto responseDto=new CreateOrUpdateResponseDto();
        try{
            Inventory inventory =inventoryService.createOrUpdateInventory(requestDto.getUserId(),requestDto.getProductId(),requestDto.getQuantity());
            responseDto.setInventory(inventory);
            responseDto.setResponseStatus(inventory2.inventory2.inventory.dtos.ResponseStatus.SUCCESS);

        }catch (UserNotFoundException | ProductNotFoundException| UnAuthorizedAccessException e ) {
            System.err.println("ERROR IN INVENTORY "+e.getMessage());
            responseDto.setResponseStatus(inventory2.inventory2.inventory.dtos.ResponseStatus.FAILURE);
        }
        return responseDto;
    }
    @DeleteMapping("/delete")
    public DeleteInventoryResponseDto deleteInventory(@RequestBody DeleteInventoryRequestDto requestDto) throws UserNotFoundException, UnAuthorizedAccessException {
        DeleteInventoryResponseDto responseDto = new DeleteInventoryResponseDto();
        try {
            inventoryService.deleteInventory(requestDto.getUserId(), requestDto.getProductId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException | UnAuthorizedAccessException e) {
//            e.printStackTrace();
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }


}
