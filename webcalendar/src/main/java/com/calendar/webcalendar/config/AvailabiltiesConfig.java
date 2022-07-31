package com.calendar.webcalendar.config;

import com.calendar.webcalendar.model.AvailabilitiesModel;
import com.calendar.webcalendar.repository.AvailabilitiesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AvailabiltiesConfig {

    @Bean
    CommandLineRunner commandLineRunnerAvailabilities(AvailabilitiesRepository availabilityRepository) {
        return args -> {
            //need to find a way to convert Sat Jul 30 2022 in front to 2022-07-30 the localDateFormat => then change attribut to String to LocalDate in model
            AvailabilitiesModel slot1 = new AvailabilitiesModel(LocalDate.of(2022, Month.JULY, 30), "09:00", "09:15"); //"Sat Jul 30 2022" => "2022-07-30"

            AvailabilitiesModel slot2 = new AvailabilitiesModel(LocalDate.of(2022, Month.JULY, 29), "09:15", "09:30"); // "Fri Jul 29 2022" => 2022-07-29

            availabilityRepository.saveAll(
                    List.of(slot1, slot2)
            );

        };
    }
}
