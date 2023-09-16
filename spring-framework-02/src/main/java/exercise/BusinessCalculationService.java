package exercise;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	
	private DataService dataService;
	
	public BusinessCalculationService(@Qualifier("MySQLDataService") DataService dataService) {
		this.dataService = dataService;
	}
	
//	public BusinessCalculationService(MySQLDataService dataService) {
//		this.dataService = dataService;
//	}
	
	public int findMax() {
		return Arrays.stream(dataService.retriveData()).max().orElse(0);
	}
}
