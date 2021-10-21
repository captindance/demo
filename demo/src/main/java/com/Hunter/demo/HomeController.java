package com.Hunter.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;



@RestController
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/supervisors")
    public List<String> home(){
        String url = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
        supervisors[] supervisorsList = restTemplate.getForObject(url, supervisors[].class);
        Arrays.sort(supervisorsList);

        ArrayList<String> supervisorsResponse = new ArrayList<String>();
        //Loop over supervisors and make the string
        for(int i = 0; i < supervisorsList.length ;i++) {
            //but omit any that have a numeric Jurisdiction
            if (!supervisorsList[i].isNumberic(supervisorsList[i].getJurisdiction())) {
                supervisorsResponse.add(supervisorsList[i].getJurisdiction() + " - " +
                        supervisorsList[i].getLastName() + ", " + supervisorsList[i].getFirstName());
            }
        }
        //Note I could easily return objects with a key, but the requirements stated it wanted strings instead
        //Return the arraylist of supervisors in the formatted string
        return supervisorsResponse;

        }

        @PostMapping("/api/submit")
        public ResponseEntity<String> Submit(@RequestBody supervisors supervisor){
            //I should make a toString method in my supervisors class and use that instead
            System.out.println("firstName: " + supervisor.getFirstName() +
                    " lastName: " + supervisor.getLastName() +
                    " supervisor: " + supervisor.getSupervisor() +
                    " email: " + supervisor.getEmail() +
                    " phoneNumber: " + supervisor.getPhone()
            );
            if(supervisor.getFirstName() == null || supervisor.getLastName() == null || supervisor.getSupervisor() == null){
                //Return an error response here
                return new ResponseEntity<String> ("firstName, lastName, and supervisor are required",HttpStatus.NOT_ACCEPTABLE);
            }
                //If no error then return good as created
            return new ResponseEntity<String> ("submitted",HttpStatus.CREATED);
        }


}
