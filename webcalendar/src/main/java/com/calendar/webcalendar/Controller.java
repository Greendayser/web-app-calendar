package com.calendar.webcalendar;

import com.calendar.webcalendar.model.AvailabilitiesModel;
import com.calendar.webcalendar.model.ReservationsModel;
import com.calendar.webcalendar.service.AvailabilitiesService;
import com.calendar.webcalendar.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    // ########################################AVAILABILITIES############################################

    //List the availabilities
    @GetMapping("/availabilities/get")
    public List<AvailabilitiesModel> getAllAvailabilities() {
        return availabilityService.getAllAvailabilities();
    }

    @GetMapping("availabilities/get/day/{slotDate}") //slotDate = date of the day select in the front
    public Collection<Optional<AvailabilitiesModel>> getAvailabilitiesOfDay(@PathVariable("slotDate") String date)
    {
        return availabilityService.getAvailabilityOfDay(date);
    }

    @PostMapping("/availabilities/post")
    public void createAvailability(@RequestBody AvailabilitiesModel availabilitiesModel) {
        availabilityService.addNewAvailability(availabilitiesModel);
    }

    @DeleteMapping(path = "/availabilities/delete/{slotId}")
    public void deleteAvailability(@PathVariable("slotId") Long availabilityId) {
        availabilityService.deleteSlotAvailability(availabilityId);
    }

    // ########################################RESERVATIONS#################################

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

    @DeleteMapping(path = "/reservations/delete")
    public void deleteReservation(@RequestBody ReservationsModel reservationsModel) {
        reservationsService.deleteSlotReservation(reservationsModel);
    }


//	@GetMapping
//	public List<String> hello() {
//		//need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
//		return List.of("Hello", "World!");
//	}
}
