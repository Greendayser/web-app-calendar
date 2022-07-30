package com.calendar.webcalendar;

import com.calendar.webcalendar.model.AvailabilitiesModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "calendar/availabilities")
public class Controller {

    @GetMapping
    public List<AvailabilitiesModel> getAvailability() {
        //need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
        return List.of(
                new AvailabilitiesModel(1L ,"Sat Jul 30 2022", "09:00", "09:15")
        );
    }

//	@GetMapping
//	public List<String> hello() {
//		//need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
//		return List.of("Hello", "World!");
//	}
}
