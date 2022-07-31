package com.calendar.webcalendar.service;

import com.calendar.webcalendar.model.ReservationsModel;
import com.calendar.webcalendar.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    @Autowired
    public List<ReservationsModel> getReservations() {
        return reservationsRepository.findAll();
    }

    public void addNewReservation(ReservationsModel reservationsModel) {
        Optional<ReservationsModel> reservationsByDateAndStart = reservationsRepository
                .findReservationsModelByDateAndStart(
                        reservationsModel.getDate(),
                        reservationsModel.getStart()
                );


        if (reservationsByDateAndStart.isPresent()) {
            throw new IllegalStateException("this reservationSlot (Date and Start) is already taken: reservation present in database");
        }

        reservationsRepository.save(reservationsModel);

        System.out.println(reservationsModel);

    }

}
