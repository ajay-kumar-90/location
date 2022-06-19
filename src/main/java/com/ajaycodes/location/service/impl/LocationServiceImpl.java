package com.ajaycodes.location.service.impl;

import com.ajaycodes.location.entities.Location;
import com.ajaycodes.location.exception.LocationNotFoundException;
import com.ajaycodes.location.repositories.LocationRepository;
import com.ajaycodes.location.service.LocationService;
import com.ajaycodes.location.utils.EmailUtil;
import com.ajaycodes.location.utils.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final EmailUtil emailUtil;
    private final ReportUtil reportUtil;
    private final ServletContext servletContext;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, EmailUtil emailUtil, ReportUtil reportUtil, ServletContext servletContext) {
        this.locationRepository = locationRepository;
        this.emailUtil = emailUtil;
        this.reportUtil = reportUtil;
        this.servletContext = servletContext;
    }

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public Location saveLocation(Location location) throws MessagingException {
        Location savedLocation = locationRepository.save(location);
        //sendEmail(location);
        return savedLocation;
    }

    private void sendEmail(Location location) throws MessagingException {
        emailUtil.sendEmail(username + "@gmail.com", "Location Saved", "Location Saved Successfully with id " + location.getId());
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public Location getLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isEmpty()) {
            throw new LocationNotFoundException("Location doesn't exist with " + id);
        }
        return locationOptional.get();
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }


    @Override
    public void generateLocationReport() throws IOException {

        // Get path using Servlet Context's getRealPath method by passing web app root path to store image.
        // Jsp can load image from this path
        String path = servletContext.getRealPath("/");
        // Get data from DB

        List<Object[]> data = locationRepository.findTypeAndTypeCount();

        // call util Functionality

        reportUtil.generatePieChart(path, data);


    }
}
