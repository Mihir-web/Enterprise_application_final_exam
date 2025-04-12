package com.mh.spring.finalex.controller;

import com.mh.spring.finalex.model.Reservation;
import com.mh.spring.finalex.model.Payment;
import com.mh.spring.finalex.repository.ReservationRepository;
import com.mh.spring.finalex.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PaymentRepository paymentRepository;

   

    @GetMapping("/")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationForm";
    }

    @PostMapping("/submitReservation")
    public String submitReservation(@ModelAttribute("reservation") Reservation reservation,
                                    @RequestParam("amount") Double amount,
                                    @RequestParam("method") String method,
                                    @RequestParam("status") String status,
                                    Model model) {

        
        Payment payment = new Payment(amount, method, status);
        Payment savedPayment = paymentRepository.save(payment);

       
        reservation.setPaymentId(savedPayment.getId());
       
       
        Reservation savedReservation = reservationRepository.save(reservation);

       
        model.addAttribute("reservation", savedReservation);
        model.addAttribute("payment", savedPayment);

        return "confirmation";
    }

}
