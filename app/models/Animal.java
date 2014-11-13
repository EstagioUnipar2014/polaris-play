package models;

import java.util.LinkedHashMap;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.xml.ws.RequestWrapper;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity(name = "animal")
public class Animal extends Model {

	private static final long serialVersionUID = 7283190960380067576L;

	public static Model.Finder<Long, Animal> find = new Model.Finder<>(Long.class, Animal.class);

	@Id
	@GeneratedValue
	public Long id;

	@Constraints.Required
	public String identificacao;

	public String nome;
	
	public String sexo;

	public Boolean ativo = false;

	public Boolean emLactacao = false;

	public Boolean nascidoNaPropriedade = false;

	public String informacoes;

	@ManyToOne
	@JoinColumn(name = "raca_id")
	public Raca raca;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "animal")
	public List<Pesagem> pesagens;

	public static Map<String, String> listarAnimais() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		for (Animal e : Animal.find.orderBy("nome").findList()) {
			options.put(e.id.toString(), e.nome);
		}
		return options;
	}
	
	public static String simNao(boolean b){
		if (b){
			return "Sim";
		}else{
			return "Não";
		}
	}

}
