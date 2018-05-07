package ses.vo;

public class Professor extends Person {
	
	private int pNum;
	private String subject;		//��� ���� IT/�Ϻ���
	private String cls;			//���� IT����� ���� A/B/C/D/E �Ϻ��� ����϶��� �ʱ�/�߱�/���
	
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
