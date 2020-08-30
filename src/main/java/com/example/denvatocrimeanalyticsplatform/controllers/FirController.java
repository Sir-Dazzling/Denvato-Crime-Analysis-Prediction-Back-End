package com.example.denvatocrimeanalyticsplatform.controllers;

import com.example.denvatocrimeanalyticsplatform.dao.FirRepository;
import com.example.denvatocrimeanalyticsplatform.dao.LGARepository;
import com.example.denvatocrimeanalyticsplatform.dao.UserRepository;
import com.example.denvatocrimeanalyticsplatform.model.ELocalGovtArea;
import com.example.denvatocrimeanalyticsplatform.model.FIR;
import com.example.denvatocrimeanalyticsplatform.model.LocalGovtArea;
import com.example.denvatocrimeanalyticsplatform.model.User;
import com.example.denvatocrimeanalyticsplatform.payload.request.FirRequest;
import com.example.denvatocrimeanalyticsplatform.payload.response.MessageResponse;
import com.example.denvatocrimeanalyticsplatform.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fir")
public class FirController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    LGARepository lgaRepository;

    @Autowired
    FirRepository firRepository;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/submit_form")
    public ResponseEntity<?> submitFir(@Valid @RequestBody FirRequest firRequest, Authentication authentication)
    {
        //Getting user session details
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        //Getting Reporter object
        Optional<User> reporter = userRepository.findByUsernameOrEmail(userDetails.getUsername(), userDetails.getEmail());

        //Getting Local govt object
        Optional<LocalGovtArea> localGovtArea =  lgaRepository.findByName(ELocalGovtArea.IKEJA);

        //Getting fir as ana object from user post request
        FIR fir = new FIR(reporter.get(), firRequest.getFirAccused(), firRequest.getEventDate(), firRequest.getTimeOfFir(), localGovtArea.get(), "Lagos", firRequest.getReporterAddress(), firRequest.getAccusedAddress(), firRequest.getReporterFirNarration());

        System.out.println(firRequest.getReporterFirNarration());
        //Saving Fir report object
        firRepository.save(fir);

        return ResponseEntity.ok(new MessageResponse("FIR saved successfully"));
    }
}
