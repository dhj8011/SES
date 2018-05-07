package ses.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ses.dao.SesMapper;
import ses.dao.MybatisConfig;
import ses.vo.*;

public class SesDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//연수생 등록
	
	public boolean insertTrainee(Trainee t)
	{
		int vari = 0;
		int vari2 = 0;
		int vari3 = 0;
		int vari4 = 0;
		
		SqlSession ss = null;
		
		
		try
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			vari = mapper.insertTrainee(t);
			vari2 = mapper.insertMark(t.getId());
			vari3 = mapper.insertClass(t.getId());
			vari4 = mapper.insertManage(t.getId());
			
			ss.commit();
				
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (ss != null) ss.close();
		}
		
		
		if (vari != 0 && vari2 != 0 && vari3 != 0 && vari4 != 0) return true;
		else return false;
	}
	
	public ArrayList<Trainee> findTrainee(int col,String find)
	{
		ArrayList<Trainee> list = null;
		SqlSession ss = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("col", col);
		map.put("find", find);
		
		try
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			list = mapper.findTrainee(map);
			ss.commit();
				
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (ss != null) ss.close();
		}
		return list;
	}
	
	public ArrayList<Trainee> showAll(int groupof)
	{
		ArrayList<Trainee> list = null;
		SqlSession ss = null;
		try
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			list = mapper.showAll(groupof);
			ss.commit();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (ss != null) ss.close();
		}
		
		return list;
	}
	
	public boolean deleteTrainee(String id)
	{
		int vari = 0;
		SqlSession ss = null;
		
		try
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			vari = mapper.deleteTrainee(id);
			ss.commit();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (ss != null) ss.close();
		}
		
		
		if (vari != 0) return true;
		else return false;
	}
	
	//교수 로그인
	public Professor loginID(String id)
	{
		Professor p = null;
		SqlSession ss = null;
		
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			p = mapper.loginID(id);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
			
		return p;		
		
		
	}
	
	//연수생 로그인
	public Trainee loginID2(String id)
	{
		Trainee t = null;
		SqlSession ss = null;
		
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			t = mapper.loginID2(id);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
			
		return t;		
	}
	
	public void updateTrainee(int col,int mark,String id)
	{
		SqlSession ss = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("col", col);
		map.put("mark", mark);
		map.put("id", id);
		
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			mapper.updateTrainee(map);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
					
		
		
	}
	
	public double getAvg(int select,int groupof)
	{
		double avg = 0.0;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("col", select);
		map.put("groupof", groupof);
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			avg = mapper.getAvg(map);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		return avg;
	}
	
	public boolean boardInsert(Board b)
	{
		int insert = 0;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			insert = mapper.boardInsert(b);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		if (insert != 0) return true;
		else return false;
	}
	
	public int getExcuse()
	{
		int count = 0;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			count = mapper.getExcuse();
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		return count;
	}
	
	public ArrayList<Board> getAllExcuse()
	{
		ArrayList<Board> list = null;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			list = mapper.getAllExcuse();
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		return list;
	}
	
	public Board showExcuse(int select)
	{
		Board b= null;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			b = mapper.showExcuse(select);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		
		return b;
	}
	
	public void absent(String id,int col)
	{
		SqlSession ss = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("col", col);
		map.put("id",id);
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			mapper.absent(map);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
	}
	
	public int getAmount(int groupof)
	{
		int count = 0;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			count = mapper.getAmount(groupof);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		return count;
	}
	
	public void updateClass(Trainee t)
	{
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			mapper.updateClass(t);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
				
				
	}
	
	public boolean deleteExcuse(int boardNum)
	{
		int vari = 0;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			vari = mapper.deleteExcuse(boardNum);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		if (vari != 0) return true;
		else return false;
	}
	
	public void updateExcuse(int boardNum)
	{
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			mapper.updateExcuse(boardNum);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
	}
	
	public boolean insertNotice(String content)
	{
		int vari = 0;
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			vari = mapper.insertNotice(content);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		if (vari != 0) return true;
		else return false;
	}
	
	public boolean deleteNotice(int noticeNum)
	{
		int vari = 0;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			vari = mapper.deleteNotice(noticeNum);
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		if (vari != 0) return true;
		else return false;
	}
	
	public ArrayList<Notice> showNotice()
	{
		ArrayList<Notice> list = null;
		
		SqlSession ss = null;
		
		try 
		{
			ss = factory.openSession();
			SesMapper mapper = ss.getMapper(SesMapper.class);
			list = mapper.showNotice();
			ss.commit();
		}
			
		catch (Exception e)
		{
			e.printStackTrace();
		}
			
		finally
		{
			if (ss != null) ss.close();
		}
		
		return list;
	}
	
	
}
