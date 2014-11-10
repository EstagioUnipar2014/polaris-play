package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity(name = "pesagem")
public class Pesagem extends Model {

	private static final long serialVersionUID = -3769230786823435731L;
	
	public static Model.Finder<Long, Pesagem> find = new Model.Finder<>(Long.class, Pesagem.class);

	@Id
	@GeneratedValue
	public Long id;

	public Double peso;
	
	@ManyToOne
	@JoinColumn(name = "animal_id")
	public Animal animal;

}
