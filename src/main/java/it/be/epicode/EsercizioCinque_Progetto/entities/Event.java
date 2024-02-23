//package it.be.epicode.EsercizioCinque_Progetto.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
//@Data
//@Entity
//@Table(name = "events")
//@NoArgsConstructor
//@AllArgsConstructor
//public class Event  {
//    @Id
//    @GeneratedValue
//    private UUID id;
//    private String title;
//    private String description;
//    private Date date;
//    private String location;
//private RoomStatus roomStatus;
//    @ManyToOne
//    private Guest guest;
//
//    public Event(String title, String description, Date date, String location, RoomStatus roomStatus, Guest guest) {
//        Random random = new Random();
//        int pick = new Random().nextInt(RoomStatus.values().length);
//        this.title = title;
//        this.description = description;
//        this.date = date;
//        this.location = location;
//        this.roomStatus = RoomStatus.values()[pick];
//        this.guest = guest;
//    }
//
//
//}

