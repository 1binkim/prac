package repository;

import java.util.List;

import vo.Phonebook;

public interface PhonebookInter {
	public int save(Phonebook phonebook);
	public List<Phonebook> findAll();
	public int update(Phonebook phonebook);
	public int delete(int id);
	public Phonebook findById(int id);
}
