package bai2ck;

public class Employee extends salary {
	private  int manv;
	private String name;
	private int age;
	private String PB;
	
	public Employee(){
		manv=0;
		name="";
		age=0;
		PB="";
	}
	public Employee(int _manv,String _name,int _age,String _pb) {
		manv=_manv;
		name=_name;
		age=_age;
		PB=_pb;
	}
	
	public int getID() {
		return manv;
	}
	public void setID(int _manv) {
		manv=_manv;
	}
	public String getPB() {
		return PB;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name=_name;
	}
	public int getSalary() {
		if(PB.equalsIgnoreCase("ky thuat")) {
			return 100;
		}
		return 0;
		
	}
	
	@Override
	public String toString() {
		return "Employee [manv=" + manv + ", name=" + name + ", age=" + age + ", PB=" + PB + "]";
	}
	
	
}
