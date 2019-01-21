package work.util;

import work.control.dao.UserCfgDAO;
import work.control.pojo.UserCfg;

public class UserUtil {

	public String chuOrPosToChu(String para)
	{
		if(para.isEmpty()||para.length()==0)
		{
			return "";
		}
		else
		{
			UserCfgDAO ucdao = new UserCfgDAO();
			String chu = "";
			if(para.length()>4)
			{
				chu = para.substring(2, 3);
			}
			else
			{
				chu = para.substring(0, 1);
			}
			UserCfg uc = ucdao.findUcByTypeAndNum("chu",chu);
			return uc.getNamec();
		}
	}
	public String chuIntToChu(int para)
	{
		String paras = String.valueOf(para);
		return chuOrPosToChu(paras);
	}
	public String PosToTeam(String para)
	{
		if(para.isEmpty()||para.length()<5)
		{
			return "";
		}
		else
		{
			UserCfgDAO ucdao = new UserCfgDAO();
			String chu = para.substring(2, 3);
			int zu = Integer.valueOf(para.substring(4, 5));
			return ucdao.findAllByTypeNumIndSc("chu",chu,zu);
		}
	}
}
