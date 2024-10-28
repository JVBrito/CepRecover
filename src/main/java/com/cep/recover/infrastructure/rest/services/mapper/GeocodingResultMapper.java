package com.cep.recover.infrastructure.rest.services.mapper;

import com.cep.recover.core.domain.models.Address;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

public class GeocodingResultMapper {
    public Address toAddress(GeocodingResult geocodingResult) {
        Address address = new Address();

        for (AddressComponent component : geocodingResult.addressComponents) {
            for (AddressComponentType type : component.types) {
                switch (type) {
                    case COUNTRY:
                        address.setCountry(component.longName);
                        break;
                    case STREET_ADDRESS:
                        address.setLogradouro(component.longName);
                        break;
                    case STREET_NUMBER:
                        address.setNumber(component.longName);
                        break;
                    case ADMINISTRATIVE_AREA_LEVEL_2:
                        address.setCity(component.longName);
                        break;
                    case ADMINISTRATIVE_AREA_LEVEL_1:
                        address.setState(component.longName);
                        break;
                    case POSTAL_CODE:
                        address.setPostalCode(component.longName);
                        break;
                    default:
                        break;
                }
            }
        }

        return address;
    }
}