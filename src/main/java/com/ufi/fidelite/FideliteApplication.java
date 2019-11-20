package com.ufi.fidelite;

import com.ufi.fidelite.dao.UfCommercantRepository;
import com.ufi.fidelite.dao.UfPaysRepository;
import com.ufi.fidelite.dao.UfRegionRepository;
import com.ufi.fidelite.dao.UfVilleRepository;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfPays;
import com.ufi.fidelite.entities.UfRegion;
import com.ufi.fidelite.entities.UfVille;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FideliteApplication implements CommandLineRunner{
    
    @Autowired
    private UfPaysRepository paysRepository;
    
     @Autowired
    private UfRegionRepository regionRepository;
     
    @Autowired
    private UfVilleRepository villeRepository;
    
    @Autowired
    private UfCommercantRepository commercantRepository;
    

	public static void main(String[] args) {
		SpringApplication.run(FideliteApplication.class, args);
	}
        
        @Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
                
              UfPays p1= paysRepository.save(new UfPays("CMR", "CAMEROUN", new Date(), "un pays de l'afrique centrale"));
              
              
              
                
              /*UfRegion r1 =regionRepository.save(new UfRegion("LITTORAL", "LT", new Date(), p1));
                
              UfRegion r2 =regionRepository.save(new UfRegion("CENTRE", "CE", new Date(), p1));
                
              UfVille v1=villeRepository.save(new UfVille("DLA", "DOUALA", new Date(), r1));
                
              UfVille v2=villeRepository.save(new UfVille("YDE", "YAOUNDE", new Date(), r2));*/
              
              //UfCommercant com1 = commercantRepository.save(new UfCommercant("001CMRDV001", "DOVV", "2545585555", "2554455555", "BP 00545 YAOUNDE-BASTOS", "dovv@dov.cm", villeRepository.getOne(16)));
                
              
                
                
        }

}
