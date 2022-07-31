package com.calendar.webcalendar.service;

import com.calendar.webcalendar.model.AvailabilitiesModel;
import com.calendar.webcalendar.repository.AvailabilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilitiesService {

    private final AvailabilitiesRepository availabilityRepository;

    public AvailabilitiesService(AvailabilitiesRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Autowired
    public List<AvailabilitiesModel> getAvailability() {
        return availabilityRepository.findAll();
    }

    public void addNewAvailability(AvailabilitiesModel availabilitiesModel) {
        Optional<AvailabilitiesModel> availableByDateAndStart = availabilityRepository
                .findAvailabilitiesModelByDateAndStart(
                        availabilitiesModel.getDate(),
                        availabilitiesModel.getStart()
                );

        //si elle est pas presente dans reservation alors je peux la cree
        //si elle est dans reservation ou availabilties alors je la cree pas
        if (availableByDateAndStart.isPresent()) {
            throw new IllegalStateException("this availabilitySlot (Date and Start) is not available: availability empty in database");
        }

        availabilityRepository.save(availabilitiesModel);

        System.out.println(availabilitiesModel);
    }

    //	public List<String> hello() {
//		//need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
//		return List.of("Hello", "World!");
//	}

}
