import models.Raca;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application arg0) {
		Raca raca;

		try {
			raca = Raca.find.all().get(0);
		} catch (Throwable e) {
			raca = new Raca();
			raca.nome = "Teste";
			raca.save();
		}
	}
}
