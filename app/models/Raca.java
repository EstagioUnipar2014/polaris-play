package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity(name = "raca")
public class Raca extends Model {

	private static final long serialVersionUID = 7727204617951517352L;
	
	public static Model.Finder<Long, Raca> find = new Model.Finder<>(Long.class, Raca.class);

	public Raca() {
	}
	
	@Id
	@GeneratedValue
	public Long id;

	public String nome;

	@OneToMany(mappedBy = "raca")
	public List<Animal> animais;
	
	public static Map<String, String> listarRacas() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		for (Raca e : Raca.find.orderBy("nome").findList()) {
			options.put(e.id.toString(), e.nome);
		}
		return options;
	}

}
