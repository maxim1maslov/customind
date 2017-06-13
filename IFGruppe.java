package project;

import java.util.Vector;

public interface IFGruppe {

	public boolean gruppehinzufuegen(Group gruppe);

	public String[][] getGruppen();

	public String[] getTableTitle();

	public boolean gruppeloeschen(int zeile);

	public String[][] sfgetGruppe(String[] select, String[] from, String where,
			Object id);

}
