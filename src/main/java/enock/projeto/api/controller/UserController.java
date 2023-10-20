package enock.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enock.projeto.api.model.Usuario;
import enock.projeto.api.respository.UserRespository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRespository repository;
	
	@GetMapping()
	public List<Usuario> getUsers(){
		return repository.findAll();
	}
	@GetMapping("/{username}")
	public Usuario getOne(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping()
	public void postUser(@RequestBody Usuario user) {
		repository.save(user);
	}
}
