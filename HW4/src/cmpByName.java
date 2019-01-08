import java.util.Comparator;

public class cmpByName implements Comparator<Playable> { /** Compares two playlist by name*/
	public int compare(Playable p1, Playable p2) {
		int retVal = 0;
		retVal = p1.getName().compareTo(p2.getName());
		return retVal;
	}
}
