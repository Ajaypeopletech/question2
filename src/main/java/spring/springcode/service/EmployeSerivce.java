package spring.springcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeSerivce
{
	@Autowired
	Myrepo myrepo;
	public  List<Employe> displayData()
	{
		 return myrepo.findAll();
	}
	public void saveProduct(Employe employe)
	{
		myrepo.save(employe);
	}
	public Employe getProd(long id)
	{
		return myrepo.findById(id).get();
	}
	public void delete(long id)
	{
		myrepo.deleteById(id);
	}
}
