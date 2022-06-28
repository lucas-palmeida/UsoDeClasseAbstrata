package entities;

public class PessoaFisica extends Contribuinte{

	private Double healthSpending;
	
	public PessoaFisica() {
		
	}
	
	public PessoaFisica(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public Double taxPaid() {
		double tax = getAnnualIncome();
		if(tax >= 20000.0) {
			 tax *= 0.25;
		}
		else {
			tax *= 0.15;
		}
		if(healthSpending > 0.0) {
			tax -= healthSpending / 2;
		}
		return tax;
	}

}
