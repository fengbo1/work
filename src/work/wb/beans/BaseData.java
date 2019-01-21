package work.wb.beans;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import work.util.GeneralCheck;
import work.wb.dao.WbBaseDAO;
import work.wb.dao.WbInitDAO;
import work.wb.pojo.WbBase;

import work.wb.pojo.WbInit;

public class BaseData {

	private static Logger logger = Logger.getLogger(BaseData.class);

	/**
	 * 对外包数据进行处理并存入数据库，暂时只有891
	 * 
	 * @param listPool
	 * @param type
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String operateWb(String type, String date) {

		ArrayList<WbInit> initlist = new ArrayList<WbInit>();
		WbBaseDAO basedao = new WbBaseDAO();
		WbInitDAO initdao = new WbInitDAO();
		GeneralCheck check = new GeneralCheck();
		Query query;
		String no = "";
		Transaction trans = null;
		Session session = HibernateSessionFactory.getSession();
		try {
			trans = session.beginTransaction();
			ArrayList<String> listno = new ArrayList<String>();
			// 删除基础数据表中日期date的数据
			String sqltemp = "delete from t_wb_base where date='" + date + "'";
			session.createSQLQuery(sqltemp).executeUpdate();

			String sql = "select distinct no from t_wb_init where pool=:p";// 查找Pool中891唯一的no
																			// list
			query = session.createSQLQuery(sql);
			query.setString("p", "891");

			listno = (ArrayList<String>) query.list();

			for (int i = 0; i < listno.size(); i++) {
				int flag = 0;// 判断操作者是否只做了4项业务中的一项
				int ywl_1 = 0;
				int ywl_2 = 0;
				double avertime_1 = 0;
				double avertime_2 = 0;
				int cc_1 = 0;
				int cc_2 = 0;
				int hs_1 = 0;
				int hs_2 = 0;
				int zlrxg_1 = 0;
				int zlrxg_2 = 0;
				int zyxcf_1 = 0;
				int zyxcf_2 = 0;

				initlist = (ArrayList<WbInit>) initdao.findByNo(listno.get(i));
				WbInit init = new WbInit();
				WbBase base = new WbBase();
				for (int j = 0; j < initlist.size(); j++) 
				{
					init = initlist.get(j);
					no = init.getNo();
					// 1:一次录入 2：二次录入 3：人工辅助验印 4：录入仲裁
					switch (init.getStep()) {
					case 1: {
						ywl_1 = init.getYwl();
						avertime_1 = init.getAverTime();
						cc_1 = init.getCc();
						hs_1 = init.getHs();
						zlrxg_1 = init.getZlrxg();
						zyxcf_1 = init.getZyxcf();
						flag = flag + 1;
						break;
					}
					case 2: {
						ywl_2 = init.getYwl();
						avertime_2 = init.getAverTime();
						cc_2 = init.getCc();
						hs_2 = init.getHs();
						zlrxg_2 = init.getZlrxg();
						zyxcf_2 = init.getZyxcf();
						flag = flag + 1;
						break;
					}
					case 3: {
						base.setFzyy(init.getYwl());
						base.setFzyyTime(init.getAverTime());
						base.setFzyyCc(init.getCc());
						/* 比率保留小数点后四位 */
						base.setFzyyCcl(check.DoubleTo4(division(init.getCc(),
								init.getYwl())));
						base.setFzyyHs(init.getHs());
						base.setFzyyHsl(check.DoubleTo4(division(init.getHs(),
								init.getYwl())));
						base.setFzyyTime(init.getAverTime());
						flag = flag + 1;
						break;
					}
					case 4: {
						base.setLrzc(init.getYwl());
						base.setLrzcTime(init.getAverTime());
						base.setLrzcCc(init.getCc());
						base.setLrzcCcl(check.DoubleTo4(division(init.getCc(),
								init.getYwl())));
						base.setLrzcHs(init.getHs());
						base.setLrzcHsl(check.DoubleTo4(division(init.getHs(),
								init.getYwl())));
						base.setLrzcZl(init.getZlrxg());
						base.setLrzcZll(check.DoubleTo4(division(init
								.getZlrxg(), init.getYwl())));
						flag = flag + 1;
						break;
					}

					default:
						break;
					}
				}
				if (flag > 0)// 如果做了其中一项,则保存
				{
					base.setNo(init.getNo());
					base.setName(init.getName());
					base.setDate(date);
					base.setYslr(ywl_1 + ywl_2);
					base.setDate(date);
					base.setYslr(check.IsNullInteger(base.getYslr()));
					base.setYslrTime(check.IsNullDouble(base.getYslrTime()));
					base.setLrzc(check.IsNullInteger(base.getLrzc()));
					base.setFzyy(check.IsNullInteger(base.getFzyy()));
					base.setLrzcTime(check.IsNullDouble(base.getLrzcTime()));
					base.setFzyyTime(check.IsNullDouble(base.getFzyyTime()));
					if (base.getYslr() > 0) 
					{
						base.setYslrZl(zlrxg_1 + zlrxg_2);
						base.setYslrZy(zyxcf_1 + zyxcf_2);
						base.setYslrCc(cc_1 + cc_2);
						base.setYslrHs(hs_1 + hs_2);
						base.setYslrCcl(check.DoubleTo4(division(check
								.IsNullInteger(base.getYslrCc()), base
								.getYslr())));
						base.setYslrHsl(check.DoubleTo4(division(check
								.IsNullInteger(base.getYslrHs()), base
								.getYslr())));
						base.setYslrZll(check.DoubleTo4(division(check
								.IsNullInteger(base.getYslrZl()), base
								.getYslr())));
						base.setYslrZyl(check.DoubleTo4(division(check
								.IsNullInteger(base.getYslrZy()), base
								.getYslr())));
						base.setYslrTime(check.DoubleTo2(division((ywl_1
								* avertime_1 + ywl_2 * avertime_2),
								(ywl_1 + ywl_2))));

					}
					double sum_time = (ywl_1 * avertime_1 + ywl_2 * avertime_2)
							+ base.getLrzcTime() * base.getLrzc()
							+ base.getFzyyTime() * base.getFzyy();
					base.setWorkFzyy(check.DoubleTo2(division(base.getFzyy()
							* base.getFzyyTime(), 3600)));
					base.setWorkLrzc(check.DoubleTo2(division(base.getLrzc()
							* base.getLrzcTime(), 3600)));
					base.setWorkYslr(check.DoubleTo2(division(ywl_1
							* avertime_1 + ywl_2 * avertime_2, 3600)));
					base.setWorkTime(check.DoubleTo2(division(sum_time, 3600)));
					basedao.save(base);
				}

			}
		} catch (Exception e) {
			System.out.println(no);
			trans.rollback();
			e.printStackTrace();
			logger.info(e);
			return "工号：" + no + " 导入失败请检查格式";
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();

		}
		return "success";
	}

	public double division(double fenzi, double fenmu) {
		if ((fenzi < 0.0000001) && (fenzi > -0.0000001)) {
			return 0.0;
		} else if (fenmu < 0.0000001 && fenmu > -0.0000001) {
			return 0.0;
		} else {
			double tmp = fenzi / fenmu;
			return fenzi / fenmu;
		}
	}

}
