/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.client;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfClient;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfTransaction;
import com.ufi.fidelite.entities.mirrors.CarteMirror;
import com.ufi.fidelite.entities.mirrors.ClientMirror;
import com.ufi.fidelite.entities.mirrors.CommercantMirror;
import com.ufi.fidelite.entities.mirrors.transactionMirror;
import com.ufi.fidelite.service.client.IClientService;
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
public class ClientRestController {
    
     @Autowired
    private ICommercantService commercantService;
     @Autowired
    private IRegionalisationService regionalisationService;
     @Autowired
    private IClientService clientService;
     
     
     
     
     @RequestMapping(value = "/client", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
            public Reponse saveClient(@RequestBody ClientMirror clientM ) {
            
            UfClient client = new UfClient();
            
            client.setCode(clientM.getCode());
            client.setNom(clientM.getNom()); 
            client.setPrenom(clientM.getPrenom());
            client.setTitre(clientM.getTitre());
            client.setDateNaissance(clientM.getDateNaissance());
            client.setAdresse(clientM.getAdresse());
            client.setTelephone1(clientM.getTelephone1());
            client.setTelephone2(clientM.getTelephone2());
            client.setEmail(clientM.getEmail());
            client.setStatut(clientM.getStatut());
            //client.setVille(regionalisationService.getOneVille(clientM.getVille()));
            client.setVille(regionalisationService.getOneVilleByCode(clientM.getVille()));
            
             if(clientService.searchClient(clientM.getCode())!=null){
                        return new Reponse(2, "Le client existe déjà", null);
              }else{
                     client= clientService.saveClient(client);}
                            if(client!=null){
                                return new Reponse(1, "Enregistré avec succes", client);}
                            else {
                                return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
         
        } 
        
        @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfClient> getAllClient(){
	

		return clientService.listeClient();
	}
        
         @RequestMapping(value = "/clientsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllClients(){
            
           Reponse rep=null; 
            try{
               rep=clientService.getAllClient();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/pclients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UfClient> getAllClient( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		return clientService.listeClient(new PageRequest(page, size));       
	}
        
        @RequestMapping(value = "/pclientsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllClients( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
            Reponse rep=null; 
            try{
               rep=clientService.getAllClientPages(new PageRequest(page, size));
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
            
		//return clientService.listeClient(new PageRequest(page, size));       
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/rechpclients", method = RequestMethod.GET)
	public Page<UfClient> pageClient(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return clientService.searchClients("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/clients/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UfClient getClient(@PathVariable("code") String code) {
		return clientService.searchClient(code);
	}
        
        // mise à jour
	@RequestMapping(value = "/clients/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateClient(@RequestBody ClientMirror c, @PathVariable("code") String code) {
            
            UfClient client = new UfClient();
            
            client.setCode(code);
            client.setNom(c.getNom());
            client.setPrenom(c.getPrenom());
            client.setTitre(c.getTitre());
            client.setDateNaissance(c.getDateNaissance());
            client.setAdresse(c.getAdresse());
            client.setTelephone1(c.getTelephone1());
            client.setTelephone2(c.getTelephone2());
            client.setEmail(c.getEmail());
            client.setStatut(c.getStatut());
            //client.setVille(regionalisationService.getOneVille(c.getVille()));
            client.setVille(regionalisationService.getOneVilleByCode(c.getVille()));
		
                
		client = clientService.updateClient(client);
                
                
		if (client != null) {

			return new Reponse(1, "mis à jour avec succes",null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
                
        }      
                
	@RequestMapping(value = "/clients/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteClient(@PathVariable("code") String code) {
		clientService.deleteClient(code);
	}
        
        
         @RequestMapping(value = "/carte", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	
            public Reponse saveCarte(@RequestBody CarteMirror carteM ) {
            
             UfCarte carte = new UfCarte();
            
            carte.setNumero(carteM.getNumero());
            carte.setCompteurPoint(carteM.getCompteurPoint());
            carte.setNombreTransaction(carteM.getNombreTransaction());
            carte.setMontantAcumule(carteM.getMontantAcumule());
            carte.setStatut(carteM.getStatut());
            carte.setCategorieCarte(commercantService.searchCategorieCarte(carteM.getCategorieCarte()));
            if(carteM.getClient()==null)
                carte= clientService.saveCarte(carte); 
            else{
                //carte.setClient(null);
                carte.setClient(clientService.searchClient(carteM.getClient()));
            
            //return  commercantService.saveCommercant(commercant);
                carte= clientService.saveCarte(carte); }

	if (carte != null) {

			return new Reponse(1, "enregistré avec succes",null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
        
        @RequestMapping(value = "/cartes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfCarte> getAllCarte(){
	

		return clientService.listeCarte();
	}
        
          @RequestMapping(value = "/cartesR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCartes(){
              Reponse rep=null; 
            try{
               rep=clientService.getAllCarte();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/pcartes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllCarte( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
              Reponse rep=null; 
            try{
               rep=clientService.listeCarte(new PageRequest(page, size)); ;
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
            
		//return clientService.listeCarte(new PageRequest(page, size));       
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/rechpcartes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UfCarte> pageCarte(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return clientService.searchCartes("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/cartes/{numero}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UfCarte getCarte(@PathVariable("numero") String numero) {
		return clientService.searchCarte(numero);
	}
        
        @RequestMapping(value = "/cartes/{numero}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateCarte(@RequestBody CarteMirror c, @PathVariable("numero") String numero) {
             UfCarte carte = new UfCarte();
            
            carte.setNumero(numero);
            carte.setCompteurPoint(c.getCompteurPoint());
            carte.setNombreTransaction(c.getNombreTransaction());
            carte.setMontantAcumule(c.getMontantAcumule());
            carte.setStatut(c.getStatut());
            carte.setCategorieCarte(commercantService.searchCategorieCarte(c.getCategorieCarte()));
            if(c.getClient()==null)
                carte= clientService.updateCarte(carte); 
            else{
                //carte.setClient(null);
                carte.setClient(clientService.searchClient(c.getClient()));
            
            //return  commercantService.saveCommercant(commercant);
                carte= clientService.updateCarte(carte); }

	if (carte != null) {

			return new Reponse(1, "mis à jour avec succes",null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant la mise à jour", null);
		}
        }
        
        @RequestMapping(value = "/cartes/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCarte(@PathVariable("code") String code) {
		clientService.deleteCarte(code);
	}
        
        
         @RequestMapping(value = "/transaction", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	
            public Reponse saveTransaction(@RequestBody transactionMirror transactionM ) {
            
             UfTransaction transaction = new UfTransaction();
             
             transaction.setTransactionId(transactionM.getTransactionId());
             transaction.setDateTransaction(transactionM.getDateTransaction());
             transaction.setMontantInitial(transactionM.getMontantInitial());
             transaction.setMontantReduit(transactionM.getMontantReduit());
             transaction.setCommentaire(transactionM.getCommentaire());
             transaction.setDateEnregistrement(transactionM.getDateEnregistrement());
             transaction.setCarte(clientService.searchCarte(transactionM.getCarte()));
             transaction.setTerminal(commercantService.searchTerminal(transactionM.getTerminal()));
            
            //return  commercantService.saveCommercant(commercant);
           transaction= clientService.saveTransaction(transaction);

		if (transaction != null) {

			return new Reponse(1, "enregistré avec succes",null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
        }
        
        @RequestMapping(value = "/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UfTransaction> getAllTransaction(){
	
		return clientService.listeTransation();
	}
        
        @RequestMapping(value = "/transactionsR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllTransactions(){
            Reponse rep=null; 
            try{
               rep=clientService.getAllTransaction();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	
		//return clientService.listeTransation();
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/ptransactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllTransaction( @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
            
             Reponse rep=null; 
            try{
               rep=clientService.listeTransaction(new PageRequest(page, size)); 
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
            
		//return clientService.listeTransaction(new PageRequest(page, size));       
	}
        
        // liste des produits page par page
	@RequestMapping(value = "/rechptransactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<UfTransaction> pageTransaction(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return clientService.searchTranactions("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/transactions/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UfTransaction getTransaction(@PathVariable("code") String code) {
		return clientService.searchTransaction(code);
	}
        
        @RequestMapping(value = "/transactions/{code}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateTransaction(@RequestBody transactionMirror t, @PathVariable("code") String code) {
             UfTransaction transaction = new UfTransaction();
            
             transaction.setTransactionId(code);
             transaction.setDateTransaction(t.getDateTransaction());
             transaction.setMontantInitial(t.getMontantInitial());
             transaction.setMontantReduit(t.getMontantReduit());
             transaction.setCommentaire(t.getCommentaire());
             transaction.setDateEnregistrement(t.getDateEnregistrement());
             transaction.setCarte(clientService.searchCarte(t.getCarte()));
             transaction.setTerminal(commercantService.searchTerminal(t.getTerminal()));
            
            //return  commercantService.saveCommercant(commercant);
           transaction= clientService.updateTransaction(transaction);

		if (transaction!= null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}  
        }
        
        @RequestMapping(value = "/transactions/{code}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTransaction(@PathVariable("code") String code) {
		clientService.deleteTransaction(code);
	}
        
        
            
        
        
        

    public ClientRestController() {
    }
    
    
    
}
