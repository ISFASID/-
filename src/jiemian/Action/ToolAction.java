package jiemian.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;

import jiemian.Dao.ToolDao;
import jiemian.entities.BandSre;
import jiemian.entities.BorrowT;
import jiemian.entities.Sdback;
import jiemian.entities.Tool;

@Repository(value="toolaction")
@Scope("prototype")
public class ToolAction {

	
	@Autowired
	ToolDao toolDao;
	
	
	
	public String xianshiTool()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		
		List<Tool> ttl = toolDao.findAllTools();
		
		if(ttl.isEmpty())
		{
			return "notool";
		}
		
		request.setAttribute("tl", ttl);
		
		return "success";
	}
	
	public String AddTool()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String xgjname = request.getParameter("xgj");
		
		//��û���Ѿ�����ù���
		if(toolDao.isyouTool(xgjname)==false)
			return "youle";
		
		toolDao.AddTools(xgjname);
		
		
		
		return "success";
	}
	
	
	
	
	
	
	public String ChangeWear()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String gjname = request.getParameter("ggjm");
		String gnjd = request.getParameter("njd");
		
		if(gnjd.equals("����")||gnjd.equals("��"))
		{
			if(toolDao.isyouTool(gjname)==false)
			{
				toolDao.ChangeWear(gjname, gnjd);
				return "success";
			}
			else
				return "shibai";
		}
		else
		return "shibai";
	}
	
	
	public String jiechuT()
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String Xname = (String)session.get("sn");
		
		String Tname = request.getParameter("jgj");
		
		
		//����û���������
		if(toolDao.isyouTool(Tname) == true)
		{
			System.out.println("1ִ��");
			return "notool";
		}
		
		//�����������û���ѱ����û����
		if(toolDao.isBorrow(Xname, Tname)==false)
		{
			System.out.println("2ִ��");
			return "notool";
		}
		
		//���;�
		if(toolDao.naijiu(Tname)==false)
		{
			System.out.println("3ִ��");
			return "notool";
		}
		
		
		
		toolDao.BorrowTools(Xname, Tname);
		toolDao.AddSendBackTools(Xname, Tname);
		
		
		return "success";
	}
	
	
	
	public String XBorrowgj()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String name = (String)session.get("sn");
		
		List<BorrowT> btl = toolDao.findBorrowinfo(name);
		
		request.setAttribute("bbtl", btl);
		
		return "success";
	}
	
	
	
	
	
	
	public String huanruT()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String Xname = (String)session.get("sn");
		
		String Tname = request.getParameter("hgj");
		
		
		//�����������û�л���
		if(toolDao.isSendBack(Xname, Tname)==false)
		{
			return "nosend";
		}
		
		//����
		toolDao.SendBackTools(Xname, Tname);
		//ɾ�������¼
		toolDao.SendBackToolsBorrow(Xname, Tname);
		return "success";
	}
	
	public String Xhuanru()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String name = (String)session.get("sn");
		
		List<Sdback> ssdd = toolDao.findSendBackInfo(name);
		
		
		request.setAttribute("sd", ssdd);
		
		return "success";
	}
	
	
	
	
	public String TongjiBandS()
	{
//		
		HttpServletRequest request = ServletActionContext.getRequest();
//		ActionContext actionContext = ActionContext.getContext();
//		Map session = actionContext.getSession();
		
		//��¼��ѧ��
		
		//�ж�ѧ���Ƿ����
		
		List<BorrowT> bList = toolDao.findAllBorrowT();
		int allcount = 0;
		
		for(BorrowT bt :bList)
		{
			System.out.println("1zhixig");
			if( toolDao.isBandS(bt.getBtsname())==false)
			{
				System.out.println("2zhixig");
				boolean is =toolDao.isBandS(bt.getBtsname());		
				System.out.println(is);
				System.out.println(bt.getBtsname());
				toolDao.addBandS(bt.getBtsname());
			}
		}
		
		
		
			
		//�����ѧ��������� �����뵽BandSre����
		for(BorrowT bbT : bList)
		{
			System.out.println("3ִ��");
			if(toolDao.isBandS(bbT.getBtsname())==true)
			{
				System.out.println("4ִ��");
				int i = 0;
				i = toolDao.BorrowCount(bbT.getBtsname());
//				allcount+=i;
//				System.out.println(allcount+" "+i);
				toolDao.addBandScount(bbT.getBtsname(), i+"");
			}
		}
		
//	
		List<BandSre> brel = toolDao.findAllBandSre();
		for(BorrowT sre :bList)
		{
			System.out.println(allcount);
			allcount += 1;
		}
		System.out.println(allcount);
		//�浽����
		//�ѱ��͵�ǰ̨
		request.setAttribute("brl", brel);
		request.setAttribute("alc", allcount);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
