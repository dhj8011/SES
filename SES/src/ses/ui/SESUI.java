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
			//���� �޴��� �ҷ��´�
			/*printMain();
			int select = getIntNum();
			
			switch (select)
			{
			case 1: insertTrainee();break;
			case 2: findTrainee();break;
			case 3: showAll();break;
			case 4: deleteTrainee();break;
			case 0: System.out.println("���α׷��� �����մϴ�");
					System.exit(0);
			}*/
			
			newMain();
		}
	}
	
	public void insertTrainee()
	{
		System.out.println("<������ ��� �޴�>");
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
				System.out.println("<���̵� : ");
				id = sc.nextLine();
				System.out.println("       >");
				int cnt = id.length();
				for (int i = 0 ; i < id.length() ; i++)
				{	//���ڸ����� �̷������ �ʾҴ��� Ȯ��
					if (id.charAt(i) > '0' && id.charAt(i) < '9')
					{
						cnt -=1;
					}
					
					if (cnt == 0)
					{	//���ڸ����� �̷���� ���̵�� ���� ���̵�
						System.out.println("<!!������,���� ���� �̿����ּ���!!>");
						break;
					}
					
				}
				//���ڿ� �����ڰ� ȥ�� �Ǿ������� ����
				if (cnt != 0) break;
				continue;
				
			}
			
			System.out.println("<�̸� : ");
			name = sc.nextLine();
			System.out.println("      >");
			System.out.println("���� : ");
			age = getIntNum();		
			System.out.println("      >");
			System.out.println("�ּ� : ");
			address = sc.nextLine();
			System.out.println("      >");
			System.out.println("���� : ");
			major = sc.nextLine();
			System.out.println("      >");
			jlpt = null;
			int j;
			while (true)
			{
				System.out.println("<JLPT (1~5�� �Է� �̺����� 0) �Է� ��: N2 ������ '2' �Է�) : >");
				j = getIntNum();
				if (j < 0 || j > 5)
				{
					System.out.println("<!!0~5 ������ ���� �Է�!!>");
					continue;
				}
				//���� 1~5�� �Է¹ް� �տ� N�� �ٿ���
				switch (j)
				{
				case 0: jlpt = "����";break;
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
				System.out.println("<����ó���ڰ��� (1 - ����/2 - �ʱ��հ�/3 - ����) : >");
				int i = getIntNum();
				if (i < 1 || i > 3)
				{
					System.out.println("<!!1~3 ���̷� �Է�!!>");
					continue;
				}
				
				//���� 1~3�� �Է¹ް� ����ó�����/������ �ڰ��� ���η� �ٲ���
				switch (i)
				{
				case 1: eip = "����";break;
				case 2: eip = "�ʱ�";break;
				case 3: eip = "����";break;
				}
				
				break;
			
			}
			
			System.out.println("<��ȭ ��ȣ : ");
			phone = sc.nextLine();
			System.out.println("          >");
			System.out.println("<���: ");
			groupof = getIntNum();
			System.out.println("          >");
			System.out.println("id:"+id);
			System.out.println("�̸�:"+name);
			System.out.println("����:"+age);
			System.out.println("�ּ�:"+address);
			System.out.println("����:"+major);
			System.out.println("�Ϻ��� �ڰ���:"+jlpt);
			System.out.println("����ó���ڰ���:"+eip);
			System.out.println("��ȭ��ȣ:"+phone);
			System.out.println("���:"+groupof);
			System.out.println("-------------------------");
			System.out.println("<??����� ������ ����Ͻðڽ��ϱ�?(y/n)??>");
			String yn = sc.nextLine();
			if (yn.equals("Y") ||yn.equals("y") ||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")||yn.equals("��"))
			{
				break;
			}
			else continue;
		}
		
		// ���� ������ ������ ��ü ����
		Trainee t = new Trainee(id,name,age,address,major,jlpt,eip,phone,groupof);
		
		boolean insert = dao.insertTrainee(t);
		//������ �� �Ǿ����� Ȯ��
		System.out.println(insert?"<���� ���>": "<!!��� ����!!>");
		return;
	}
	
	public void findTrainee()
	{
		//��ȸ�� �׸��� ����
		System.out.println("<??��� �׸����� ã�ڽ��ϱ�??>");
		
		//ID,�̸�,����,����,�ּ�,��ȭ��ȣ�� ������ �˻�
		int col = 0;
		while(true)
		{
			System.out.println("<1. ID\n2.�̸�\n3.����\n4.����\n5.�ּ�\n6.��ȭ��ȣ>");
			System.out.print("���� >>");
			col = getIntNum();
			if (col < 1 || col > 6)
			{	//1~6 ���̷� �Է��� �ȉ��� �� �ٽ� ���
				System.out.println("<!!1~6 ���̷� �ٽ� �Է�!!>");
				continue;
			}
			break;
		}
		
		System.out.println("<�˻��� : ");
		String find = sc.nextLine();
		System.out.println("        >");
		//�˻��� �׸�� �˻�� �޾� dao Ŭ������ �Ѱ���
		//2�� �̻��� ����� ���� �� �ֱ� ������ ����Ʈ�� ����
		ArrayList<Trainee> list = dao.findTrainee(col,find);
		
		//�ش��ϴ� �������� ���� ��
		if (list.isEmpty())
		{
			System.out.println("<!!�ڷᰡ �����ϴ�!!>");
		}
		
		//�ش��ϴ� �������� ���� �� 
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
			System.out.println("	<SES ������ ���� ���α׷�>	||");
			System.out.println("1.������ ���					||");
			System.out.println("2.����						||");
			System.out.println("0.����						||");
			System.out.println("==============================");
			System.out.print("����>> ");
			
			int select = 0;
			while (true)
			{
				select = getIntNum();
				switch (select)
				{
				case 1: insertTrainee();break;
				case 2: loginMenu();break;
				case 0: System.out.println("<���α׷��� �����մϴ�>");
						System.exit(0);
				default : System.out.println("<!!�߸� �Է��Ͽ����ϴ�!!>");
				}
			}
		}
		
	}
	
	public void loginMenu()
	{
		
		System.out.println("<�α���>");
		while(true)
		{
			System.out.println("<���̵�: ");
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
		{	//���ڸ����� �̷���� ������ ���̵����� Ȯ��
			if (id.charAt(i) < '0' || id.charAt(i) > '9')
			{
				cnt +=1;
			}
		}
		
		if (cnt == 0)
		{	//���ڸ����� �̷�����ٸ� ���� ��ü�� ����
			p = dao.loginID(id);
			if (p == null)
			{	//�ش� ���̵� ���� ��쿡 �޼ҵ� ����
				System.out.println("<!!���̵� �����ϴ�!!>");
				return;
			}
			printProfMenu(p);
		}
		else
		{	//���ڸ����� �̷������ �ʾ����� ������ ��ü�� ����
			t = dao.loginID2(id);
			if (t == null)
			{	//�ش� ���̵� ���� ��쿡 �޼ҵ� ����
				System.out.println("<!!���̵� �����ϴ�!!>");
				return;
			}
			printTraineeMenu(t);
		}
		
		
		
		
	}
	
	//���� ���̵�� �α���
	public void printProfMenu(Professor p)
	{
		
		
		System.out.println("<ȯ���մϴ� "+p.getName()+" ��>");
		while (true)
		{
			//�л� ��� ������ ���� ��û�� ó��
			if (p.getSubject().equals("�л�"))
			{
				int count = 0;
				count = dao.getExcuse();
				if (count == 0)
				{
					
				}
				else
				{
				
					System.out.println("<[Notice] ����/�Ἦ ��û�� "+count+"�� �ֽ��ϴ�.>");
				
				}
				
			}
			System.out.println("==============================");
			System.out.println("1.������ ���� ��ȸ				||");
			System.out.println("2.��ü ������ ���				||");
			System.out.println("3.������ ���� �Է�				||");			
			System.out.println("4.����/�Ἦ/���� ó��			||");			
			System.out.println("5.������ ����					||");
			System.out.println("6.�ݹ���						||");
			System.out.println("7.��ü ����					||");
			System.out.println("0. ���α׷� ����				||");
			System.out.println("==============================");
			System.out.print("����>>");
			int select = 0;
			while (true)
			{
				select = getIntNum();
				switch (select)
				{
				case 1: findTrainee();break;
				case 2: showAll();break;
				case 3: insertMark(p.getSubject());break;
				case 4: //�л� ���� ��� �ܿ� ���� �Ұ�
						if (p.getSubject().equals("�л�"))
						{
							manage();
						}
						else
							
							System.out.println("<!!������ �����ϴ�!!>");
						break;
				case 5:if (p.getSubject().equals("�л�"))
						{
							deleteTrainee();
						}
						else
					
							System.out.println("<!!������ �����ϴ�!!>");
				break;
				case 6: updateclass();break;
				case 7: notice();break;
				case 0:	System.out.println("<���α׷��� �����մϴ�>");
						System.exit(0);
				}
				break;
			}
		}
		
		
	}
	
	public void notice()
	{
		System.out.println("<��ü ���� �޴�>");
		System.out.println("1.���� ����\t2.���� ����\t3.���� ���� Ȯ��\t4.�����޴���");
		int select = getIntNum();
		
		switch (select)
		{
		case 1: System.out.println("<����:");
				String content = sc.nextLine();	
				System.out.println("		>");
				boolean insert = dao.insertNotice(content);
				System.out.println(insert?"<���� ���>":"<!!��� ����!!>");
				break;
		case 2: System.out.println("<������ ���� ��ȣ: ");
				int num = getIntNum();
				boolean delete = dao.deleteNotice(num);
				System.out.println(delete?"<���� ����>":"<!!���� ����!!>");
		case 3: ArrayList<Notice> list = dao.showNotice();
				if (list == null)
				{
					System.out.println("<!!������ �����ϴ�!!>");
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
			System.out.println("<1.����/�Ἦ/���� ó�� 2.����/�Ἦ ��û ��ȸ>");
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
		System.out.println("<����/�Ἦ ��û ��ȸ>");
		//����/�Ἦ ��û �Խ����� ������
		ArrayList<Board> list = null;
		
		list = dao.getAllExcuse();
		
		//����/�Ἦ ��û�� ���� �� �޼ҵ� ����
		if (list.isEmpty())
		{
			System.out.println("<��ȸ�� ������ �����ϴ�>");
			return;
		}
		
		int i;
		int j;
		double a = list.size()/5.0;
		int k = (int)Math.ceil(a);
		
		//����/�Ἦ ��û�� 5�� ���
		for (i = 0; i <= k ; i++ )
		{
			System.out.println("<----- ����/�Ἦ ��û ��� " +(i+1)+"������ ----->" );
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
			
			//ù ������������ ���� �������� ���ư��� �׸��� ���ͼ��� �ȵ�
			if (i > 0)
			{
				System.out.print("<0.���� ������\t>");
				
			}
			System.out.println("<1.���� ������\t2.�б�\t3.����\t4.������>");
			System.out.print("���� >>");
			select = getIntNum();
			
			//���� �������� ���� ���� ��ȣ�� ���� ���� �� ����
			switch (select)
			{
			case 4: return;
			case 3: deleteExcuse();
			case 2: showExcuse(i,j);
			case 1: break;
			//���� �������� ���ư� �� 
			case 0: if (i != 0) 
					{
						i -= 2;
					}
					// ù ���������� '0'�� �Է����� �� ���� �������� �ٽ� ������
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
		System.out.println("<������ �� ��ȣ: ");
		int select = getIntNum();
		System.out.println("			>");
		System.out.println("<������ �����Ͻðڽ��ϱ�?>(y/n)");
		String yn = sc.nextLine();
		boolean delete = false;
		if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("��"))
		{
			delete = dao.deleteExcuse(select);
			System.out.println(delete?"<���� ����>":"<!!��������!!>");
			
		}
		else return;
		
		
	}
	
	public void showExcuse(int i,int j)
	{
		//����/�Ἦ �Խ����� �б� ���� �޼ҵ� 
		System.out.println("<��ȸ�� ��ȣ: ");
		int select = getIntNum();
		System.out.println("           >");
		Board b = dao.showExcuse(select);
		
		System.out.println(b);
		dao.updateExcuse(b.getBoardNum());
		
		while (true)
		{
			System.out.println("<����/�Ἦ ó�� (1.���� 2.�Ἦ 3.���� 4. �����޴���)>");
			System.out.print("���� >>");
			int selec = getIntNum();
			String s = null;
			switch (selec)
			{
			case 1: s = "����";break;
			case 2: s = "�Ἦ";break;
			case 3: s = "����";break;
			case 4: return;
			default : System.out.println("<!!�߸� �Է��Ͽ����ϴ�!!>");continue;
			}
			
			System.out.print(b.getName() + "<�������� "+s+"ó���� �մϴ�. ����Ͻðڽ��ϱ�?>");
			System.out.print("(y/n)���� >>");
			String yn = sc.nextLine();
			
			if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("��"))
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
			System.out.println("<����/�Ἦ ó�� (1.���� 2.�Ἦ 3.���� 4.�����޴���)>");
			System.out.print("���� >>");
			int select = getIntNum();
			String s = null;
			switch (select)
			{
			case 1: s = "����";break;
			case 2: s = "�Ἦ";break;
			case 3: s = "����";break;
			case 4: return;
			default : System.out.println("<!!�߸� �Է��Ͽ����ϴ�!!>");continue;
			}
			
			while (true)
			{
				System.out.print("<"+s+"ó���� �л��� ID : ");
				String id = sc.nextLine();
				System.out.println("                   >");
				ArrayList<Trainee> list = dao.findTrainee(1,id);
				Trainee t = list.get(0);
				if (list.isEmpty())
				{
					System.out.println("<!!�ش� ���̵� �����ϴ�!!>");
					continue;
				}
				
				System.out.print(t.getName() + "<�������� "+s+"ó���� �մϴ�. ����Ͻðڽ��ϱ�?>");
				System.out.print("(y/n)���� >>");
				String yn = sc.nextLine();
				
				if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("��"))
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
		System.out.println("<�� ������ �� ��� : ");
		int select = getIntNum();
		System.out.println("               >");
		int count = dao.getAmount(select);
		
		int limit = (int)(Math.ceil(count / 5.0));
		System.out.println("<�� �ݿ� "+limit+"�� ������ �����մϴ�.>");
		System.out.println("<����Ͻðڽ��ϱ�?> (y/n)");
		String yn = sc.nextLine();
		if (yn.equals("y")||yn.equals("Y")||yn.equals("YES")||yn.equals("yes")||yn.equals("Yes")|| yn.equals("��"))
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
			System.out.println(tr.getName()+": "+ tr.getItCls()+"��");
		}
		
		
		
	}
	
	public void insertMark(String subject)
	{
		//�������� ���� ������ �Է�
		System.out.println("<������ �Է��� ������ ID : ");
		String id = sc.nextLine();
		System.out.println("                     >");
		//DB���� ID�� �ش��ϴ� �������� ������ ������
		//����Ʈ�� �������� ������ ����� �׻� 1�������� get�޼ҵ尡 �ʿ�
		Trainee t = dao.findTrainee(1, id).get(0);
		System.out.println("<�Է��� �򰡸� ���� \n1.1�� ������\n2.2�� ������\n3.3�� ������\n4.�����޴���>");
		int select = 0;
		while (true)
		{
			
			select = getIntNum();
			if (select < 1 || select >4)
			{	//1~4�� ���� ������ �ʾ�����
				System.out.println("<!!1~4 ������ ���� �Է�!!>");
				continue;
			}
			break;
		}
		
		System.out.println("<"+t.getName()+"�������� " + select+"�� ������ ���� : >");
		int mark = 0;
		while (true)
		{
			mark = getIntNum();
			if (mark < 0 || mark > 100)
			{	//0~100������ ���� ������ �ʾ��� ��
				System.out.println("<!!�߸� �Է��ϼ̽��ϴ�!!>");
				continue;
			}
			break;
		}
		int col = 0;
		//�ش������ ������ �ش���� ���� �Է��� ����
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
		
		//������ �׸�, ����, �������� ���̵� dao�� ����
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
				
	 	
	 	
	 	
	 	System.out.println("<"+month +"�� �ֿ� ����>");
	
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
			case 3:System.out.println("3���� : 2�� ���� ��");
			case 4:
			case 5:
			case 6:break;
			}
	
		}break;
		case 3:{
			switch (w)
			{
			case 1:System.out.println("1���� : 4~5�� ������Ʈ");
			case 2:System.out.println("2���� : 4~5�� ������Ʈ");
			case 3:System.out.println("3���� : 4~5�� ������Ʈ");
			case 4:System.out.println("4���� : 4~5�� ������Ʈ");
			case 5:System.out.println("5���� : 4~5�� ������Ʈ");
			case 6:System.out.println("6���� : 4~5�� ������Ʈ");break;
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
			case 3:System.out.println("3����:������Ʈ ��ǥ");
			case 4:System.out.println("4����: �Ϻ� ���� Job Fair");
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
			case 1:System.out.println("������ �����մϴ�.");break;
			case 2:System.out.println("������ �����մϴ�.");
			case 3:
			case 4:
			case 5:System.out.println("5���� : ������");
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
			case 3:System.out.println("3���� : 1�� ���� ��, 2�� ������Ʈ");
			case 4:System.out.println("4���� : 2�� ������Ʈ");
			case 5:
			case 6:break;
			}
			
		}break;
		case 12:{
			switch (w)
			{
			case 1:System.out.println("1���� : JLPT ");
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
		

		//�������� ���̵�� ���ӽ� ȭ��
		System.out.println("<ȯ���մϴ� "+t.getName()+"��>");
		showEvent(t.getGroupof());
		showNotice();
		while (true)
		{
			System.out.println("==============================");
			System.out.println("1.�� ���� ��ȸ 					||");
			System.out.println("2.��ü ��� ��ȸ				||");
			System.out.println("3.�Ἦ �Ǵ� ���� ��û				||");
			System.out.println("0.���α׷� ����					||");
			System.out.println("==============================");
			System.out.print("����>> ");
			int select = getIntNum();
			
			switch (select)
			{
			case 1: myMark(t.getId());break;
			case 2: avg(t);break;
			case 3: board(t);break;
			case 0: System.out.println("<���α׷��� �����մϴ�>");
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
		System.out.println("<----- ��ü ���� ----->");
		for (Notice n:list)
		{
			System.out.println(n.getContent());
		}
		System.out.println("--------------------");
	}
	
	public void myMark(String id)
	{
		//������ �ڽ��� ������ Ȯ��
		ArrayList<Trainee> list = dao.findTrainee(1, id);
		Trainee t = list.get(0);
		
		System.out.println("<["+t.getName()+"]"+"���� ����>");
		System.out.println("<1�� ���� �� IT: " + t.getFirstTestIT()+">");
		System.out.println("<1�� ���� �� �Ϻ���: " + t.getFirstTestJP()+">");
		System.out.println("<2�� ���� �� IT: " + t.getSecondTestIT()+">");
		System.out.println("<2�� ���� �� �Ϻ���: " + t.getSecondTestJP()+">");
		System.out.println("<3�� ���� �� IT: " + t.getThirdTestIT()+">");
		System.out.println("<3�� ���� �� �Ϻ���: " + t.getThirdTestJP()+">");
	}
	
	
	public void avg(Trainee t)
	{
		//�������� ��ü�� ����� ���� ���� ����
		System.out.println("<���� �� ��� ���� ��ȸ>");
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
		
		System.out.println("<------ "+t.getGroupof()+"�� ��� ------>");
		System.out.println("<1�� : IT ��� ���� : "+avgFirstIT+">");
		System.out.println("<1�� : �Ϻ��� ��� ���� : "+avgFirstJP+">");
		System.out.println("<2�� : IT ��� ���� : "+avgSecondIT+">");
		System.out.println("<2�� : �Ϻ��� ��� ���� : "+avgSecondJP+">");
		System.out.println("<3�� : IT ��� ���� : "+avgThirdIT+">");
		System.out.println("<3�� : �Ϻ��� ��� ���� : "+avgThirdJP+">");
		
		
	}
	
	public void board(Trainee t)
	{
		//����/�Ἦ ��û ȭ��
		System.out.println("<�Ἦ/���� ��û ȭ��>");
		System.out.println("<����� [����], �Ἦ�̸� [�Ἦ], �� �ڿ� ������ �����ּ���>");
		String content = null;
		while (true)
		{
			System.out.print("<���� (�ǵ��� �����ϰ�):");
			content = sc.nextLine();
			System.out.println("                 >");
			System.out.println("<����:" + content+">");
			System.out.println("<�ۼ��� �Ϸ��Ͻðڽ��ϱ�? (y/n)>");
			String yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("��"))
			{
				break;
			}
			System.out.println("<�ۼ��� ����Ͻðڽ��ϱ�?>(y/n)");
			yn = sc.nextLine();
			if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("��"))
			{
				return;
			}
		}
		
		//�������� ID�� �̸�, ������ ���� ��ü�� ����
		Board b = new Board(t.getId(),t.getName(),content);
		
		//���带 dao Ŭ������ �Ѱ� ��
		boolean insert = dao.boardInsert(b);
		
		System.out.println(insert?"<���� ���>":"<!!��� ����!!>");
		
		
		
		return;
	}
	
	
	
	public void showAll()
	{
		//��ü �������� ���
		ArrayList<Trainee> list = null;
		
		System.out.println("<����� ��� : ");
		int groupof = getIntNum();
		System.out.println("            >");
		list = dao.showAll(groupof);
		
		
		//�������� ���� ���� ó��
		if (list.isEmpty()||list.size() == 0)
		{
			System.out.println("<!!�ڷᰡ �����ϴ�!!>");
			return;
		}
		
		
		//��ü �������� 10�� ���
		for(int i = 0; i < Math.ceil(list.size() / 10.0); i++ )
		{
			System.out.println("<---��ü ������ ��� "+(i+1)+"������--->");
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
			
			//ù ������������ ���� �������� ���ư��� �׸��� ���ͼ��� �ȵ�
			if (i > 0)
			{
				System.out.print("<0.���� ������>\t");
				
			}
			System.out.println("<1.���� ������ 2.������>");
			System.out.print("���� >>");
			select = getIntNum();
			
			switch (select)
			{
			case 2: return;
			case 1: break;
			//���� �������� ���ư� �� 
			case 0: if (i != 0) 
					{
						i -= 2;
					}
					// ù ���������� '0'�� �Է����� �� ���� �������� �ٽ� ������
					else
					{
						i = -1;
					}
					break;
			default: i = -1;break;
			}
			
			
			
		}
	}
	
	//������ ���� �޴�
	public void deleteTrainee()
	{
		//ID�� �Է¹޾� dao�� �ѱ�
		System.out.println("<���� �޴�>");
		System.out.print("<������ ������ ID :");
		String id = sc.nextLine();
		System.out.println("             >");
		boolean delete = dao.deleteTrainee(id);
		System.out.println("<������ �����Ͻðڽ��ϱ�?>(y/n)");
		String yn = sc.nextLine();
		if (yn.equals("y") || yn.equals("Y")|| yn.equals("yes")||yn.equals("YES")||yn.equals("��"))
		{
			
		}
		else return;
		//������ �����ϸ� ����, �����ϸ� ���и� ���
		System.out.println(delete?"<���� ����>":"<!!���� ����!!>");
	}
	
	//�ʱ� ������ ȭ��
	public void printMain()
	{
		System.out.println("SES ������ ���� ���α׷�");
		System.out.println("1.������ ���");
		System.out.println("2.������ ��ȸ");
		System.out.println("3.��ü ������ ���");
		System.out.println("4.������ ����");
		System.out.println("0.����");
		System.out.print("���� >>> ");
	}
	
	//������ �ޱ� ���� �޼ҵ�
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
				System.out.println("<!!���ڷ� �Է�!!>");				
			}
		}
		
		return select;
	}

}
