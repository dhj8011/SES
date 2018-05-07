package ses.vo;

public class Professor extends Person {
	
	private int pNum;
	private String subject;		//담당 과목 IT/일본어
	private String cls;			//담당반 IT담당일 때는 A/B/C/D/E 일본어 담당일때는 초급/중급/고급
	
	public Professor() 
	{
		
	}
	
	public Professor(String name, int age,int pNum, String subject, String cls) {
		super(name,age);
		this.pNum = pNum;
		this.subject = subject;
		this.cls = cls;
	}

	//getters&setters
	
	public String getSubject() {
		return subject;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	@Override
	public String toString() {
		return super.toString() + subject + ", cls=" + cls ;
	}			
	
	
	
	
	
	
	

}
