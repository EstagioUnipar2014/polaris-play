package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Animal;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.animais.create;
import views.html.animais.edit;
import views.html.animais.list;
import views.html.animais.show;

public class AnimaisController extends Controller {

	final static Form<Animal> animalForm = Form.form(Animal.class);

	public static Result index() {
		List<Animal> animais = Animal.find.all();
		return ok(list.render(animais));
	};

	public static Result create() {
		return ok(create.render(animalForm));
	};

	public static Result save() {
		Form<Animal> form = animalForm.bindFromRequest();
		try {
			form.get().save();
		} catch (Exception e) {
			return ok(create.render(form));
		}
		return redirect(routes.AnimaisController.index());
	};
	
	public static Result show(Long id){
		Animal animal = Animal.find.ref(id);
		return ok(show.render(animal));
	};

	public static Result edit(Long id) {
		Form<Animal> form = form(Animal.class).fill(Animal.find.byId(id));
		return ok(edit.render(id, form));
	};

	public static Result update(Long id) {
		animalForm.bindFromRequest().get().update(id);
		return redirect(routes.AnimaisController.index());
	};

	public static Result remove(Long id) {
		Animal.find.ref(id).delete();
		return redirect(routes.AnimaisController.index());
	};
}
