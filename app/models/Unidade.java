package models;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;

import play.data.validation.Constraints;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity(name="unidade")
public class Unidade extends Model {

	private static final long serialVersionUID = -3769230786823435731L;
	
	public static Model.Finder<Long, Unidade> find = new Model.Finder<>(Long.class, Unidade.class);
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String nome;
	
	public String abreviacao;
	
	public static Map<String, String> listarUnidades() {
		LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
		for (Unidade e : Unidade.find.orderBy("nome").findList()) {
			options.put(e.id.toString(), e.nome);
		}
		return options;
	}
}
