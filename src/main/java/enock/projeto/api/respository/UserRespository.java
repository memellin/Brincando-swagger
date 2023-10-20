package enock.projeto.api.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import enock.projeto.api.model.Usuario;

@Repository
public class UserRespository {
	public void save(Usuario u) {
		if(u.getId() == null) {
			System.out.println("save ");
		
		} else {
			System.out.println("Update ");
		}System.out.println(u);
	}
	public void deleteById(Integer id) {
		System.out.println(String.format("delete/id - recebendo o id: %d para excluir", id));
		System.out.println(id);
	}
	public List<Usuario> findAll(){
		System.out.println("list: ");
		List<Usuario> u = new ArrayList<>();
		u.add(new Usuario(1, "enock", "123"));
		u.add(new Usuario(2, "milena", "1234"));
		return u;
	}
	public Usuario findById(Integer id) {
		System.out.println(String.format("FIND/id - Recebendo o id: %s para localizar um usuário", id));
		return new Usuario(1, "enock", "123");
	}
	
	public Usuario findByUsername(String username) {
		System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", username));
		return new Usuario(1, "enock", "123");
	}
	
}
