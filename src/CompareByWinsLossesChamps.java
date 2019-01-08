import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {

	public int compare(BasketBallTeam a, BasketBallTeam b){
		int retVal = 0;
		if(a.getNumberOfWins() > b.getNumberOfWins()) {
			retVal = 1;
		}
		if(b.getNumberOfWins() > a.getNumberOfWins()) {
			retVal = -1;
		}
		if(retVal == 0) {
			if(a.getNumberOfLosses() < b.getNumberOfLosses()) {
				retVal = -1;
			}
			if(b.getNumberOfLosses() < a.getNumberOfLosses()) {
				retVal = 1;
			}
		}
		if(retVal == 0) {
			if(a.getNumberOfChampionships() > b.getNumberOfChampionships()) {
				retVal = 1;
			}
			if(b.getNumberOfChampionships() > a.getNumberOfChampionships()) {
				retVal = -1;
			}
		}
		return retVal;
	}
}


