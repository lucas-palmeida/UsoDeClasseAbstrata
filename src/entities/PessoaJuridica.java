package entities;

public class PessoaJuridica extends Contribuinte{

	private Integer noEmployees;
	
	public PessoaJuridica() {
		
	}
		
	public PessoaJuridica(String name, Double annualIncome, Integer noEmployees) {
		super(name, annualIncome);
		this.noEmployees = noEmployees;
	}

	public Integer getNoEmployees() {
		return noEmployees;
	}

	public void setNoEmployees(Integer noEmployees) {
		this.noEmployees = noEmployees;
	}

	@Override
	public Double taxPaid() {
		if(noEmployees > 10) {
			return getAnnualIncome() * 0.14;
		}
		else {
			return getAnnualIncome() * 0.16;
		}
	}

}
