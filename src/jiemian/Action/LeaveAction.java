package jiemian.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.stream.buffer.sax.SAXBufferProcessor;

import jiemian.Dao.LeaveDao;
import jiemian.entities.qJinfo;

@Repository("leaveaction")
@Scope("prototype")
public class LeaveAction {
	
	
	
	
	@Autowired
	LeaveDao leavedao;
	
	public String addqingjiaxinxi()
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String sname = (String)session.get("sn");
		String ly = request.getParameter("qjly");
		
		if(ly.length()>=225||ly.length()==0)
		{
			return "error";
		}
		
		
		//���ѧ����û�����
		
		if(leavedao.isQjingJia(sname)==true)
		{
			System.out.println(leavedao.isQjingJia(sname));			
			return "error";
		}
		
		//¼���ѧ���������Ϣ������ʵ���Ͷ�Ĭ������Ϊ'δ��ʵ''��ɨ����'
		
		
		leavedao.addXqjinfo(sname, ly);
		System.out.println(ly);
		
		return "success";
	}
	
	
	
	
	public String showSQJinfo()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String sname = (String)session.get("sn");
		
		
		List<qJinfo> lqj = leavedao.findSqinfo(sname);
		
		
		request.setAttribute("sqj", lqj);
		
		
		
		
		
		return "success";
	}
	
	//�������
	public String removeQj()
	{
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		String sname = (String)session.get("sn");
		
		//�����û�����
		if( leavedao.isQjingJia(sname) == false)
		{
			return "mqingjia";
		}
		
		
		leavedao.chexiaoqingjia(sname);
		
		return "success";
		
		
	}
	
	public String TfindAllleaveinfo()
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<qJinfo> qjll = leavedao.findAllqjinfo();
		
		
		request.setAttribute("tqjinfo", qjll);
		
		
		
		
		
		return "success";
	}
	
	
	public String Tpizhun()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String sname = request.getParameter("qjxsm");
		
		String pizhun = request.getParameter("pz");
		
		System.out.println(sname);
		System.out.println(pizhun);
		if(pizhun.equals("��׼"))
		{
			
			
			//����û�����ѧ��
			if(leavedao.isQjingJia(sname)==false)
			{
				System.out.println("1ִ��");
				return "error";
			}
			
			//���Ƿ��Ѿ���׼
			
			
			if(leavedao.isPiZhun(sname)==true)
			{
				System.out.println("2ִ��");
				return "error";
			}
			//��׼��ѧ��
			leavedao.PiZhun(sname);
			return "success";
		}else{
		return "error";
	    }
	  
	}
	
	
}
