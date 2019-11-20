/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.authentification;

import com.ufi.fidelite.dao.UfCarteRepository;
import com.ufi.fidelite.dao.UfClientRepository;
import com.ufi.fidelite.dao.UfTransactionRepository;
import com.ufi.fidelite.dao.UfUtilisateurRepository;
import com.ufi.fidelite.entities.UfUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R. KOUANI
 */
@Service
@Transactional
public class AuthentificationServiceImpl implements IAuthentificationService {

    @Autowired
    UfClientRepository clientRepository;

    @Autowired
    UfCarteRepository carteRepository;

    @Autowired
    UfTransactionRepository transactionRepository;

    @Autowired
    UfUtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean searchExistsUser(String login, String motDePasse) {
        UfUtilisateur user;
        user = searchUserByLogin(login);
        if (user != null) {
            return passwordEncoder.encode(motDePasse).equals(user.getMotDePasse());
        } else {
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistUserByString(String code) {
        return utilisateurRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfUtilisateur searchUserByLogin(String code) {
        return utilisateurRepository.findbyLogin(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
