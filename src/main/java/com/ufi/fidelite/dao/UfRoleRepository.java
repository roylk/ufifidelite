/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author R. KOUANI
 */
public interface UfRoleRepository extends JpaRepository<UfRole, Integer> {
    
}
