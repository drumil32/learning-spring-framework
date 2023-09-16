package exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MySQLDataService")
public class MySQLDataService implements DataService{

	@Override
	public int[] retriveData() {
		return new int[] {11,22,33,44,55};
	}

}
