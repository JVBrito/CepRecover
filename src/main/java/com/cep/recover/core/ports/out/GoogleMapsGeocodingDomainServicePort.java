package com.cep.recover.core.ports.out;

import com.cep.recover.core.domain.models.Address;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public interface GoogleMapsGeocodingDomainServicePort {
    LatLng getLatLngFromAddress(Address address);
    Address getAddressFromLatLng(LatLng latLng);
    Address getAddressByPostalCode(String postalCode) throws Exception;

}
