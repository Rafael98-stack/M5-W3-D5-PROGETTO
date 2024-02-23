//package it.be.epicode.EsercizioCinque_Progetto.controllers;
//
//import it.be.epicode.EsercizioCinque_Progetto.payloads.*;
//import org.apache.catalina.Manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthManagerController {
//    @Autowired
//    private AuthManagerService authManagerService;
//
//
//    @PostMapping("/loginManager")
//    public LoginResponseDTO login(@RequestBody ManagerLoginDTO payload) {
//        return new LoginResponseDTO(authManagerService.authenticateManagerAndGenerateToken(payload));
//    }
//
//    @PostMapping("/registerManager")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Manager saveGuest(@RequestBody NewManagerDTO newManager) {
//
//        return this.authManagerService.saveManager(newManager);
//    }
//}
