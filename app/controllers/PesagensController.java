package controllers;

import java.util.List;

import models.Animal;
import models.Pesagem;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.pesagens.*;

public class PesagensController extends Controller {

	static Form<Pesagem> pesagemForm = Form.form(Pesagem.class);

	public static Result index() {
		List<Pesagem> pesagens = Pesagem.find.all();
		return ok(list.render(pesagens));
	}

	public static Result create() {
		return ok(create.render(pesagemForm));
	}

	public static Result save() {
		Form<Pesagem> form = pesagemForm.bindFromRequest();
		try {
			form.get().save();
		} catch (Exception e) {
			return ok(create.render(form));
		}
		return redirect(routes.AnimaisController.index());
	}

	public static Result edit(Long id) {
		return ok(edit.render(id, pesagemForm));
	}

	public static Result update(Long id) {
		pesagemForm.bindFromRequest().get().update(id);
		return redirect(routes.AnimaisController.index());
	}

	public static Result remove(Long id) {
		Pesagem.find.ref(id).delete();
		return redirect(routes.PesagensController.index());
	}
}
