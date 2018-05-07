package ses.ui;


import java.text.SimpleDateFormat;
import java.util.*;

import ses.dao.SesDAO;
import ses.vo.*;

public class SESUI {
	
	Scanner sc = new Scanner(System.in);
	SesDAO dao = new SesDAO();
	
	public SESUI() 
	{
		while (true)
		{
			//메인 메뉴를 불러온다
			/*printMain();
			int select = getIntNum();
			
			switch (select)
			{
			case 1: insertTrainee();break;
			case 2: findTrainee();break;
			case 3: showAll();break;
			case 4: deleteTrainee();break;
			case 0: System.out.println("프로그램을 종료합니다");
					System.exit(0);
			}*/
			
			newMain();
		}
	}
	
	public void insertTrainee()
	{
		System.out.println("<연수생 등록 메뉴>");
		String id = null;
		String name = null;
		int age = 0;
		String address = null;
		String major = null;
		String jlpt = null;
		String eip = null;
		String phone = null;
		int groupof = 0;
		while (true)
		{
			while (true)
			{
				System.out.println("<아이디 : ");
				id = sc.nextLine();
				System.out.println("       >");
				int cnt = id.length();
				for (int i = 0 ; i < id.length() ; i++)
				{	//숫자만으로 이루어지지 않았는지 확인
					if (id.charAt(i) > '0' && id.charAt(i) < '9')
					{
						cnt -=1;
					}
					
					if (cnt == 0)
					{	//숫자만으로 이루어진 아이디는 교수 아이디
						System.out.println("<!!영문자,숫자 전부 이용해주세요!!>");
						break;
					}
					
				}
				//숫자와 영문자가 혼재 되어있으면 저장
				if (cnt != 0) break;
				continue;
				
			}
			
			System.out.println("<이름 : ");
			name = sc.nextLine();
			System.out.println("      >");
			System.out.println("나이 : ");
			age = getIntNum();		
			System.out.println("      >");
			System.out.println("주소 : ");
			address = sc.nextLine();
			System.out.println("      >");
			System.out.println("전공 : ");
			major = sc.nextLine();
			System.out.println("      >");
			jlpt = null;
			int j;
			while (true)
			{
				System.out.println("<JLPT (1~5로 입력 미보유시 0) 입력 예: N2 보유시 '2' 입력) : >");
				j = getIntNum();
				if (j < 0 || j > 5)
				{
					System.out.println("<!!0~5 사이의 값을 입력!!>");
					continue;
				}
				//숫자 1~5를 입력받고 앞에 N을 붙여줌
				switch (j)
				{
				case 0: jlpt = "없음";break;
				case 1: jlpt = "N1";break;
				case 2: jlpt = "N2";break;
				case 3: jlpt = "N3";break;
				case 4: jlpt = "N4";break;
				case 5: jlpt = "N5";break;
				}
				
				break;
			}
			eip = null;
			while (true)
			{
				System.out.println("<정보처리자격증 (1 - 없음/2 - 필기합격/3 - 있음) : >");
				int i = getIntNum();
				if (i < 1 || i > 3)
				{
					System.out.println("<!!1~3 사이로 입력!!>");
					continue;
				}
				
				//숫자 1~3을 입력받고 정보처리기사/산업기사 자격증 여부로 바꿔줌
				switch (i)
				{
				case 1: eip = "없음";break;
				case 2: eip = "필기";break;
				case 3: eip = "있음";break;
				}
				
				break;
			
			}
			
			System.out.println("<전화 번호 : ");
			phone = sc.nextLine();
			System.out.println("          >");
			System.out.println("<기수: ");
			groupof = getIntNum();
			System.out.println("          >");
			System.out.println("id:"+id);
			System.out.println("이름:"+name);
			System.out.println("나이:"+age);
			System.out.println("주소:"+address);
			System.out.println("전공:"+major);
			System.out.println("일본어 자격증:"+jlpt);
			System.out.println("정보처리자격증:"+eip);
			System.out.println("전화번호:"+phone);
			System.out.println("기수:"+groupof);
			System.out.println("-------------------------");
			System.out.println("<??상기의 정보로 등록하시겠습니까?(y/n)??>");
			String yn = sc.nextLine();
			if (yn.equals("Y") ||yn.equals("y") ||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")||yn.equals("ㅛ"))
			{
				break;
			}
			else continue;
		}
		
		// 받은 정보로 연수생 객체 생성
		Trainee t = new Trainee(id,name,age,address,major,jlpt,eip,phone,groupof);
		
		boolean insert = dao.insertTrainee(t);
		//생성이 잘 되었는지 확인
		System.out.println(insert?"<정상 등록>": "<!!등록 실패!!>");
		return;
	}
	
	public void findTrainee()
	{
		//조회할 항목을 선택
		System.out.println("<??어느 항목으로 찾겠습니까??>");
		
		//ID,이름,전공,나이,주소,전화번호로 연수생 검색
		int col = 0;
		while(true)
		{
			System.out.println("<1. ID\n2.이름\n3.전공\n4.나이\n5.주소\n6.전화번호>");
			System.out.print("선택 >>");
			col = getIntNum();
			if (col < 1 || col > 6)
			{	//1~6 사이로 입력이 안됬을 때 다시 출력
				System.out.println("<!!1~6 사이로 다시 입력!!>");
				continue;
			}
			break;
		}
		
		System.out.println("<검색어 : ");
		String find = sc.nextLine();
		System.out.println("        >");
		//검색할 항목과 검색어를 받아 dao 클래스로 넘겨줌
		//2명 이상의 결과가 나올 수 있기 때문에 리스트로 받음
		ArrayList<Trainee> list = dao.findTrainee(col,find);
		
		//해당하는 연수생이 없을 시
		if (list.isEmpty())
		{
			System.out.println("<!!자료가 없습니다!!>");
		}
		
		//해당하는 연수생이 있을 시 
		for (Trainee t : list)
		{
			System.out.println(t);
		}
		
		
		
	}
	public void newMain()
	{
		while (true)
		{
			System.out.println("==============================");
			System.out.println("	<SES 연수생 관리 프로그램>	||");
			System.out.println("1.연수생 등록					||");
			System.out.println("2.접속						||");
			System.out.println("0.종료						||");
			System.out.println("==============================");
			System.out.print("선택>> ");
			
			int select = 0;
			while (true)
			{
				select = getIntNum();
				switch (select)
				{
				case 1: insertTrainee();break;
				case 2: loginMenu();break;
				case 0: System.out.println("<프로그램을 종료합니다>");
						System.exit(0);
				default : System.out.println("<!!잘못 입력하였습니다!!>");
				}
			}
		}
		
	}
	
	public void loginMenu()
	{
		
		System.out.println("<로그인>");
		while(true)
		{
			System.out.println("<아이디: ");
			String id = sc.nextLine();
			System.out.println("       >");
			loginID(id);
			
		}
	}
	
	public void loginID(String id)
	{
		
		Professor p = null;
		Trainee t = null;
		
		int cnt = 0;
		
		for (int i = 0 ; i < id.length() ; i++)
		{	//숫자만으로 이루어진 교수의 아이디인지 확인
			if (id.charAt(i) < '0' || id.charAt(i) > '9')
			{
				cnt +=1;
			}
		}
		
		if (cnt == 0)
		{	//숫자만으로 이루어졌다면 교수 객체로 받음
			p = dao.loginID(id);
			if (p == null)
			{	//해당 아이디가 없을 경우에 메소드 종료
				System.out.println("<!!아이디가 없습니다!!>");
				return;
			}
			printProfMenu(p);
		}
		else
		{	//숫자만으로 이루어지지 않았으면 연수생 객체로 받음
			t = dao.loginID2(id);
			if (t == null)
			{	//해당 아이디가 없을 경우에 메소드 종료
				System.out.println("<!!아이디가 없습니다!!>");
				return;
			}
			printTraineeMenu(t);
		}
		
		
		
		
	}
	
	//교수 아이디로 로그인
	public void printProfMenu(Professor p)
	{
		
		
		System.out.println("<환영합니다 "+p.getName()+" 님>");
		while (true)
		{
			//학사 담당 교수가 조퇴 요청을 처리
			if (p.getSubject().equals("학사"))
			{
				int count = 0;
				count = dao.getExcuse();
				if (count == 0)
				{
					
				}
				else
				{
				
					System.out.println("<[Notice] 조퇴/결석 신청이 "+count+"건 있습니다.>");
				
				}
				
			}
			System.out.println("==============================");
			System.out.println("1.연수생 점수 조회				||");
			System.out.println("2.전체 연수생 출력				||");
			System.out.println("3.연수생 성적 입력				||");			
			System.out.println("4.조퇴/결석/지각 처리			||");			
			System.out.println("5.연수생 삭제					||");
			System.out.println("6.반배정						||");
			System.out.println("7.전체 공지					||");
			System.out.println("0. 프로그램 종료				||");
			System.out.println("==============================");
			System.out.print("선택>>");
			int select = 0;
			while (true)
			{
				select = getIntNum();
				switch (select)
				{
				case 1: findTrainee();break;
				case 2: showAll();break;
				case 3: insertMark(p.getSubject());break;
				case 4: //학사 관리 담당 외엔 열람 불가
						if (p.getSubject().equals("학사"))
						{
							manage();
						}
						else
							
							System.out.println("<!!권한이 없습니다!!>");
						break;
				case 5:if (p.getSubject().equals("학사"))
						{
							deleteTrainee();
						}
						else
					
							System.out.println("<!!권한이 없습니다!!>");
				break;
				case 6: updateclass();break;
				case 7: notice();break;
				case 0:	System.out.println("<프로그램을 종료합니다>");
						System.exit(0);
				}
				break;
			}
		}
		
		
	}
	
	public void notice()
	{
		System.out.println("<전체 공지 메뉴>");
		System.out.println("1.공지 생성\t2.공지 삭제\t3.현재 공지 확인\t4.상위메뉴로");
		int select = getIntNum();
		
		switch (select)
		{
		case 1: System.out.println("<내용:");
				String content = sc.nextLine();	
				System.out.println("		>");
				boolean insert = dao.insertNotice(content);
				System.out.println(insert?"<정상 등록>":"<!!등록 실패!!>");
				break;
		case 2: System.out.println("<삭제할 공지 번호: ");
				int num = getIntNum();
				boolean delete = dao.deleteNotice(num);
				System.out.println(delete?"<정상 삭제>":"<!!삭제 실패!!>");
		case 3: ArrayList<Notice> list = dao.showNotice();
				if (list == null)
				{
					System.out.println("<!!공지가 없습니다!!>");
					break;
				}
				for (Notice n : list)
				{
					System.out.println(n);
				}
		case 4: return;
		default : notice();
				
		}
		
		
	}
	
	public void manage()
	{
		while (true)
		{
			System.out.println("<1.조퇴/결석/지각 처리 2.조퇴/결석 신청 조회>");
			int select = getIntNum();
			
			switch (select)
			{
			case 1:absentAndLeave();break;
			case 2:readExcuse();break;
			}
		}
	}
	
	public void readExcuse()
	{
		System.out.println("<조퇴/결석 신청 조회>");
		//조퇴/결석 신청 게시판을 가져옴
		ArrayList<Board> list = null;
		
		list = dao.getAllExcuse();
		
		//조퇴/결석 신청이 없을 시 메소드 종료
		if (list.isEmpty())
		{
			System.out.println("<조회할 내용이 없습니다>");
			return;
		}
		
		int i;
		int j;
		double a = list.size()/5.0;
		int k = (int)Math.ceil(a);
		
		//조퇴/결석 신청을 5명씩 출력
		for (i = 0; i <= k ; i++ )
		{
			System.out.println("<----- 조퇴/결석 신청 목록 " +(i+1)+"페이지 ----->" );
			a = (i+1)/5.0;
			for (j = i*5; j <= (i+1)*5 ; j++)
			{
				try
				{
					System.out.println(list.get(j).getBoardNum()+ ". "+list.get(j).getName()+" "+list.get(j).getIndate());
				}
				
				catch (IndexOutOfBoundsException e)
				{
					break;
				}
				
			}
			
			int select;
			
			//첫 페이지에서는 이전 페이지로 돌아가는 항목이 나와서는 안됨
			if (i > 0)
			{
				System.out.print("<0.이전 페이지\t>");
				
			}
			System.out.println("<1.다음 페이지\t2.읽기\t3.삭제\t4.나가기>");
			System.out.print("선택 >>");
			select = getIntNum();
			
			//다음 페이지로 갈지 보드 번호로 글을 읽을 지 선택
			switch (select)
			{
			case 4: return;
			case 3: deleteExcuse();
			case 2: showExcuse(i,j);
			case 1: break;
			//이전 페이지로 돌아갈 때 
			case 0: if (i != 0) 
					{
						i -= 2;
					}
					// 첫 페이지에서 '0'을 입력했을 때 현재 페이지를 다시 보여줌
					else
					{
						i = -1;
					}
					break;
			default: i = -1;break;
			}
			
		}
		
		
		
		
		
	}
	
	public void deleteExcuse()
	{
		System.out.println("<삭제할 글 번호: ");
		int select = getIntNum();
		System.out.println("			>");
		System.out.println("<정말로 삭제하시겠습니까?>(y/n)");
		String yn = sc.nextLine();
		boolean delete = false;
		if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("ㅛ"))
		{
			delete = dao.deleteExcuse(select);
			System.out.println(delete?"<정상 삭제>":"<!!삭제실패!!>");
			
		}
		else return;
		
		
	}
	
	public void showExcuse(int i,int j)
	{
		//조퇴/결석 게시판을 읽기 위한 메소드 
		System.out.println("<조회할 번호: ");
		int select = getIntNum();
		System.out.println("           >");
		Board b = dao.showExcuse(select);
		
		System.out.println(b);
		dao.updateExcuse(b.getBoardNum());
		
		while (true)
		{
			System.out.println("<조퇴/결석 처리 (1.조퇴 2.결석 3.지각 4. 상위메뉴로)>");
			System.out.print("선택 >>");
			int selec = getIntNum();
			String s = null;
			switch (selec)
			{
			case 1: s = "조퇴";break;
			case 2: s = "결석";break;
			case 3: s = "지각";break;
			case 4: return;
			default : System.out.println("<!!잘못 입력하였습니다!!>");continue;
			}
			
			System.out.print(b.getName() + "<연수생의 "+s+"처리를 합니다. 계속하시겠습니까?>");
			System.out.print("(y/n)선택 >>");
			String yn = sc.nextLine();
			
			if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("ㅛ"))
			{
				
					dao.absent(b.getId(),selec);
					return;
				
			}
			else continue;
		}
	}
	
	public void absentAndLeave()
	{
		while (true)
		{
			System.out.println("<조퇴/결석 처리 (1.조퇴 2.결석 3.지각 4.상위메뉴로)>");
			System.out.print("선택 >>");
			int select = getIntNum();
			String s = null;
			switch (select)
			{
			case 1: s = "조퇴";break;
			case 2: s = "결석";break;
			case 3: s = "지각";break;
			case 4: return;
			default : System.out.println("<!!잘못 입력하였습니다!!>");continue;
			}
			
			while (true)
			{
				System.out.print("<"+s+"처리할 학생의 ID : ");
				String id = sc.nextLine();
				System.out.println("                   >");
				ArrayList<Trainee> list = dao.findTrainee(1,id);
				Trainee t = list.get(0);
				if (list.isEmpty())
				{
					System.out.println("<!!해당 아이디가 없습니다!!>");
					continue;
				}
				
				System.out.print(t.getName() + "<연수생의 "+s+"처리를 합니다. 계속하시겠습니까?>");
				System.out.print("(y/n)선택 >>");
				String yn = sc.nextLine();
				
				if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("ㅛ"))
				{
					
						dao.absent(id,select);
						return;
					
				}
				else break;
				
				
				
			}
			
		}
	}
	
	public void updateclass()
	{
		System.out.println("<반 배정을 할 기수 : ");
		int select = getIntNum();
		System.out.println("               >");
		int count = dao.getAmount(select);
		
		int limit = (int)(Math.ceil(count / 5.0));
		System.out.println("<한 반에 "+limit+"명씩 배정을 시작합니다.>");
		System.out.println("<계속하시겠습니까?> (y/n)");
		String yn = sc.nextLine();
		if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("ㅛ"))
		{			
			
		}
		else return;
		
		
		int countA = 0; int countB = 0; int countC = 0;
		int countD = 0; int countE = 0;
		String c = null;
		ArrayList<Trainee> list = dao.showAll(select);
		
		for (int i = 0;i <list.size();i++)
		{
			int random = (int)(Math.random()*5+1);
			Trainee t = list.get(i);
			switch (random)
			{
			case 1: if (countA <limit)
					{
						c = "A";
						countA++;
						break;
					}
			case 2:if (countB <limit)
					{
						c = "B";
						countB++;
						break;
					}
			case 3:if (countC <limit)
					{
						c = "C";
						countC++;
						break;
					}
			case 4:if (countD <limit)
					{
						c = "D";
						countD++;
						break;
					}
			case 5:if (countE <limit)
					{
						c = "E";
						countE++;
						break;
					}
			default :continue;
			}
			
			t.setItCls(c);
			dao.updateClass(t);
			
			
			
		}
		
		list.clear();
		list = dao.showAll(select);
		
		for (Trainee tr : list)
		{
			System.out.println(tr.getName()+": "+ tr.getItCls()+"반");
		}
		
		
		
	}
	
	public void insertMark(String subject)
	{
		//연수생의 시험 점수를 입력
		System.out.println("<점수를 입력할 연수생 ID : ");
		String id = sc.nextLine();
		System.out.println("                     >");
		//DB에서 ID에 해당하는 연수생의 정보를 가져옴
		//리스트로 가져오기 때문에 결과가 항상 1건이지만 get메소드가 필요
		Trainee t = dao.findTrainee(1, id).get(0);
		System.out.println("<입력할 평가를 선택 \n1.1차 역량평가\n2.2차 역량평가\n3.3차 역량평가\n4.상위메뉴로>");
		int select = 0;
		while (true)
		{
			
			select = getIntNum();
			if (select < 1 || select >4)
			{	//1~4의 값이 들어오지 않았을때
				System.out.println("<!!1~4 사이의 값을 입력!!>");
				continue;
			}
			break;
		}
		
		System.out.println("<"+t.getName()+"연수생의 " + select+"차 역량평가 점수 : >");
		int mark = 0;
		while (true)
		{
			mark = getIntNum();
			if (mark < 0 || mark > 100)
			{	//0~100사이의 값이 들어오지 않았을 때
				System.out.println("<!!잘못 입력하셨습니다!!>");
				continue;
			}
			break;
		}
		int col = 0;
		//해당과목의 교수만 해당과목 점수 입력이 가능
		if (subject.equals("IT"))
		{
			switch (select)
			{
			case 1: col = 1;break;
			case 2: col = 2;break;
			case 3: col = 3;break;	
			case 4: return;
			}
			
		}
		else
		{
			switch (select)
			{
			case 1: col = 4;break;
			case 2: col = 5;break;
			case 3: col = 6;break;			
			}
		}
		
		//저장할 항목, 점수, 연수생의 아이디를 dao로 보냄
		dao.updateTrainee(col,mark,t.getId());
		
	}
	
	public void showEvent(int groupof)
	{		
	 	Calendar c = Calendar.getInstance();
	 	String week = String.valueOf(c.get(Calendar.WEEK_OF_MONTH));
	 	SimpleDateFormat sdf = new SimpleDateFormat ("MM"); 
		Date m = new Date(); 
		String m2 = sdf.format (m);
		int month = Integer.parseInt(m2);
				
	 	
	 	
	 	
	 	System.out.println("<"+month +"월 주요 일정>");
	
	 	int w = Integer.parseInt(week);
	 	
	 	if (groupof % 2 == 1)
	 	{
	 		month -= 6;
	 	}
	 	
	 	if (month <= 0)
	 	{
	 		switch (month)
	 		{
	 		
	 		case -1: month = 5;break;
	 		case -2: month = 4;break;
	 		case -3: month = 3;break;
	 		case -4: month = 2;break;
	 		case -5: month = 1;break;
	 		case 0 : month = 12;break;
	 		}
	 	}
	 	
		switch (month)
		{
		case 1:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 2:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:System.out.println("3주차 : 2차 역량 평가");
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 3:{
			switch (w)
			{
			case 1:System.out.println("1주차 : 4~5인 프로젝트");
			case 2:System.out.println("2주차 : 4~5인 프로젝트");
			case 3:System.out.println("3주차 : 4~5인 프로젝트");
			case 4:System.out.println("4주차 : 4~5인 프로젝트");
			case 5:System.out.println("5주차 : 4~5인 프로젝트");
			case 6:System.out.println("6주차 : 4~5인 프로젝트");break;
			}
	
		}break;
		case 4:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 5:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:System.out.println("3주차:프로젝트 발표");
			case 4:System.out.println("4주차: 일본 현지 Job Fair");
			case 5:
			case 6:break;
			}
	
		}break;
		case 6:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 7:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 8:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 9:{
			switch (w)
			{
			case 1:System.out.println("입학을 축하합니다.");break;
			case 2:System.out.println("입학을 축하합니다.");
			case 3:
			case 4:
			case 5:System.out.println("5주차 : 사전평가");
			case 6:break;
			}
	
		}break;
		case 10:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 11:{
			switch (w)
			{
			case 1:
			case 2:
			case 3:System.out.println("3주차 : 1차 역량 평가, 2인 프로젝트");
			case 4:System.out.println("4주차 : 2인 프로젝트");
			case 5:
			case 6:break;
			}
			
		}break;
		case 12:{
			switch (w)
			{
			case 1:System.out.println("1주차 : JLPT ");
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;		
	 	}
	}
	
	public void printTraineeMenu(Trainee t)
	{
		

		//연수생의 아이디로 접속시 화면
		System.out.println("<환영합니다 "+t.getName()+"님>");
		showEvent(t.getGroupof());
		showNotice();
		while (true)
		{
			System.out.println("==============================");
			System.out.println("1.내 성적 조회 					||");
			System.out.println("2.전체 평균 조회				||");
			System.out.println("3.결석 또는 조퇴 신청				||");
			System.out.println("0.프로그램 종료					||");
			System.out.println("==============================");
			System.out.print("선택>> ");
			int select = getIntNum();
			
			switch (select)
			{
			case 1: myMark(t.getId());break;
			case 2: avg(t);break;
			case 3: board(t);break;
			case 0: System.out.println("<프로그램을 종료합니다>");
					System.exit(0);
			default : break;
			}
		}
		
	}
	
	public void showNotice()
	{
		ArrayList<Notice> list = dao.showNotice();
		if (list == null)
		{	
			return;
		}
		System.out.println("<----- 전체 공지 ----->");
		for (Notice n:list)
		{
			System.out.println(n.getContent());
		}
		System.out.println("--------------------");
	}
	
	public void myMark(String id)
	{
		//연수생 자신의 점수를 확인
		ArrayList<Trainee> list = dao.findTrainee(1, id);
		Trainee t = list.get(0);
		
		System.out.println("<["+t.getName()+"]"+"님의 성적>");
		System.out.println("<1차 역량 평가 IT: " + t.getFirstTestIT()+">");
		System.out.println("<1차 역량 평가 일본어: " + t.getFirstTestJP()+">");
		System.out.println("<2차 역량 평가 IT: " + t.getSecondTestIT()+">");
		System.out.println("<2차 역량 평가 일본어: " + t.getSecondTestJP()+">");
		System.out.println("<3차 역량 평가 IT: " + t.getThirdTestIT()+">");
		System.out.println("<3차 역량 평가 일본어: " + t.getThirdTestJP()+">");
	}
	
	
	public void avg(Trainee t)
	{
		//연수생은 전체의 평균을 보는 것은 가능
		System.out.println("<역량 평가 평균 점수 조회>");
		double avgFirstIT = 0.0;
		double avgFirstJP = 0.0;
		double avgSecondIT = 0.0;
		double avgSecondJP = 0.0;
		double avgThirdIT = 0.0;
		double avgThirdJP = 0.0;
		int groupof = t.getGroupof();
		
		avgFirstIT = dao.getAvg(1,groupof);
		avgFirstJP = dao.getAvg(2,groupof);
		avgSecondIT = dao.getAvg(3,groupof);
		avgSecondJP = dao.getAvg(4,groupof);
		avgThirdIT	= dao.getAvg(5,groupof);
		avgThirdIT = dao.getAvg(6,groupof);
		
		System.out.println("<------ "+t.getGroupof()+"기 평균 ------>");
		System.out.println("<1차 : IT 평균 점수 : "+avgFirstIT+">");
		System.out.println("<1차 : 일본어 평균 점수 : "+avgFirstJP+">");
		System.out.println("<2차 : IT 평균 점수 : "+avgSecondIT+">");
		System.out.println("<2차 : 일본어 평균 점수 : "+avgSecondJP+">");
		System.out.println("<3차 : IT 평균 점수 : "+avgThirdIT+">");
		System.out.println("<3차 : 일본어 평균 점수 : "+avgThirdJP+">");
		
		
	}
	
	public void board(Trainee t)
	{
		//조퇴/결석 신청 화면
		System.out.println("<결석/조퇴 신청 화면>");
		System.out.println("<조퇴면 [조퇴], 결석이면 [결석], 그 뒤에 사유를 적어주세요>");
		String content = null;
		while (true)
		{
			System.out.print("<내용 (되도록 간략하게):");
			content = sc.nextLine();
			System.out.println("                 >");
			System.out.println("<내용:" + content+">");
			System.out.println("<작성을 완료하시겠습니까? (y/n)>");
			String yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("ㅛ"))
			{
				break;
			}
			System.out.println("<작성을 취소하시겠습니까?>(y/n)");
			yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("ㅛ"))
			{
				return;
			}
		}
		
		//연수생의 ID와 이름, 내용을 보드 객체로 저장
		Board b = new Board(t.getId(),t.getName(),content);
		
		//보드를 dao 클래스로 넘겨 줌
		boolean insert = dao.boardInsert(b);
		
		System.out.println(insert?"<정상 등록>":"<!!등록 실패!!>");
		
		
		
		return;
	}
	
	
	
	public void showAll()
	{
		//전체 연수생을 출력
		ArrayList<Trainee> list = null;
		
		System.out.println("<출력할 기수 : ");
		int groupof = getIntNum();
		System.out.println("            >");
		list = dao.showAll(groupof);
		
		
		//연수생이 없을 때의 처리
		if (list.isEmpty()||list.size() == 0)
		{
			System.out.println("<!!자료가 없습니다!!>");
			return;
		}
		
		
		//전체 연수생을 10명씩 출력
		for(int i = 0; i < Math.ceil(list.size() / 10.0); i++ )
		{
			System.out.println("<---전체 연수생 목록 "+(i+1)+"페이지--->");
			for (int j = i*10; j < Math.ceil((i+1)*10.0) ; j++)
			{				
				
				try
				{
					System.out.println(list.get(j));
				}
				
				catch (IndexOutOfBoundsException e)
				{
					break;
				}
				
			}
			
			int select;
			
			//첫 페이지에서는 이전 페이지로 돌아가는 항목이 나와서는 안됨
			if (i > 0)
			{
				System.out.print("<0.이전 페이지>\t");
				
			}
			System.out.println("<1.다음 페이지 2.나가기>");
			System.out.print("선택 >>");
			select = getIntNum();
			
			switch (select)
			{
			case 2: return;
			case 1: break;
			//이전 페이지로 돌아갈 때 
			case 0: if (i != 0) 
					{
						i -= 2;
					}
					// 첫 페이지에서 '0'을 입력했을 때 현재 페이지를 다시 보여줌
					else
					{
						i = -1;
					}
					break;
			default: i = -1;break;
			}
			
			
			
		}
	}
	
	//연수생 삭제 메뉴
	public void deleteTrainee()
	{
		//ID를 입력받아 dao로 넘김
		System.out.println("<삭제 메뉴>");
		System.out.print("<삭제할 연수생 ID :");
		String id = sc.nextLine();
		System.out.println("             >");
		boolean delete = dao.deleteTrainee(id);
		System.out.println("<정말로 삭제하시겠습니까?>(y/n)");
		String yn = sc.nextLine();
		if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("ㅛ"))
		{
			
		}
		else return;
		//삭제에 성공하면 성공, 실패하면 실패를 출력
		System.out.println(delete?"<정상 삭제>":"<!!삭제 실패!!>");
	}
	
	//초기 과정의 화면
	public void printMain()
	{
		System.out.println("SES 연수생 관리 프로그램");
		System.out.println("1.연수생 등록");
		System.out.println("2.연수생 조회");
		System.out.println("3.전체 연수생 출력");
		System.out.println("4.연수생 삭제");
		System.out.println("0.종료");
		System.out.print("선택 >>> ");
	}
	
	//정수를 받기 위한 메소드
	public int getIntNum()
	{
		int select = 0;
		while (true)
		{
			try
			{
				select = sc.nextInt();
				sc.nextLine();
				break;
			}
			
			catch (Exception e)
			{
				sc.nextLine();
				System.out.println("<!!숫자로 입력!!>");				
			}
		}
		
		return select;
	}

}
