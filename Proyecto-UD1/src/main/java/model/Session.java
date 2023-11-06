package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Session {
    private User user;
    private final File file = new File("session.log");

    public Session() {
        this.user = null;
    }

    public void inicioSesion(User user){
        this.user = user;
        String login =LocalDate.now() + " " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + user.getName() + " LOGIN";
        System.out.println(login);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            bw.write(login + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cierreSesion(){
        String logout =LocalDate.now() + " " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + user.getName() + " LOGOUT";
        System.out.println(logout);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            bw.write(logout + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.user = null;
    }



}

