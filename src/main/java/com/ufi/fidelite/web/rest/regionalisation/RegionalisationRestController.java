/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.regionalisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.Conversion;
import com.ufi.fidelite.entities.UfPays;
import com.ufi.fidelite.entities.UfPointDeVente;
import com.ufi.fidelite.entities.UfRegion;
import com.ufi.fidelite.entities.UfVille;
import com.ufi.fidelite.entities.mirrors.RegionMirror;
import com.ufi.fidelite.entities.mirrors.VilleMirror;
import com.ufi.fidelite.entities.mirrors.conversionMirror;
import com.ufi.fidelite.service.regionalisation.IRegionalisationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author R. KOUANI
 */
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ufifidelite/api")
public class RegionalisationRestController {
    
    @Autowired
   private IRegionalisationService regionalisationService;
    
//    @RequestMapping(value = "/pays", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public UfPays savePays(@RequestBody UfPays pays) {
//		return regionalisationService.SavePays(pays);
//	}
        
  @RequestMapping(value = "/pays", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse savePays(@RequestBody UfPays pays) {
            UfPays p;
            p= regionalisationService.SavePays(pays);
            if (p != null) {

			return new Reponse(1, "enregistré  avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
	}
        
        
     @RequestMapping(value = "/payss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfPays> getAllPays(){
	
		return regionalisationService.listePays();
	}
        
         @RequestMapping(value = "/payssR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPayss(){
                Reponse rep=null; 
            try{
               rep=regionalisationService.GetAllPays();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;
	
	}
        
        @RequestMapping(value = "/ppayss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPays( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
            Reponse rep=null; 
            try{
               rep=regionalisationService.listePays(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
		//return fidelisationService.listePalier(new PageRequest(page, size));       
	}
        
      @RequestMapping(value = "/payss/{code}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updatePays(@RequestBody UfPays pays, @PathVariable("code") String code) {
            
            pays.setCode(code);
            
            UfPays p;
            p= regionalisationService.updatePays(pays);

		if (p != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
            
            
        }
        
     @RequestMapping(value = "/payss/{code}", method = RequestMethod.DELETE)
	public void deletePays(@PathVariable("code") String code) {
		regionalisationService.deletePays(code);
	}
        
    
        
   @RequestMapping(value = "/region", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse saveRegion(@RequestBody RegionMirror regionM) {
            UfRegion region = new UfRegion();
            
            region.setCode(regionM.getCode());
            region.setNom(regionM.getNom());
            region.setDateCreation(regionM.getDateCreation());
            region.setPays(regionalisationService.getOnePays(regionM.getPays())); 
            region.setDescription(regionM.getDescription());
            //return  commercantService.saveCommercant(commercant);
           region= regionalisationService.saveRegion(region);

		if (region != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
	}
        
        
         @RequestMapping(value = "/regions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfRegion> getAllRegion(){
	
		return regionalisationService.listeRegion();
	}
        
         @RequestMapping(value = "/regionsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllRegions(){
              Reponse rep=null; 
            try{
               rep=regionalisationService.getAllRegion();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;
		
	}
        
        @RequestMapping(value = "/pregions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllRegion( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
            Reponse rep=null; 
            try{
               rep=regionalisationService.listeRegion(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
		//return fidelisationService.listePalier(new PageRequest(page, size));       
	}
        
         @RequestMapping(value = "/regionparpays", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfRegion> getAllRegionByPays(String codeP){
	
		return regionalisationService.getAllRegionByPays(codeP);
	}
        
        @RequestMapping(value = "/villeparregion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfVille> getAllVilleByPays(String codeR){
	
		return regionalisationService.getAllVilleByRegion(codeR);
	}
        
        @RequestMapping(value = "/pvilles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllVille( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
            Reponse rep=null; 
            try{
               rep=regionalisationService.listeVille(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
		//return fidelisationService.listePalier(new PageRequest(page, size));       
	}
        
        
         // mise à jour
	@RequestMapping(value = "/regions/{id}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRegion(@RequestBody RegionMirror r, @PathVariable("id") Integer id) {
            
            UfRegion region = new UfRegion();
            
            region.setId(id);
            
            region.setCode(r.getCode());
            region.setNom(r.getNom());
            region.setDateCreation(r.getDateCreation());
            region.setPays(regionalisationService.getOnePays(r.getPays())); 
            //return  commercantService.saveCommercant(commercant);
            region.setDescription(r.getDescription());
            
           region= regionalisationService.updateRegion(region);
            
		if (region != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
            
	}

    @RequestMapping(value = "/regions/{id}", method = RequestMethod.DELETE)
	public void deleteRegion(@PathVariable("id") Integer id) {
		regionalisationService.deleteRegion(id);
	}
    
    @RequestMapping(value = "/ville", method = RequestMethod.POST)
	public Reponse saveVille(@RequestBody VilleMirror villeM) {
            UfVille ville = new UfVille();
            
            ville.setCode(villeM.getCode());
            ville.setNom(villeM.getNom());
            ville.setDateCreation(villeM.getDateCreation());
            ville.setRegion(regionalisationService.getOneRegion(villeM.getRegion())); 
            //return  commercantService.saveCommercant(commercant);
            ville.setDescription(villeM.getDescription());
           ville= regionalisationService.saveVille(ville);

		if (ville != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
	}  
        
        
         @RequestMapping(value = "/villes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfVille> getAllVille(){
	
		return regionalisationService.listeVille();
	}
        
         @RequestMapping(value = "/villesR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllVilles(){
             Reponse rep=null; 
            try{
               rep=regionalisationService.getAllVille();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        @RequestMapping(value = "/villes/{id}", method = RequestMethod.PUT ,produces = MediaType.APPLICATION_JSON_VALUE )
	public Reponse updateVille(@RequestBody VilleMirror v, @PathVariable("id") Integer id) {
            UfVille ville = new UfVille();
            
            ville.setId(id);
            
            ville.setCode(v.getCode());
            ville.setNom(v.getNom());
            ville.setDateCreation(v.getDateCreation());
            ville.setRegion(regionalisationService.getOneRegion(v.getRegion())); 
            //return  commercantService.saveCommercant(commercant);
             ville.setDescription(v.getDescription());
            ville= regionalisationService.updateVille(ville);

		if (ville != null) {

			return new Reponse(1, "mis à jour  avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                 
        }
        
         @RequestMapping(value = "/villes/{id}", method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteVille(@PathVariable("id") Integer id) {
		regionalisationService.deleteVille(id);
	}
              

    public RegionalisationRestController() {
    }
    
    
    
}
