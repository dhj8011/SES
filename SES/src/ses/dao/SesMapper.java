package ses.dao;

import java.util.ArrayList;
import java.util.HashMap;

import ses.vo.*;


/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface SesMapper {
	
	public int insertTrainee(Trainee t);
	
	public int insertMark(String id);
	
	public int insertClass(String id);
	
	public int insertManage(String id);
	
	public ArrayList<Trainee> findTrainee(HashMap<String,Object> map);
	
	public ArrayList<Trainee> showAll(int groupof);
	
	public int deleteTrainee(String id);
	
	public Professor loginID(String id);
	
	public Trainee loginID2(String id);
	
	public void updateTrainee(HashMap<String,Object> map);
	
	public double getAvg(HashMap<String,Object> map);
	
	public int boardInsert(Board b);
	
	public int getExcuse();
	
	public ArrayList<Board> getAllExcuse();
	
	public Board showExcuse(int select);
	
	public void absent(HashMap<String,Object> map);
	
	public int getAmount(int groupof);
	
	public void updateClass(Trainee t);
	
	public int deleteExcuse(int boardNum);
	
	public void updateExcuse(int boardNum);
	
	public int insertNotice(String content);
	
	public int deleteNotice(int noticeNum);
	
	public ArrayList<Notice> showNotice();
	
}
