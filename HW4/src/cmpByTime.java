import java.util.Comparator;

public class cmpByTime implements Comparator<Playable> { /** Compares two playlists by runtime*/
	public int compare(Playable p1, Playable p2) {
		int retVal = 0;
		int a = p1.getPlayTimeSeconds();
		int b = p2.getPlayTimeSeconds();
		if (a > b) {
			retVal = 1;
		}
		if (b > a) {
			retVal = -1;
		}
		return retVal;
	}

}
