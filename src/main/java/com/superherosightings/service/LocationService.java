package com.superherosightings.service;

import com.superherosightings.model.SuperDto;

import java.util.List;

public interface LocationService {
    public List<SuperDto> fetchSupersByLocation(int locationId);
}
