package com.cep.recover.infrastructure.rest.services;

import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.ports.out.GoogleMapsGeocodingDomainServicePort;
import com.cep.recover.infrastructure.rest.services.mapper.GeocodingResultMapper;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleMapsGeocodingServiceImpl implements GoogleMapsGeocodingDomainServicePort {

    @Value("${google.maps.api.key}")
    private String API_KEY;

    public LatLng getLatLngFromAddress(Address address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address.toString()).await();
            if (results.length > 0) {
                return results[0].geometry.location;
            }
        } catch (Exception e) {
            // Tratar exceções, como chave API inválida, limite de requisições, etc.
            throw new RuntimeException("Erro ao obter coordenadas do Google Maps", e);
        }
        return null;
    }

    public Address getAddressFromLatLng(LatLng latLng) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        try {
        List<GeocodingResult> results = List.of(GeocodingApi.reverseGeocode(context, latLng).await());
        GeocodingResultMapper mapper = new GeocodingResultMapper();
            return mapper.toAddress(results.get(1));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter endereço a partir das coordenadas", e);
        }
    }

    public Address getAddressByPostalCode(String postalCode) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        try {
            String address = "address=" + "CEP+" + postalCode;
            List<GeocodingResult> results = List.of(GeocodingApi.geocode(context, address).await());
            GeocodingResultMapper mapper = new GeocodingResultMapper();
            return mapper.toAddress(results.get(0));
        } catch (Exception e) {
            throw new RuntimeException("Endereço não encontrado para o CEP: " + postalCode);
        }

    }

    public Address getAddressFromLatLng(double lat, double lng) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        List<GeocodingResult> results = List.of(GeocodingApi.reverseGeocode(context, new LatLng(lat, lng)).await());
        GeocodingResultMapper mapper = new GeocodingResultMapper();
        return mapper.toAddress(results.get(1));
    }

    private void handleException(Exception e) {
        if (e.getMessage().contains("API key is invalid")) {
            // Logar ou lançar uma exceção específica para chave API inválida
        } else if (e.getMessage().contains("over query limit")) {
            // Logar ou lançar uma exceção específica para limite de requisições excedido
        } else {
            // Logar ou lançar uma exceção genérica
        }
    }
}