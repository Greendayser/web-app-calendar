package com.calendar.webcalendar;

import com.calendar.webcalendar.model.AvailabilitiesModel;
import com.calendar.webcalendar.model.ReservationsModel;
import com.calendar.webcalendar.service.AvailabilitiesService;
import com.calendar.webcalendar.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "calendar")
public class Controller {

    private final AvailabilitiesService availabilityService;

    private final ReservationsService reservationsService;

    @Autowired
    public Controller(AvailabilitiesService availabilityService, ReservationsService reservationsService) {
        this.availabilityService = availabilityService;
        this.reservationsService = reservationsService;
    }

    //Availabilities

    //List the availabilities
    @GetMapping("/availabilities/get")
    public List<AvailabilitiesModel> getAvailability() {
        return availabilityService.getAvailability();
    }

    @PostMapping("/availabilities/post")
    public void createAvailabilty(@RequestBody AvailabilitiesModel availabilitiesModel) {
        availabilityService.addNewAvailability(availabilitiesModel);
    }

    //Reservations

    //List the reservations
    @GetMapping("/reservations/get")
    public List<ReservationsModel> getReservation() {
        return reservationsService.getReservations();
    }

    //create a reservation and later delete from availability
    @PostMapping("/reservations/post")
    public void createReservation(@RequestBody ReservationsModel reservationsModel) {
        reservationsService.addNewReservation(reservationsModel);
    }


//	@GetMapping
//	public List<String> hello() {
//		//need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
//		return List.of("Hello", "World!");
//	}
}
