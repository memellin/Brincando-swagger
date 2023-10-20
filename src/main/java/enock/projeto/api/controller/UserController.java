package enock.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import enock.projeto.api.model.Usuario;
import enock.projeto.api.repository.UserRepository;


@RestController
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsers(){
		return repository.findAll();
	}
	  @GetMapping("/usuario/{id}")
	    public Usuario getOne(@PathVariable("id") Integer id){
	        return repository.findById(id);
	    }
	
	@DeleteMapping("/usuarios/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/usuarios")
	public void postUser(@RequestBody Usuario user) {
		repository.save(user);
	}
	@PutMapping("/usuarios")
    public void put(@RequestBody Usuario usuario){
        repository.update(usuario);
    }
}
