package com.example.demo.Service;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Apprenant;
import com.example.demo.model.Tuteur;
@JavaBean
public interface ApprenantService {
	Apprenant save(Apprenant apprenant);
	 ArrayList<Apprenant> getAllApprenants() ;
//	ObjectResponse exists(Apprenant a);

//	 Service save(Service service);

		Apprenant findById(String id);
 		Apprenant findByUsername(String Name);
 
}
