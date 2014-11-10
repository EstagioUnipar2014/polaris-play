package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity(name = "animal")
public class Animal extends Model {

	private static final long serialVersionUID = 7283190960380067576L;

	public static Model.Finder<Long, Animal> find = new Model.Finder<>(Long.class, Animal.class);

	@Id
	@GeneratedValue
	public Long id;

	public String identificacao;

	public String nome;

	public Boolean ativo;

	public Boolean emLactacao;

	public Boolean nascidoNaPropriedade;

	public String informacoes;

	@ManyToOne
	@JoinColumn(name = "raca_id")
	public Raca raca;

	@OneToMany(mappedBy = "animal")
	public List<Pesagem> pesagens;

	public static Map<String, String> listarAnimais() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		for (Animal e : Animal.find.orderBy("nome").findList()) {
			options.put(e.id.toString(), e.nome);
		}
		return options;
	}

}
