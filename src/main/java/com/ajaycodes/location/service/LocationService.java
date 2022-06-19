package com.ajaycodes.location.service;

import com.ajaycodes.location.entities.Location;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface LocationService {

    Location saveLocation(Location location) throws MessagingException;

    Location updateLocation(Location location);

    void deleteLocation(Location location);

    Location getLocationById(Long id);

    List<Location> getAllLocations();

    void generateLocationReport() throws IOException;
}
