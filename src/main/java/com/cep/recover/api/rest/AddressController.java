package com.cep.recover.api.rest;

import com.cep.recover.api.rest.service.AddressService;
import com.cep.recover.api.rest.service.TransactionService;
import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<Address> findByPostalCode(@PathParam("postalCode") String postalCode) throws Exception {
        Address response = addressService.getAddressByPostalCode(postalCode);
        return ResponseEntity.ok(response);
    }
}
