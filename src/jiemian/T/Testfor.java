package jiemian.T;

import static org.hamcrest.CoreMatchers.nullValue;





import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import jiemian.Action.GuserAction;
import jiemian.Action.SmarkAction;
import jiemian.Action.ToolAction;
import jiemian.Dao.LeaveDao;
import jiemian.Dao.LoginDao;
import jiemian.Dao.RegisterDao;
import jiemian.Dao.RenWuDao;
import jiemian.Dao.SmarkDao;
import jiemian.Dao.markDao;
import jiemian.Dao.xinxiDao;
import jiemian.Dao.zhuyuanDao;
import jiemian.Service.RenwuZSGC;
import jiemian.entities.CQrecord;
import jiemian.entities.RenWu;
import jiemian.entities.Tinfo;
import jiemian.entities.Tuser;
import jiemian.entities.chuqin;
import jiemian.entities.specificRw;
import jiemian.entities.zhiyuan;

public class Testfor {

	
	
	ApplicationContext ctx = null;
	

	RenWuDao renWuDao;
	RenwuZSGC renwuZSGC;
	LoginDao loginDao;
	RegisterDao registerDao;
	xinxiDao xinxiDao;
	markDao markDao;
	SmarkDao smarkDao;
	SmarkAction smarkAction;
	GuserAction guserAction;
	zhuyuanDao zhuyuanDao;
	LeaveDao leaveDao;
	ToolAction toolAction;
	{
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		

		renWuDao = ctx.getBean(RenWuDao.class);
		renwuZSGC = ctx.getBean(RenwuZSGC.class);
		loginDao = ctx.getBean(LoginDao.class);
		registerDao = ctx.getBean(RegisterDao.class);
		xinxiDao = ctx.getBean(xinxiDao.class);
		markDao = ctx.getBean(markDao.class);
		smarkDao = ctx.getBean(SmarkDao.class);
		smarkAction =  ctx.getBean(SmarkAction.class);
		guserAction = ctx.getBean(GuserAction.class);
		zhuyuanDao = ctx.getBean(zhuyuanDao.class);
		leaveDao = ctx.getBean(LeaveDao.class);
		toolAction = ctx.getBean(ToolAction.class);
	}
	
	@Test
	public void test() {
	
//	  List rw = renWuDao.findallRenwu();
//	
//	  RenWu  rrw= (RenWu) rw.get(0); 
//	
//	  System.out.println(rrw.getBanji());
	  
//	  List<RenWu>  rw2 = renWuDao.xiugairenwu("����ѧԺ", "ɨ���");
//	  
//	  
//	  for(RenWu lrw:rw2){
//		  System.out.println(lrw.getRenwu());
//	  }
	  
//		boolean ok = loginDao.findgly("����Ա1","000000");
//		boolean ok2 = loginDao.findxs("s1", "000000");
//		System.out.println(ok);
//		System.out.println(ok2);
		
//	List<specificRw> ssl=renWuDao.chaAllrenwu();
//		
//	for(specificRw sr:ssl)
//	{
//		System.out.println(sr.getRWid());
//		System.out.println(sr.getRWMC());
//		System.out.println(sr.getRWQY());
//	}
//		
		
//	System.out.println("hello");

//	List<Tinfo> Lino = xinxiDao.Txinxi(1);
//	
//	for(Tinfo ino : Lino )
//	{
//		System.out.println(ino.getTphone());
//		System.out.println(ino.getTxueyuan());
//		System.out.println(ino.getTzhicheng());
//		System.out.println(ino.getTzhuanye());
//	
//	}
//	List<Integer> t = xinxiDao.findTeacherID("����ʦ");
//	
//	System.out.println(t);
	
	
		
//		xinxiDao.addXinID(2);
		
		
		
//		renWuDao.addnewRwinfo("��ѧԺ", "��רҵ", "�°༶", "������");
		
		
		
		
		
//		
//		System.out.println(markDao.findXS("ѧ��2"));
		
//		int i = markDao.findXid("ѧ��2");
////		System.out.println(i);
////		
////	markDao.addXsinfo(i,"ѧ��2");
//		
//		markDao.cun2(i, "ǩ��");
		
//		int i = 1;
//		if(i==1)
//		{
//			System.out.println("i is 1");
//			
//		}
//		System.out.println("ִ����");
		
		
//		
//		boolean us = registerDao.writeMY("LhntjIRegRkOTK6Y");
//		System.out.println(us);
		
		
		
//		
//		xinxiDao.updateInfo("��ѧԺ", "��רҵ", "123456789", "��ʦ", 2);
		
//		
//		List<CQrecord> cll = smarkDao.findRecord("ѧ��2");
//		
//		CQrecord ccq = new CQrecord();
//		ccq = cll.get(0);
//		
//		System.out.println(ccq.getMonday());
		
//		List<CQrecord> cll = smarkDao.findAllchuqin();
//		
//		for(CQrecord cq : cll)
//		{
//			System.out.println(cq.getMonday()+" "+cq.getTuesday()+" "+cq.getWednesday()+" "+cq.getThursday()+" "+cq.getFriday());
//		}
		
//		smarkDao.addchuqin("ѧ��2");
//		smarkDao.addCcount(1, "ѧ��2");
		
//	guserAction.jifen();
	
//	List<chuqin> cl = smarkDao.findAllCQ();
//	
//	
//	for(chuqin cll :cl)
//	{
//           System.out.println(cll.getsNAME());		
//	}
//		Integer i = new Integer(1);
//		System.out.println(i.toString());
//		
//		markDao.cun1(7, "ǩ��");
		
		
		
		
		
		
//		zhuyuanDao.canjiaInfo(1);
		
//		zhuyuanDao.xuanzezhiyuan("������ڰ�", "ѧ��3");
		
		
//		
//		String aString="asda";
//		
//		int i =  Integer.parseInt(aString);
//		System.out.println(i);
		
		
//		
//		
//		zhuyuanDao.jiZYfen("ceshi", "10");
		
		
//		System.out.println(leaveDao.isPiZhun("ѧ��3"));
		
//		
//		leaveDao.PiZhun("ѧ��3");
		
		toolAction.TongjiBandS();
		
	}

}
