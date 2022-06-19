package com.ajaycodes.location.controllers;

import com.ajaycodes.location.entities.Location;
import com.ajaycodes.location.service.LocationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static com.ajaycodes.location.constant.LocationConstant.DISPLAY_LOCATIONS;
import static com.ajaycodes.location.constant.LocationConstant.LOCATIONS;

@Controller
@RequestMapping("/api/v1/")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/showAddLocation")
    public String showSaveLocation() {
        return "saveLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, @NotNull ModelMap modelMap) throws MessagingException {
        // Service layer call to save entity
        Location savedLocation = locationService.saveLocation(location);
        //Create a Success message And send back success message back to UI using model map
        String msg = "Location saved Successfully with id " + savedLocation.getId();
        modelMap.addAttribute("msg", msg);
        return "saveLocation";
    }

    @RequestMapping(value = "/displayLocations")
    public String showAllLocations(@NotNull ModelMap modelMap) {
        // Service layer call to get all entities
        List<Location> allLocations = locationService.getAllLocations();
        //Send back all Entities to UI using model map
        modelMap.addAttribute(LOCATIONS, allLocations);
        return DISPLAY_LOCATIONS;
    }

    @RequestMapping(value = "/deleteLocation")
    public String deleteLocation(@RequestParam("id") long id, @NotNull ModelMap modelMap) {
        // create Entity object and pass id
        Location location = new Location();
        location.setId(id);
        // Service layer call to delete entity
        locationService.deleteLocation(location);
        // Get remaining entities and send back them to UI using model map
        List<Location> allLocations = locationService.getAllLocations();
        modelMap.addAttribute(LOCATIONS, allLocations);
        return DISPLAY_LOCATIONS;
    }

    @RequestMapping(value = "/showUpdateLocation")
    public String showUpdateLocation(@RequestParam("id") long id, @NotNull ModelMap modelMap) {
        // Service layer call to get entity using id
        Location savedLocation = locationService.getLocationById(id);
        // Send back the Entity to UI page using model map
        modelMap.addAttribute("location", savedLocation);
        // Get remaining entities and send back them to UI using model map
        return "updateLocation";
    }

    @RequestMapping(value = "/updateLocation")
    public String updateLocation(@ModelAttribute("location") Location location, @NotNull ModelMap modelMap) throws MessagingException {
        // Service layer call to update entity
        locationService.saveLocation(location);
        // Get All entities and send back them to UI using model map
        List<Location> allLocations = locationService.getAllLocations();
        modelMap.addAttribute(LOCATIONS, allLocations);
        return DISPLAY_LOCATIONS;
    }

    @RequestMapping(value = "/generateReport")
    public String generateLocationReport() throws IOException {

    locationService.generateLocationReport();

        return "locationReport";
    }

}
