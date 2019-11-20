/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.authenfication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author R. KOUANI
 */
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ufifidelite/api")
public class AuthentificationRestController {

    public AuthentificationRestController() {
    }
    
    
}
