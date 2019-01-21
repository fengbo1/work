package work.ygxy.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import work.util.ExportExcel;
import work.util.GeneralCheck;
import work.util.Tld;
import work.ygxy.pojo.Ygxy;
import work.ygxy.pojo.YgxyBean;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 员工响应明细表导出
 * @author htzx
 *
 */
public class MxbExpress {

	private String Path;
	private String bgdate;
	private String eddate;
	
	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getBgdate() {
		return bgdate;
	}

	public void setBgdate(String bgdate) {
		this.bgdate = bgdate;
	}

	public String getEddate() {
		return eddate;
	}

	public void setEddate(String eddate) {
		this.eddate = eddate;
	}

	public String execute() throws Exception{
		String filePath = "";
		bgdate = bgdate.replace("-","");
		eddate = eddate.replace("-","");
		filePath=Tld.downloadpath+bgdate+"-"+eddate+"ygxymxb.xls";
		return express(filePath);
	}
	
	public String express(String filePath) throws UnsupportedEncodingException
	{
		GeneralCheck check = new GeneralCheck();
		List<Ygxy> list = new ArrayList<Ygxy>();
		ExportExcel<YgxyBean> ex = new ExportExcel<YgxyBean>();
		String[] headers = { "日期","姓名","职位","一话登陆时长"
				,"一话小休率","一话应答电话量","一话平均应答时长"
				,"一话平均事后处理时长","一话呼出电话数"
				,"一话平均呼出时长","一话平均处理时长"
				,"一话升级量","一话废弃量","一话放弃量"
				,"一话团队外转接量","一话退补截屏量"
				,"一话工单聚类量","一话一级答复量"
				,"一话一级答复率","一工当日经手量"
				,"一工一级平均处理时长","一工升级量"
				,"一工放弃量","一工退补截屏量"
				,"一工工单聚类量","一工一级答复量"
				,"一工一级答复率","二工当日经手量"
				,"二工二级平均处理时长","二工内部转交量"
				,"二工放弃量","二工退补截屏量"
				,"二工工单聚类量","二工二级答复量"
				,"二工二级答复率","二工转三级量"
				,"二工转三级率","工作时长","离线时长"
				,"工单折算量","作业时长","工单折算得分"
		};
        
        Path = bgdate+"-"+eddate+"ygxymxb.xls";
       //数据库条件查询
		
		Query query;
		String hql="from Ygxy as a where a.date>='"+bgdate+"' and a.date<='"+eddate+"' order by a.date";
		System.out.println(hql);
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		//list转存
		List<YgxyBean> listygxy = new ArrayList<YgxyBean>();
		for(int i=0;i<list.size();i++)
		{
			YgxyBean yb = new YgxyBean();
			Ygxy ygxy = list.get(i);
			yb.setDate(ygxy.getDate());
			yb.setName(ygxy.getName());
			yb.setPosition(ygxy.getPosition());
			yb.setFtDlsc(ygxy.getFtDlsc());
			yb.setFtXxlv(ygxy.getFtXxlv());
			yb.setFtYddh(ygxy.getFtYddh());
			yb.setFtPjydsc(ygxy.getFtPjydsc());
			yb.setFtPjshsc(ygxy.getFtPjshsc());
			yb.setFtHcdhs(ygxy.getFtHcdhs());
			yb.setFtPjclsc(ygxy.getFtPjclsc());
			yb.setFtSjl(check.IsNullInteger(ygxy.getFtSjl()));
			yb.setFtFeiql(check.IsNullInteger(ygxy.getFtFeiql()));
			yb.setFtFangql(check.IsNullInteger(ygxy.getFtFangql()));
			yb.setFtTdwzjl(check.IsNullInteger(ygxy.getFtTdwzjl()));
			yb.setFtTbjpl(check.IsNullInteger(ygxy.getFtTbjpl()));
			yb.setFtGdjll(check.IsNullInteger(ygxy.getFtGdjll()));
			yb.setFtYjdfl(check.IsNullInteger(ygxy.getFtYjdfl()));
			yb.setFtYjdflv(ygxy.getFtYjdflv());
			yb.setFeDrjsl(ygxy.getFeDrjsl());
			yb.setFeYjpjclsc(ygxy.getFeYjpjclsc());
			yb.setFeSjl(check.IsNullInteger(ygxy.getFeSjl()));
			yb.setFeFangql(check.IsNullInteger(ygxy.getFeFangql()));
			yb.setFeTbjpl(check.IsNullInteger(ygxy.getFeTbjpl()));
			yb.setFeGdjll(check.IsNullInteger(ygxy.getFeGdjll()));
			yb.setFeYjdfl(check.IsNullInteger(ygxy.getFeYjdfl()));
			yb.setFeYjdflv(ygxy.getFeYjdflv());
			yb.setSteDrjsl(ygxy.getSteDrjsl());
			yb.setSteEjpjclsc(ygxy.getSteEjpjclsc());
			yb.setSteNbzjl(check.IsNullInteger(ygxy.getSteNbzjl()));
			yb.setSteFangql(check.IsNullInteger(ygxy.getSteFangql()));
			yb.setSteTpjpl(check.IsNullInteger(ygxy.getSteTpjpl()));
			yb.setSteGdjll(check.IsNullInteger(ygxy.getSteGdjll()));
			yb.setSteEjdfl(check.IsNullInteger(ygxy.getSteEjdfl()));
			yb.setSteEjdflv(ygxy.getSteEjdflv());
			yb.setSteZsjl(check.IsNullInteger(ygxy.getSteZsjl()));
			yb.setSteZsjlv(ygxy.getSteZsjlv());
			yb.setGzsc(ygxy.getGzsc());
			yb.setLxsc(ygxy.getLxsc());
			yb.setGdl(ygxy.getGdl());
			yb.setZysc(ygxy.getZysc());
			yb.setXyqqzsl(ygxy.getXyqqzsl());
			
			listygxy.add(yb);
		}
		//导出
		 try {
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("员工响应个人明细日报表",headers, listygxy, out);
				out.close();
				System.out.println("excel导出成功！");
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
}
