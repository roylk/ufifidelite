/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.fidelisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfClient;
import com.ufi.fidelite.entities.UfOffre;
import com.ufi.fidelite.entities.UfPalier;
import com.ufi.fidelite.entities.UfTypeOffre;
import com.ufi.fidelite.entities.mirrors.ClientMirror;
import com.ufi.fidelite.entities.mirrors.OffreMirror;
import com.ufi.fidelite.entities.mirrors.PalierMirror;
import com.ufi.fidelite.service.client.IClientService;
import com.ufi.fidelite.service.commercant.ICommercantService;
import com.ufi.fidelite.service.fidelisation.IFidelisationService;
import com.ufi.fidelite.service.regionalisation.IRegionalisationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
public class FidelisationRestController {
    
      @Autowired
    private ICommercantService commercantService;
     @Autowired
    private IRegionalisationService regionalisationService;
     @Autowired
    private IClientService clientService;
     
      @Autowired
    private IFidelisationService fidelisationService;
      
      
      
    @RequestMapping(value = "/typeoffre", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	
            public Reponse saveTypeOffre(@RequestBody UfTypeOffre type ) {
            
            UfTypeOffre t;
            
            //return  commercantService.saveCommercant(commercant);
           t= fidelisationService.saveTypeOffre(type);

		if (t != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
        
        @RequestMapping(value = "/typeoffres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfTypeOffre> getAllTypeOffre(){
	
		return fidelisationService.listeTypeOffre(); 
	}
        
         @RequestMapping(value = "/typeoffresR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllTypeOffres(){
           
            Reponse rep=null;
             try{
               rep=fidelisationService.getAllTypeOffre();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
	
		
	}
       
	// recherche par id
	@RequestMapping(value = "/typeoffres/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UfTypeOffre getTypeOffre(@PathVariable("code") String code) {
		return fidelisationService.searchTypeOffre(code);
	}
        
        // mise à jour
	@RequestMapping(value = "/typeoffres/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateTypeOffre(@RequestBody UfTypeOffre t, @PathVariable("code") String code) {
            
            t.setCode(code);
            
		t = fidelisationService.updateTypeOffre(t);
                
                
		if (t != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                
        }      
                
	@RequestMapping(value = "/typeoffres/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTypeOffre(@PathVariable("code") String code) {
		fidelisationService.deleteTypeOffre(code);
	}
        
         @RequestMapping(value = "/offre", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	
            public Reponse saveOffre(@RequestBody OffreMirror offreM ) {
            
             UfOffre offre = new UfOffre();
            System.out.println("=============="+offreM.getCode());
           offre.setCode(offreM.getCode());
           System.out.println("=============="+offreM.getDateDebut());
           offre.setDateDebut(offreM.getDateDebut());
            System.out.println("=============="+offreM.getDateFin());
           offre.setDateFin(offreM.getDateFin());
            System.out.println("=============="+offreM.getLibele());
           offre.setLibele(offreM.getLibele());
            System.out.println("=============="+offreM.getOrientation());
           offre.setOrientation(offreM.getOrientation());
            System.out.println("=============="+offreM.getStatut());
           offre.setStatut(offreM.getStatut());
           offre.setTypeOffre(fidelisationService.searchTypeOffre(offreM.getTypeOffre()));
           offre.setCategorieCarte(commercantService.searchCategorieCarte(offreM.getCategorieCarte()));
             
            //return  commercantService.saveCommercant(commercant);
           offre= fidelisationService.saveOffre(offre);

		if (offre != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
        @RequestMapping(value = "/offres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfOffre> getAllOffre(){
	
		return fidelisationService.listeOffre();
	}
        
         @RequestMapping(value = "/offresR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllOffres(){
            Reponse rep=null; 
            try{
               rep=fidelisationService.getAllOffre();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
	}
        
        
         // liste des produits page par page
	@RequestMapping(value = "/poffres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllOffre( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
             Reponse rep=null; 
            try{
               rep=fidelisationService.listeOffre(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		//return fidelisationService.listeOffre(new PageRequest(page, size));       
	}
        
        // mise à jour
	@RequestMapping(value = "/offres/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateOffre(@RequestBody OffreMirror o, @PathVariable("id") Integer id) {
            
            UfOffre offre = new UfOffre();
            
           offre.setId(id);
           System.out.println("1=============="+o.getCode());
           offre.setCode(o.getCode());
           System.out.println("2=============="+o.getDateDebut());
           offre.setDateDebut(o.getDateDebut());
           System.out.println("3=============="+o.getDateFin());
           offre.setDateFin(o.getDateFin());
           System.out.println("4=============="+o.getLibele());
           offre.setLibele(o.getLibele());
            System.out.println("5=============="+o.getOrientation());
           offre.setOrientation(o.getOrientation());
           offre.setStatut(o.getStatut());
           offre.setTypeOffre(fidelisationService.searchTypeOffre(o.getTypeOffre()));
           offre.setCategorieCarte(commercantService.searchCategorieCarte(o.getCategorieCarte()));
             
            //return  commercantService.saveCommercant(commercant);
           offre= fidelisationService.updateOffre(offre);

		if (offre != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
        
        @RequestMapping(value = "/offres/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteOffre(@PathVariable("id") Integer id) {
		fidelisationService.deleteOffre(id);
	}
        
      
      
     @RequestMapping(value = "/palier", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	
            public Reponse savePalier(@RequestBody PalierMirror palierM ) {
            
             UfPalier palier = new  UfPalier();
           System.out.println("1=============="+palierM.getMontantInf()); 
           palier.setMontantInf(palierM.getMontantInf());
           System.out.println("2=============="+palierM.getMontantSup());
           palier.setMontantSup(palierM.getMontantSup());
           System.out.println("3=============="+palierM.getUniteDevise());
           palier.setUniteDevise(palierM.getUniteDevise());
           System.out.println("4=============="+palierM.getUnitePoint());
           palier.setUnitePoint(palierM.getUnitePoint());
            System.out.println("5=============="+palierM.getOffre());
           palier.setOffre(fidelisationService.getOneOffre(palierM.getOffre()));
          
            //return  commercantService.saveCommercant(commercant);
           palier= fidelisationService.savePalier(palier);

		if (palier != null) {

			return new Reponse(1, "enregistré avec succes",null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
        @RequestMapping(value = "/paliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfPalier> getAllPalier(){
	
		return fidelisationService.listePalier();
	}
        
         @RequestMapping(value = "/paliersR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPaliers(){
            Reponse rep=null; 
            try{
               rep=fidelisationService.getAllPallier();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
	
		
	}
        
        
        
        
         // liste des produits page par page
	@RequestMapping(value = "/ppaliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPalier( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
            Reponse rep=null; 
            try{
               rep=fidelisationService.listePalier(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	  
		//return fidelisationService.listePalier(new PageRequest(page, size));       
	}
        
        // mise à jour
	@RequestMapping(value = "/paliers/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updatePalier(@RequestBody PalierMirror p, @PathVariable("id") Integer id) {
            
            UfPalier palier = new UfPalier();
            
           palier.setId(id);
           palier.setMontantInf(p.getMontantInf());
           palier.setMontantSup(p.getMontantSup());
           palier.setUniteDevise(p.getUniteDevise());
           palier.setUnitePoint(p.getUnitePoint());
           palier.setOffre(fidelisationService.getOneOffre(p.getOffre()));
          
            //return  commercantService.saveCommercant(commercant);
           palier= fidelisationService.updatePalier(palier);

		if (palier != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
        
        @RequestMapping(value = "/paliers/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletePalier(@PathVariable("id") Integer id) {
		fidelisationService.deletePalier(id);
	} 
     
     

    public FidelisationRestController() {
    }
    
    
    
    
    
}
