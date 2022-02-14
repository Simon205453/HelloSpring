package com.example.firsttimetest.HelloTest;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HelloTest {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @GetMapping("/RequestParam")
    public String HelloLoop(@RequestParam String id){
        return "ID: " + id;
        //http://localhost:8080/RequestParam?id=hej
    }

    @GetMapping("/erdetfredag")
    public String fredaaaag() {
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        if(LocalDate.now().getMonthValue() == 1){
            currentMonth = 13;
        } else if(LocalDate.now().getMonthValue() == 2){
            currentMonth = 14;
        }; //month (jan + feb  counts as  13 + 14
        int currentDay = LocalDate.now().getDayOfMonth();
        int k = currentYear % 100; // The year of the century
        int j = (int) (currentYear / 100.0); // the century
        int q = currentDay; //day
        int m = currentMonth;
        int h = (q + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;

        int d = ((h + 5) % 7) + 1;

        String theDay = "";

        switch (d) {
            case 0:
                theDay = "Saturday";
                break;
            case 1:
                theDay = "Sunday";
                break;
            case 2:
                theDay = "Monday";
                break;
            case 3:
                theDay = "Tuesday";
                break;
            case 4:
                theDay = "Wednesday";
                break;
            case 5:
                theDay = "Thursday";
                break;
            default:
                theDay = "DET ER FREDAG!";
        }
        return theDay;
    }


}
