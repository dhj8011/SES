package ses.vo;

public class Trainee extends Person
{
	private String id;
	private String address;
	private String major;
	private String jlpt;			//JLPT 미보유 시 0 1~5까지
	private String eip;			//정보처리기사/산업기사 자격증 미보유/필기/실기
	private String phone;		
	private String itCls;		//IT반 A/B/C/D/E
	private String jpCls;		//일본어 반 초급/중급/고급
	private int firstTestIT;	//1차 역량평가 IT점수
	private int firstTestJP;	//1차 역량평가 일본어 점수
	private int secondTestIT;	//2차 역량평가 IT점수
	private int secondTestJP;	//2차 역량평가 일본어 점수
	private int thirdTestIT;	//3차 역량평가 IT점수
	private int thirdTestJP;	//3차 역량평가 일본어 점수
	private int last;			//지각 횟수
	private int absent;			//결석 횟수
	private int groupof;
	
	public Trainee() {}
	
	public Trainee(String id,String name, int age, String address, String major, String jlpt, String eip, String phone,int groupof) {
		super(name,age);
		this.id = id;
		this.address = address;
		this.major = major;
		this.jlpt = jlpt;
		this.eip = eip;
		this.phone = phone;
		this.groupof = groupof;
	}
	
	//getters&setters

	
	
	public String getAddress() {
		return address;
	}

	public int getGroupof() {
		return groupof;
	}

	public void setGroupof(int groupof) {
		this.groupof = groupof;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getJlpt() {
		return jlpt;
	}

	public void setJlpt(String jlpt) {
		this.jlpt = jlpt;
	}

	public String getEip() {
		return eip;
	}

	public void setEip(String eip) {
		this.eip = eip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getItCls() {
		return itCls;
	}

	public void setItCls(String itCls) {
		this.itCls = itCls;
	}

	public String getJpCls() {
		return jpCls;
	}

	public void setJpCls(String jpCls) {
		this.jpCls = jpCls;
	}

	public int getFirstTestIT() {
		return firstTestIT;
	}

	public void setFirstTestIT(int firstTestIT) {
		this.firstTestIT = firstTestIT;
	}

	public int getFirstTestJP() {
		return firstTestJP;
	}

	public void setFirstTestJP(int firstTestJP) {
		this.firstTestJP = firstTestJP;
	}

	public int getSecondTestIT() {
		return secondTestIT;
	}

	public void setSecondTestIT(int secondTestIT) {
		this.secondTestIT = secondTestIT;
	}

	public int getSecondTestJP() {
		return secondTestJP;
	}

	public void setSecondTestJP(int secondTestJP) {
		this.secondTestJP = secondTestJP;
	}

	public int getThirdTestIT() {
		return thirdTestIT;
	}

	public void setThirdTestIT(int thirdTestIT) {
		this.thirdTestIT = thirdTestIT;
	}

	public int getThirdTestJP() {
		return thirdTestJP;
	}

	public void setThirdTestJP(int thirdTestJP) {
		this.thirdTestJP = thirdTestJP;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}

	@Override
	public String toString() {
		return super.toString() + ", id=" + id + ", address=" + address + ", major=" + major + ", jlpt=" + jlpt + ", eip=" + eip + ", phone="
				+ phone + ", groupof ="+ groupof +", itCls=" + itCls + ", jpCls=" + jpCls + ", firstTestIT=" + firstTestIT + ", firstTestJP="
				+ firstTestJP + ", secondTestIT=" + secondTestIT + ", secondTestJP=" + secondTestJP + ", thirdTestIT="
				+ thirdTestIT + ", thirdTestJP=" + thirdTestJP + ", last=" + last + ", absent=" + absent ;
	}
	
	
	
	
}
