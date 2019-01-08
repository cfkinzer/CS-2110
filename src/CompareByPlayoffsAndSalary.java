import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {

	public int compare(BasketBallTeam a, BasketBallTeam b){
		int retVal = 0;
		if(a.isPlayoffTeam()) {
			if(b.isPlayoffTeam()) {
				if(a.getSalaryInMillions() > b.getSalaryInMillions()) {
					retVal = 1;
				}
				if(b.getSalaryInMillions() > a.getSalaryInMillions()) {
					retVal = -1;
				}
			}
			else {
				retVal = 1;
			}
		}
		else if(b.isPlayoffTeam()) {
			retVal = -1;
		}
		else {
			if(a.getSalaryInMillions() > b.getSalaryInMillions()) {
				retVal = 1;
			}
			if(b.getSalaryInMillions() > a.getSalaryInMillions()) {
				retVal = -1;
			}
		}
		return retVal;
	}

}

