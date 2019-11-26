/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.commercant;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.Conversion;
import com.ufi.fidelite.entities.UfCategorieCarte;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfPointDeVente;
import com.ufi.fidelite.entities.UfPolitiqueEvaluation;
import com.ufi.fidelite.entities.UfTerminal;
import com.ufi.fidelite.entities.mirrors.CategorieCarteMirror;
import com.ufi.fidelite.entities.mirrors.CommercantMirror;
import com.ufi.fidelite.entities.mirrors.PointDeVenteMirror;
import com.ufi.fidelite.entities.mirrors.TerminalMirror;
import com.ufi.fidelite.entities.mirrors.conversionMirror;
import com.ufi.fidelite.service.commercant.ICommercantService;
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
public class CommercantRestController {
    
    @Autowired
    private ICommercantService commercantService;
    private IRegionalisationService regionalisationService;
    
    @RequestMapping(value = "/commercant", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse saveCommercant(@RequestBody CommercantMirror commercantM ) {
            
            UfCommercant commercant = new UfCommercant();
            
            commercant.setCode(commercantM.getCode());
            commercant.setAcronyme(commercantM.getAcronyme());
            commercant.setAdresse(commercantM.getAdresse());
            commercant.setNom(commercantM.getNom());
            commercant.setEmail(commercantM.getEmail());
            commercant.setTelephone1(commercantM.getTelephone1());
            commercant.setTelephone2(commercantM.getTelephone2());
            commercant.setStatut(commercantM.getStatut());
            commercant.setVille(commercantService.getOneVilleByCode(commercantM.getVille()));
            
            boolean exists=commercantService.searchExistsCom(commercant.getCode());
            
            //return  commercantService.saveCommercant(commercant);
           //commercant = commercantService.saveCommercant(commercant);
           
		//if (commercant != null) {
                    if( exists){
                        return new Reponse(2, "Le commercant existe déjà", null);
                    }else {
                        commercant = commercantService.saveCommercant(commercant);}
                            if(commercant!=null){
                                return new Reponse(1, "Enregistré avec succes", commercant);}
                            else {
                                return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                       
        }
        
        @RequestMapping(value = "/commercants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfCommercant> getAllCommercant(){
	

		return commercantService.listeCommercant();
	}
        
         @RequestMapping(value = "/commercantsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCommercants(){
            Reponse rep=null; 
            try{
               rep=commercantService.getAllCommercant();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/pcommercants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCommercant( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
            Reponse rep=null; 
            try{
               rep=commercantService.listeCommercant(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		//return commercantService.listeCommercant(new PageRequest(page, size));       
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/rechpcommercants", method = RequestMethod.GET)
	public Page<UfCommercant> pageCommercant(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return commercantService.SearchCommercants("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/commercants/{code}", method = RequestMethod.GET)
	public UfCommercant getCommercant(@PathVariable("code") String code) {
		return commercantService.searchCommercant(code);
	}
        
        // mise à jour
	@RequestMapping(value = "/commercants/{code}", method = RequestMethod.PUT)
	public Reponse updateCommercant(@RequestBody CommercantMirror c, @PathVariable("code") String code) {
            
            UfCommercant commercant = new UfCommercant();
            
            commercant.setCode(code);
            commercant.setAcronyme(c.getAcronyme());
            commercant.setAdresse(c.getAdresse());
            commercant.setNom(c.getNom());
            commercant.setEmail(c.getEmail());
            commercant.setTelephone1(c.getTelephone1());
            commercant.setTelephone2(c.getTelephone2());
            commercant.setStatut(c.getStatut());
            commercant.setVille(commercantService.getOneVilleByCode(c.getVille()));
		
                
		commercant = commercantService.updateCommercant(commercant);
                
                
		if (commercant != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                
        }      
                
	

	@RequestMapping(value = "/commercants/{code}", method = RequestMethod.DELETE)
	public void deleteCommercant(@PathVariable("code") String code) {
		commercantService.deleteCommercant(code);
	}
        
        
        
        @RequestMapping(value = "/pointdevente", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse savePointDeVente(@RequestBody PointDeVenteMirror pointDeVenteM ) {
            
            UfPointDeVente pointDeVente = new UfPointDeVente();
            
            pointDeVente.setCode(pointDeVenteM.getCode());
            pointDeVente.setAcronyme(pointDeVenteM.getAcronyme());
            pointDeVente.setAdresse(pointDeVenteM.getAdresse());
            pointDeVente.setEmail(pointDeVenteM.getEmail());
            pointDeVente.setTelephone1(pointDeVenteM.getTelephone1());
            pointDeVente.setTelephone2(pointDeVenteM.getTelephone2());
            pointDeVente.setNom(pointDeVenteM.getNom());
            pointDeVente.setStatut(pointDeVenteM.getStatut());
            
            pointDeVente.setCommercantCode(commercantService.searchCommercant(pointDeVenteM.getCommercantCode()));
            
            pointDeVente.setVille(commercantService.getOneVilleByCode(pointDeVenteM.getVille())); 
            
            //return  commercantService.saveCommercant(commercant);
           pointDeVente= commercantService.savePointDeVente(pointDeVente);

		if (pointDeVente != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
            
            
            @RequestMapping(value = "/terminal", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse saveTerminal(@RequestBody TerminalMirror terminalM ) {
            
            UfTerminal terminal = new UfTerminal();
            
            terminal.setCode(terminalM.getCode());
            terminal.setDesignation(terminalM.getDesignation());
            terminal.setNumeroSerie(terminalM.getNumeroSerie());
            terminal.setStatut(terminalM.getStatut());
            terminal.setPointDeVente(commercantService.searchPointDeVente(terminalM.getPointDeVente()));
            
            //return  commercantService.saveCommercant(commercant);
           terminal= commercantService.saveTerminal(terminal);

		if (terminal != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
         @RequestMapping(value = "/pointsdevente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfPointDeVente> getAllPointDeVente(){
	

		return commercantService.listePointDeVente();
	}
        
         @RequestMapping(value = "/pointsdeventeR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPointDeVentes(){
            
             Reponse rep=null; 
            try{
               rep=commercantService.getAllPointDeVente();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;
		
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/ppointsdevente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPointDeVente( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
            
             Reponse rep=null; 
            try{
               rep=commercantService.listePointDeVente(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;
		//return commercantService.listePointDeVente(new PageRequest(page, size));       
	}
        
        // liste page par page
	@RequestMapping(value = "/rechppointsdevente", method = RequestMethod.GET)
	public Page<UfPointDeVente> pagePointDeVente(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return commercantService.searchPointsDeVente("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/pointsdevente/{code}", method = RequestMethod.GET)
	public UfPointDeVente getPointDeVente(@PathVariable("code") String code) {
		return commercantService.searchPointDeVente(code);
	}
        
        // mise à jour
	@RequestMapping(value = "/pointsdevente/{code}", method = RequestMethod.PUT)
	public Reponse updatePointDeVente(@RequestBody PointDeVenteMirror p, @PathVariable("code") String code) {
                
            UfPointDeVente pointDeVente = new UfPointDeVente();
            
            pointDeVente.setCode(code);
            pointDeVente.setAcronyme(p.getAcronyme());
            pointDeVente.setAdresse(p.getAdresse());
            pointDeVente.setEmail(p.getEmail());
            pointDeVente.setTelephone1(p.getTelephone1());
            pointDeVente.setTelephone2(p.getTelephone2());
            pointDeVente.setNom(p.getNom());
            pointDeVente.setStatut(p.getStatut());
            System.out.println("mendosa 8 baba  "+p.getCommercantCode());
            pointDeVente.setCommercantCode(commercantService.searchCommercant(p.getCommercantCode()));
            
            pointDeVente.setVille(commercantService.getOneVilleByCode(p.getVille())); 
            
            //return  commercantService.saveCommercant(commercant);
           pointDeVente= commercantService.updatePointsDeVente(pointDeVente);

		if (pointDeVente != null) {

			return new Reponse(1, "mis à jour  avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
               
	}

	@RequestMapping(value = "/pointsdevente/{code}", method = RequestMethod.DELETE)
	public void deletePointDeVente(@PathVariable("code") String code) {
		commercantService.deletePointsDeVente(code);
	}
        
         @RequestMapping(value = "/terminals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfTerminal> getAllTerminal(){
	

		return commercantService.listeTerminal();
	}
        
        @RequestMapping(value = "/terminalsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllTerminals(){
            
             Reponse rep=null; 
            try{
               rep=commercantService.getAllTerminal();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/pterminals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllTerminal( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
             Reponse rep=null; 
            try{
               rep=commercantService.listeTerminal(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		//return commercantService.listeTerminal(new PageRequest(page, size));       
	}
        
        // liste page par page
	@RequestMapping(value = "/rechpterminals", method = RequestMethod.GET)
	public Page<UfTerminal> pageTerminal(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return commercantService.searchTerminal("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/terminals/{code}", method = RequestMethod.GET)
	public UfTerminal getTerminal(@PathVariable("code") String code) {
		return commercantService.searchTerminal(code);
	}
        
        // mise à jour
	@RequestMapping(value = "/terminals/{code}", method = RequestMethod.PUT)
	public Reponse updateTerminal(@RequestBody TerminalMirror t, @PathVariable("code") String code) {
               UfTerminal terminal = new UfTerminal();
            
            terminal.setCode(code);
            terminal.setDesignation(t.getDesignation());
            terminal.setNumeroSerie(t.getNumeroSerie());
            terminal.setStatut(t.getStatut());
            terminal.setPointDeVente(commercantService.searchPointDeVente(t.getPointDeVente()));
            
            //return  commercantService.saveCommercant(commercant);
           terminal= commercantService.updateTerminal(terminal);

		if (terminal != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		} 
                
	}

	@RequestMapping(value = "/terminals/{code}", method = RequestMethod.DELETE)
	public void deleteTerminal(@PathVariable("code") String code) {
		commercantService.deleteTerminal(code);
	}
        
        @RequestMapping(value = "/conversion", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse saveConversion(@RequestBody conversionMirror conversionM ) {
            
                Conversion conversion = new Conversion();
            
            conversion.setNbpointInf(conversionM.getNbpointInf());
            conversion.setNbpointSup(conversionM.getNbpointSup());
            conversion.setReduction(conversionM.getReduction());
            conversion.setType(conversionM.getType());
            conversion.setCommercant(commercantService.searchCommercant(conversionM.getCommercant()));
      
            //return  commercantService.saveCommercant(commercant);
           conversion= commercantService.saveConversion(conversion);

		if (conversion != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
         @RequestMapping(value = "/conversion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfPointDeVente> getAllConversion(){
	

		return commercantService.listePointDeVente();
	}
        
          // liste des produits page par page
	@RequestMapping(value = "/pconversions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllConversion( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
             Reponse rep=null; 
            try{
               rep=commercantService.listeConversion(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		//return commercantService.listeTerminal(new PageRequest(page, size));       
	}
        
        
         @RequestMapping(value = "/conversionsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllConversions(){
            
             Reponse rep=null; 
            try{
               rep=commercantService.getAllConversion();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        
         // mise à jour
	@RequestMapping(value = "/conversions/{id}", method = RequestMethod.PUT)
	public Reponse updateConversion(@RequestBody conversionMirror c, @PathVariable("id") Integer id) {
            
            Conversion conversion = new Conversion();
            
            conversion.setId(id);
            
            conversion.setNbpointInf(c.getNbpointInf());
            conversion.setNbpointSup(c.getNbpointSup());
            conversion.setReduction(c.getReduction());
            conversion.setType(c.getType());
            conversion.setCommercant(commercantService.searchCommercant(c.getCommercant()));
      
            //return  commercantService.saveCommercant(commercant);
           conversion= commercantService.updateConversion(conversion);

		if (conversion != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
            
	}

	@RequestMapping(value = "/conversions/{id}", method = RequestMethod.DELETE)
	public void deleteConversion(@PathVariable("id") String id) {
		commercantService.deleteTerminal(id);
	}
        
         @RequestMapping(value = "/politiqueevaluation", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse savePolitiqueEvaluation(@RequestBody UfPolitiqueEvaluation politique ) {
            
             UfPolitiqueEvaluation p ;
            
           
      
            //return  commercantService.saveCommercant(commercant);
           p= commercantService.savePolitiqueEvaluation(politique);

		if (p != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
         @RequestMapping(value = "/politiqueevaluations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfPolitiqueEvaluation> getAllPolitiqueEvaluation(){
	

		return commercantService.listePolitiqueEvaluation();
	}
        
        @RequestMapping(value = "/politiqueevaluationsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPolitiqueEvaluations(){
            Reponse rep=null; 
            try{
               rep=commercantService.getAllPolitiqueEvaluation();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;		
	}
        
        
         // mise à jour
	@RequestMapping(value = "/politiqueevaluations/{code}", method = RequestMethod.PUT)
	public UfPolitiqueEvaluation  updatePolitiqueEvaluation (@RequestBody UfPolitiqueEvaluation p, @PathVariable("code") String code) {
                p.setCode(code);
		return commercantService.updatePolitiqueEvaluation(p);
	}

	@RequestMapping(value = "/politiqueevaluations/{code}", method = RequestMethod.DELETE)
	public void deletePolitiqueEvaluation(@PathVariable("code") String code) {
		commercantService.deletePolitiqueEvaluation(code);
	}
        
         @RequestMapping(value = "/categoriecarte", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	//public UfCommercant saveCommercant(@RequestBody CommercantMirror commercantM ) {
            public Reponse saveCategorieCarte(@RequestBody CategorieCarteMirror categorieM ) {
                System.out.println("***********************");
                System.out.println(categorieM.toString());
                System.out.println("***********************");
             System.out.println("mendosa");
               UfCategorieCarte categorie = new UfCategorieCarte();
               
               categorie.setCode(categorieM.getCode());
               System.out.println("mendosa 4");
               categorie.setLebelle(categorieM.getLebelle());
               System.out.println("mendosa 5");
               categorie.setPeriodicite(categorieM.getPeriodicite());
               System.out.println("mendosa 6");
               categorie.setAction(categorieM.getAction());
               System.out.println("mendosa 7");
               categorie.setStatut(categorieM.getStatut());
               System.out.println("mendosa 8 baba  "+categorieM.getPolitiqueEvaluation());
               categorie.setPolitiqueEvaluation(commercantService.searchPolitiqueEvaluation(categorieM.getPolitiqueEvaluation()));
               System.out.println("mendosa 9");
               categorie.setCommercant(commercantService.searchCommercant(categorieM.getCommercant())); 
               
            
      
            //return  commercantService.saveCommercant(commercant);
             System.out.println("##############################");
             System.out.println(categorie.toString());
             System.out.println("##############################");
           categorie= commercantService.saveCategorieCarte(categorie);

		if (categorie != null) {

			return new Reponse(1, "enregistré avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
            
         @RequestMapping(value = "/categoriecartes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfCategorieCarte> getAllCategorieCarte(){
	

		return commercantService.listeCategorieCarte();
	}
        
         @RequestMapping(value = "/categoriecartesR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCategorieCartes(){
             Reponse rep=null; 
            try{
               rep=commercantService.getAllCategorieCarte();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0); 
                rep.setMessage(e.getMessage());
            }
            return rep;	
	
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/pcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCategorieCarte( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
             Reponse rep=null; 
            try{
               rep=commercantService.listeCategorieCarte(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
		//return commercantService.listeTerminal(new PageRequest(page, size));       
	}
        
        
         // mise à jour
	@RequestMapping(value = "/categoriecartes/{code}", method = RequestMethod.PUT)
	public Reponse updateCategorieCarte(@RequestBody CategorieCarteMirror c, @PathVariable("code") String code) {
                
            UfCategorieCarte categorie = new UfCategorieCarte();
               
               categorie.setCode(code);
               categorie.setLebelle(c.getLebelle());
               categorie.setPeriodicite(c.getPeriodicite());
               categorie.setAction(c.getAction());
               categorie.setStatut(c.getStatut());
               System.out.println("mendosa 8 baba  "+c.getPolitiqueEvaluation());
               categorie.setPolitiqueEvaluation(commercantService.searchPolitiqueEvaluation(c.getPolitiqueEvaluation()));
               System.out.println("mendosa 8 baba  "+c.getCommercant());
               categorie.setCommercant(commercantService.searchCommercant(c.getCommercant())); 
               
            //return  commercantService.saveCommercant(commercant);
           categorie= commercantService.updateCategorieCarte(categorie);

		if (categorie != null) {

			return new Reponse(1, "mis à jour avec succès", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                
	}

	@RequestMapping(value = "/categoriecartes/{code}", method = RequestMethod.DELETE)
	public void deleteCategorieCarte(@PathVariable("code") String code) {
		commercantService.deleteCategorieCarte(code);
	}
      
                
    public CommercantRestController() {
    }
    
    
    
}
