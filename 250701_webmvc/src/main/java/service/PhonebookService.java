package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.PhonebookInter;
import vo.Phonebook;
@Service
public class PhonebookService {
	
	@Autowired
	PhonebookInter dao;
	
	public int save(Phonebook phonebook) {
		System.out.println("===DAO--SAVE()들어옴");
		return dao.save(phonebook);
	}

	public List<Phonebook> list() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Phonebook findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public int update(Phonebook phonebook) {
		// TODO Auto-generated method stub
		return dao.update(phonebook);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	
}
