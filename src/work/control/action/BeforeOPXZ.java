package work.control.action;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import work.control.pojo.CfgXz;
import work.control.pojo.CfgXzShowBean;
import ccb.hibernate.HibernateSessionFactory;

public class BeforeOPXZ {

	private List<CfgXzShowBean> list;
	public List<CfgXzShowBean> getList() {
		return list;
	}
	public void setList(List<CfgXzShowBean> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		int m=0;//发现新item时的i位置
		int n=1;//相同item的个数
		int bj=0;//表格背景
		int xuhao=0;//大项序号
		int j=0;//实际真实的序号
		String hql = "";
		String temp="";//temp item内容
		list = new ArrayList<CfgXzShowBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from CfgXz as cx order by cx.indx,cx.type,cx.cnum";
			List<CfgXz> listcx = session.createQuery(hql).list();
			for(int i=0;i<listcx.size();i++)
			{
				CfgXz cx = listcx.get(i);
				CfgXzShowBean cxsb = new CfgXzShowBean();
				cxsb.setId(cx.getId());
				cxsb.setType(cx.getType());
				cxsb.setContent(cx.getContent());
				cxsb.setDetail(cx.getDetail());
				cxsb.setRowsp(1);
				list.add(cxsb);
				if(temp.equals(cxsb.getType()))
				{
					n+=1;
					list.get(j).setRowsp(0);
				}
				else
				{
					list.get(m).setRowsp(n);
					if(bj==1)
					{
						bj=0;
					}
					else
					{
						bj=1;
					}
					xuhao+=1;
					m=j;
					n=1;
				}
				list.get(j).setBeijing(bj);
				list.get(j).setIndx(xuhao-1);
				temp = cx.getType();
				j+=1;
			}
			list.get(m).setRowsp(n);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
		
	}
	
}
